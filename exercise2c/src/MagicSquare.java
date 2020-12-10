import java.util.Arrays;

public class MagicSquare {
    int[][] square;
    int magicNumber;
    int[][] complement;

    public MagicSquare(int[][] square) {
        this.square = square;
        this.magicNumber = getNthMagicalNumber();
        this.complement = computeComplement();
    }

    public String toString(boolean convertComplement){
        int[][] convertible = square;
        StringBuilder output = new StringBuilder();
        if (convertComplement){
            convertible = complement;
        }
        for (int row = 0; row < convertible.length; row++){
            for (int col = 0; col < convertible.length; col++){
                output.append(convertible[row][col] + " ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public String isMagicSquare(){
        if (checkIfColsAreMagic() & checkIfRowsAreMagic()){
            if (checkIfLeftDiagonalIsMagic() & checkIfRightDiagonalIsMagic()){
                return "magical square";
            }
            return "semimagic square";
        }
        return "not magical";
    }

    /**
     * Calculates the sum of the diagonal left to right
     * @return sum of the diagonal starting at (0,0)
     */
    public boolean checkIfLeftDiagonalIsMagic(){
        int sum = 0;
        for (int i = 0; i < square.length; i++){
            sum += square[i][i];
        }
        return sum == magicNumber;
    }
    /**
     * Calculates the sum of the diagonal right to left
     * @return sum of the diagonal starting at (0,n)
     */
    public boolean checkIfRightDiagonalIsMagic(){
        int sum = 0;
        int column = square.length - 1;
        for (int row = 0; row < square.length; row++){
            sum += square[row][column];
            column--;
        }
        return sum == magicNumber;
    }

    public boolean checkIfRowsAreMagic(){
        int magicalNumber = getNthMagicalNumber();
        // now we compute the total of all subsequent rows
        int rowSum = 0;
        for (int row = 1; row < square.length; row++){
            for (int col = 0; col < square.length; col++){
                rowSum += square[row][col];
            }
            if (rowSum != magicalNumber){
                return false;
            }
            // resetting the sum
            else{
                rowSum = 0;
            }
        }
        return true;
    }

    public boolean checkIfColsAreMagic(){
        int magicalNumber = getNthMagicalNumber();
        int colSum = 0;
        for (int col = 1; col < square.length; col++){
            for (int row = 0; row < square.length; row++){
                colSum += square[row][col];
            }
            if (colSum != magicalNumber){
                return false;
            }
            else{
                colSum = 0;
            }
        }
        return true;
    }

    public int[] showMagicNumbers(int k){
        int [] magicNumbers = new int[k];
        double power = 3;

        for (int count = 0; count < k; count++){
            int magicNumber;
            int n = count + 1;

            magicNumber = (int) Math.pow(n, power) + n;
            magicNumber = magicNumber / 2;

            magicNumbers[count] = magicNumber;
        }
        return magicNumbers;
    }

    public int[][] computeComplement(){
        int[][] complement = new int[square.length][square.length];
        int n = square.length;

        for (int row = 0; row < square.length; row++){
            for (int col = 0; col < square.length; col++){
                complement[row][col] = square[row][col] * - 1;
                complement[row][col] += (Math.pow(n, 2) + 1);
            }
        }
        return complement;
    }

    public int getNthMagicalNumber(){
        return showMagicNumbers(square.length)[square.length - 1];
    }
}
