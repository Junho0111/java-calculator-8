package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class splitAndNumSum {

    private final String string;

    public splitAndNumSum(String string) {
        this.string = string;
    }

    public int split(String string) {
        int stringTotalNum = 0;
        String regex = ",|:";

        if (string == null || string.isEmpty()) return 0;

        String findCustom = customCheck(string);

        if(findCustom != null) {
            regex += "|" + findCustom;
            string = newString(string, findCustom);
        }

        String[] numbers = string.split(regex);

        for (String s : numbers) {
            int number;

            try {
                if (s.isEmpty()) continue;

                number = Integer.parseInt(s);

                if (number < 0) throw new IllegalArgumentException("양수가 아닌 숫자가 포함되어 있습니다.");

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
            }

            stringTotalNum += number;
        }

        return stringTotalNum;
    }

    private static String newString(String string, String findCustom) {
        string = string.replace("//" + findCustom + "\n", "");
        string = string.replace("//" + findCustom + "\\n", "");
        return string;
    }

    //"//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있음
    public String customCheck(String string) {
        Pattern pattern = Pattern.compile("//(.*?)(\\\\n|\n)");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }


}









