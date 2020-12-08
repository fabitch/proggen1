import java.math.*;
/**
 *Creats an IBAN from a country Identifier, bank identifier and the account number
 *@author Fabian Dill
 *
 */
public class IbanCreator {
    String countryIdentifier;
    int bankIdentifier;
    BigInteger accountNumber;
    String iban;

    // constructor
    public IbanCreator(String countryIdentifier, String bankIdentifier, String accountNumber) {
        this.countryIdentifier = countryIdentifier;
        this.setAccountNumber(accountNumber);
        this.setBankIdentifier(bankIdentifier);
        this.setIban();
    }

    // create an setter for the iban calling all the computation methods
    public void setIban(){
        String securityCode = this.computeSecurityCode();
        String bankIdentifier = Integer.toString(this.bankIdentifier);
        String accountNumber = Integer.toString(this.accountNumber.intValue());

        this.iban = String.join("", this.countryIdentifier, securityCode, bankIdentifier,
                accountNumber);
    }

    // setter abd getter for each variable
    public String getCountryIdentifier() {
        return countryIdentifier;
    }

    public void setCountryIdentifier(String countryIdentifier) {
        this.countryIdentifier = countryIdentifier;
    }

    public int getBankIdentifier() {
        return bankIdentifier;
    }

    public void setBankIdentifier(String bankIdentifier) {
        this.bankIdentifier = Integer.parseInt(bankIdentifier);
    }

    // Converts string to Big Integer and
    public void setAccountNumber(String accountNumber) {
        long tmp = Long.parseLong(accountNumber);
        this.accountNumber = BigInteger.valueOf(tmp);
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }

    /** create security code from country identifier, account number and bank identifier
     *
     */
    public String computeSecurityCode(){
        String extendedAccountNumber = this.extendAccountNumber();
        String bankIdentifier = Integer.toString(this.bankIdentifier);

        // concatenating these two strings to get 1 long number
        String securityString = String.join("", bankIdentifier, extendedAccountNumber);
        String numericCountryIdentifier = this.computeNumericCountryIdentifier();
        securityString = String.join("", securityString, numericCountryIdentifier);

        BigInteger securityNumber = BigInteger.valueOf(Long.parseLong(securityString));

        securityNumber = securityNumber.mod(BigInteger.valueOf(97));

        BigInteger ninteyEight = BigInteger.valueOf(98);

        int twoDigitsOnly = ninteyEight.subtract(securityNumber).intValue();

        if (twoDigitsOnly < 10){
            return String.join("", "0", Integer.toString(twoDigitsOnly));
        }
        else {
            return Integer.toString(twoDigitsOnly);
        }
    }
    /** The Account Number is supposed to be 10 digits. if it is less than 10 digits leading zeros are added until
     * the the account number is 10 digits
     * @return extendedAccountNumber
     */
    public String extendAccountNumber() {
        String extendedAccountNumber = Integer.toString(this.accountNumber.intValue());
        int length = extendedAccountNumber.length();

        do{
            extendedAccountNumber = String.join("", "0", extendedAccountNumber);
            length ++;
        }while (length < 10);

        return extendedAccountNumber;
    }

    /** This turns the country identifier in a numeric code. For this the characters are turned into integers with A = 1.
     * Each value will be incremented by 9. These two numbers will be put together and two trailing zeros are added.
     */
    public String computeNumericCountryIdentifier(){
        // This gives us the ASCII Values. In ASCII A has the Value 65
        int firstNumber = this.countryIdentifier.charAt(0);
        int secondNumber = this.countryIdentifier.charAt(1);

        // To make A = 1 we need to deduct 65. because we want to increment every value by 9 anyway we can simply
        //  deduct 56
        firstNumber = firstNumber - 56;
        secondNumber = secondNumber - 56;

        //constructing the final numeric country identifier
        return String.join("", Integer.toString(firstNumber), Integer.toString(secondNumber), "00");
    }
}