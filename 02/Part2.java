import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {

        long valid = 0;
        List<String> input = new ArrayList<>();
        try (var file = new BufferedReader(new FileReader("src/main/java/input.txt"))) {
            input = file.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern INPUT_MATCHER = Pattern.compile("^(\\d+)-(\\d+) (\\w): (\\w+)$");
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            Matcher matcher = INPUT_MATCHER.matcher(str);
            if (!matcher.find()) {
                System.out.println("error");
            }
            String pswd = matcher.group(4);
            char policyChar = matcher.group(3).charAt(0);
            int policyIdx1 = Integer.parseInt(matcher.group(1));
            int policyIdx2 = Integer.parseInt(matcher.group(2));
            long count = pswd.chars().filter(c -> c == policyChar).count();

            if ((pswd.length() >= policyIdx1 && pswd.charAt(policyIdx1 - 1) == policyChar)
                    != (pswd.length() >= policyIdx2 && pswd.charAt(policyIdx2 - 1) == policyChar)) {

                valid = valid + 1;

            }
        }
        System.out.println(valid);

    }
}
