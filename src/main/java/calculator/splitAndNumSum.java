package calculator;

public class splitAndNumSum {

    private final String string;

    public splitAndNumSum(String string) {
        this.string = string;
    }

    //문자열에서 쉼표(,) 또는 콜론(:)을 기준으로 분리한 각 숫자의 합 반환.
    public int split(String string) {
        int stringTotalNum = 0;

        String[] numbers = string.split(",|:");

        for (String s : numbers) {
            stringTotalNum = getStringTotalNum(stringTotalNum, s);
        }

        return stringTotalNum;
    }

    //분리된 string형 숫자를 int형으로 바꾸어 더하기 연산 후 반환
    private static int getStringTotalNum(int stringTotalNum, String splitString) {
        stringTotalNum += Integer.parseInt(splitString);
        return stringTotalNum;
    }

}

//잘못된 값을 입력한 경우 예외 처리.
//"//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 지정할 수 있음


