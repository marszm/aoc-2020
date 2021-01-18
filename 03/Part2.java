import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static long countTrees(String[] input, int dy, int dx) {
        final int height = input.length;
        final int width = input[0].length();

        int x = dx;
        int y = dy % width;
        long result = 0;

        while (y < height) {
                if (input[y].charAt(x) == '#') {
                    result += 1;
            }
            y = y + dy;
            x = (x + dx) % width;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        String[] input = null;
        try (var file = new BufferedReader(new FileReader("src/main/java/input.txt"))) {
            input = file
                    .lines().toArray(String[]::new);
        }
        int[][] slopes = {
                {1, 1},
                {1, 3},
                {1, 5},
                {1, 7},
                {2, 1}
        };
        long result = 1;
        for (int[] slope : slopes) {
            result *= countTrees(input, slope[0], slope[1]);
        }
        System.out.println(result);

    }
}