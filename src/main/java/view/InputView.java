package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.REGEXP;
import static util.ErrorMessage.INVALID_NOT_NUMBER;

public class InputView {

    /* 로또 구입 금액 입력 */
    public int getMoney(){
        int money;
        try {
            money = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(INVALID_NOT_NUMBER.getErrorMessage());
        }
        return money;
    }

    /* 당첨 번호 만들기 */
    public List<Integer> createWinningNumbers() {
        String[] numberArr = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : numberArr) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public void resetList(int lottoCount,List<List<Integer>> numberList) {
        for(int i=0;i<numberList.size();i++)
            numberList.add(new ArrayList<>());
    }

    /* 보너스 넘버 입력 */
    public int bonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
