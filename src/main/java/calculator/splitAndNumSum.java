package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class splitAndNumSum {

    private final String string;

    public splitAndNumSum(String string) {
        this.string = string;
    }

    public int split(String string) {
        if (string == null || string.isEmpty()) return 0;

        String regex = ",|:";
        String findCustom = customCheck(string);

        // 커스텀 구분자가 있으면 regex와 문자열 수정
        if (findCustom != null) {
            regex = newRegex(regex, findCustom);
            string = newString(string, findCustom);
        }

        String[] numbers = string.split(regex);
        return sumNumbers(numbers);
    }

    private String newRegex(String regex, String findCustom) {
        return regex + "|" + findCustom;
    }

    private String newString(String string, String findCustom) {
        string = string.replace("//" + findCustom + "\n", "");
        string = string.replace("//" + findCustom + "\\n", "");
        return string;
    }

    private int sumNumbers(String[] numbers) {
        int stringTotalNum = 0;

        for (String s : numbers) {
            if (s.isEmpty()) continue;

            try {
                int number = parseNumber(s);
                stringTotalNum += number;
            } catch (NumberFormatException e) {
                //구분자로 구분한 덩어리에서 숫자로 바꾸려는데 안바뀌었을때 예외 (뭐야 너 누구야? 느낌)
                throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
            }
        }

        return stringTotalNum;
    }

    private int parseNumber(String s) {
        int number = Integer.parseInt(s);

        if (number < 0) {
            throw new IllegalArgumentException("양수가 아닌 숫자가 포함되어 있습니다.");
        }

        return number;
    }

    private String customCheck(String string) {
        Pattern pattern = Pattern.compile("//(.*?)(\\\\n|\n)");
        Matcher matcher = pattern.matcher(string);

        return matcher.find() ? matcher.group(1) : null;
    }
}
