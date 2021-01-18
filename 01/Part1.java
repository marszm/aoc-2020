import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    static int solve(List<Integer> integers) {
        int result = 0;
        for (int i : integers) {
            for (int j : integers) {
                if (i + j == 2020 && i != j) {
                    result = i * j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("src/main/java/input.txt");
        Scanner scanner = new Scanner(filePath);
        List<Integer> file = new ArrayList<>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                file.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        System.out.println(solve(file));
    }
}
