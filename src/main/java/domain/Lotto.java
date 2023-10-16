package domain;

import util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.MAX_NUMBER_SIZE;
import static util.Constants.REGEXP;
import static util.Constants.MAX_SIZE;
import static util.ErrorMessage.INVALID_NUMBER_RANGE;
import static util.ErrorMessage.INVALID_DUPLICATED_NUMBER;
import static util.ErrorMessage.INVALID_OVER_SIZE;
import static util.ErrorMessage.INVALID_NOT_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException(INVALID_OVER_SIZE.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현

    /* 중복된 숫자가 있는지 확인 */
    private void duplicatedNumber(List<Integer> numbers) {
        boolean[] numberList = new boolean[MAX_NUMBER_SIZE];
        Arrays.fill(numberList,false);

        for (Integer number : numbers) {
            isOverNumber(number);
            isNumber(number);
            try {
                if (numberList[number]) throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER.getErrorMessage());
            }catch(ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER.getErrorMessage());
            }
            numberList[number] = true;
        }
    }

    /* 유효한 범위인지 확인 */
    private void isOverNumber(int number) {
        if (number < Constants.MIN_NUMBER || number > Constants.MAX_NUMBER)
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getErrorMessage());
    }

    /* 입력값이 숫자인지 확인 */
    private void isNumber(int number) {
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(String.valueOf(number));

        if(!matcher.matches()) throw new IllegalArgumentException(INVALID_NOT_NUMBER.getErrorMessage());
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
