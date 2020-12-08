public class MainProgram {

    public static void main(String[] args){

        String countryIdentifier = args[0];
        String bankIdentifier = args[1];
        String accountNumber = args[2];

        IbanCreator iban = new IbanCreator(countryIdentifier, bankIdentifier, accountNumber);
        System.out.println(args[0]);
    }
}