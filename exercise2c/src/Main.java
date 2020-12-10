import java.util.Arrays;
import java.util.BitSet;

public class Main {

    /**
     * Splits an String into of multiple arrays into an quadratic array
     * @param inputString has to be an comma separated String of arrays
     * @return multi dimensional Array
     */
    // Note: This could be refactored into a class of its own for more readability.
    public static int[][] parseStringToArray(String inputString){
        int [][] square;
        String[] arrayString = inputString.split(";");
        // because the row is still a string there are still commas in the string.
        //  Therefore the String has additional "," in it. A row with 4 digits
        //  therefore will have a length of 7 and so furth. Hence Dividing the
        //  length of s by to and rounding it up will give the correct dimension
        //  for the magic square
        int dimension = Math.round(arrayString[0].length() / 2f);
        square = new int[dimension][dimension];

        int firstDimension = 0;
        for (String s: arrayString){
            String[] row = s.split(",");
            int secondDimension = 0;
            for (String number: row){
                square[firstDimension][secondDimension] = Integer.parseInt(number);
                secondDimension++;
            }
            firstDimension++;
        }
        return square;
    }
    public static void main(String[] args){

        if (args[0].equals("showMagicNumbers")) {
            int dimension = Integer.parseInt(args[1]);
            // initializing the magic square in the right dimensions
            int[][] square = new int[dimension][dimension];

            MagicSquare magicSquare = new MagicSquare(square);
            int[] magicNumbers = magicSquare.showMagicNumbers(dimension);
            System.out.println(Arrays.toString(magicNumbers));
        }
        else {
            if (args[0].equals("isMagicSquare?")) {
                int[][] square = parseStringToArray(args[1]);
                MagicSquare magicSquare = new MagicSquare(square);
                System.out.println(magicSquare.isMagicSquare());
            }
            if (args[0].equals("complement")) {
                int[][] square = parseStringToArray(args[1]);
                MagicSquare magicSquare = new MagicSquare(square);
                System.out.println(magicSquare.toString(true));
            }
        }
    }
}

