package calculator;

public class splitAndNumSum {

    private final String string;

    public splitAndNumSum(String string) {
        this.string = string;
    }

    //문자열에서 쉼표(,) 또는 콜론(:)을 기준으로 분리한 각 숫자의 합 반환.
    public int split(String string) {
        int stringTotalNum = 0;

        // null 이거나 빈 문자열이 들어오면 0
        if (string == null || string.isEmpty()) return 0;

        String[] numbers = string.split(",|:");

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

}

//"//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있음


