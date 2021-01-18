import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JavaCore {

    static long countTrees(String[] input) {
        final int height = input.length;
        final int width = input[0].length();

        int x = 3 % width;
        int y = 1;
        long result = 0;

        while (y < height) {
            if (input[y].charAt(x) == '#') {
                result += 1;
            }
            y = y + 1;
            x = (x + 3) % width;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        String[] input = null;
        try (var file = new BufferedReader(new FileReader("src/main/java/input.txt"))) {
            input = file
                    .lines().toArray(String[]::new);
        }
        System.out.println(countTrees(input));
    }
}