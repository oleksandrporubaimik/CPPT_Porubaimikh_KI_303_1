import java.util.Arrays;
import java.util.Scanner;

public class Lab2Porubaimikh303 {
    private int size = 0;
    private char character = ' ';
    private char[][] matrix = null;
    private boolean initialized = false;
    private boolean filled = false;

    /**
     * Prints out the filled matrix
     *
     * @throws RuntimeException if the class was not configured or the matrix was not filled
     */
    public void print() {
        if (!initialized) {
            throw new RuntimeException("Lab2Porubaimikh303 was not configured");
        } else if (!filled) {
            throw new RuntimeException("Matrix was not filled");
        }

        for (char[] line : matrix) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.print('\n');
        }
    }

    /**
     * Prints out the required matrix of provided size with provided filling character
     *
     * @throws RuntimeException if the class was not properly configured with <code>configure</code>
     */
    public void fill() {
        filled = false;
        if (!initialized) {
            throw new RuntimeException("Lab2Porubaimikh303 was not configured");
        }

        matrix = new char[size][];
        for (int line = 0; line < size; line++) {
            matrix[line] = new char[size];
            if (line == 0 || line == size - 1) {
                Arrays.fill(matrix[line], character);
            } else {
                Arrays.fill(matrix[line], ' ');
                matrix[line][0] = matrix[line][size - 1] = character;
            }
        }

        filled = true;
    }

    /**
     * Reads matrix size and filling character
     *
     * @throws RuntimeException on invalid matrix size or filling character input
     */
    public void configure() {
        initialized = false;
        filled = false;
        var scanner = new Scanner(System.in);

        System.out.print("Size: ");
        var size = scanner.nextInt();
        if (size <= 2) {
            throw new RuntimeException("Invalid matrix size");
        }
        this.size = size;

        System.out.print("Filling character: ");
        var characterString = scanner.next();
        if (characterString.isEmpty() || Character.isWhitespace(characterString.charAt(0))) {
            throw new RuntimeException("Invalid filling character");
        }
        this.character = characterString.charAt(0);

        initialized = true;
    }
}
