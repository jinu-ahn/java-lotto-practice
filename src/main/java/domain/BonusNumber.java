package domain;

import util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.MAX_NUMBER_SIZE;
import static util.Constants.REGEXP;
import static util.ErrorMessage.*;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(List<Integer> numbers,int bonusNumber) {
        isNumber(bonusNumber);
        isOverNumber(bonusNumber);
        duplicateNumber(numbers,bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    /* 중복 숫자 확인 */
    private  void duplicateNumber(List<Integer> numbers,int bonusNumber) {
        if(numbers.contains(bonusNumber))
            throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER.getErrorMessage());
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
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
