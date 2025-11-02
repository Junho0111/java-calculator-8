package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        splitAndNumSum test = new splitAndNumSum(input);

        try {
            System.out.println("결과 = " + test.split(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
