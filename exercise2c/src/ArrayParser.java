/**
 * Matches an comma separated array string.
 */

public class ArrayParser {
    int[][] arrayString;
    char arrayDelimiter;
    char elementDelimiter;

    public ArrayParser(String arrayString, char arrayDelimiter,
                       char elementDelimiter) {

        this.arrayDelimiter = arrayDelimiter;


        this.elementDelimiter = elementDelimiter;
    }
}
