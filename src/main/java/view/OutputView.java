package view;

import java.math.BigDecimal;
import java.util.List;

import static util.OutputMessage.*;

public class OutputView {
    public void purchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void buyLottoMessage(int count) {
        System.out.println(count + BUY_LOTTO_MESSAGE.getMessage());
    }

    public void winningNumbers() {
        System.out.println(WINNING_NUMBERS.getMessage());
    }

    public void bonusNumber() {
        System.out.println(BONUS_NUMBER.getMessage());
    }

    public void statistics() {
        System.out.println(STATISTICS.getMessage());
    }

    public void numberList(List<Integer> randomNumbers) {
        System.out.println(randomNumbers);
    }
    public void threeMatch(int result) {
        System.out.println(THREE_NUMBER_MATCH.getMessage() + result + A_FEW.getMessage());
    }
    public void fourMatch(int result) {
        System.out.println(FOUR_NUMBER_MATCH.getMessage() + result + A_FEW.getMessage());
    }
    public void fiveMatch(int result) {
        System.out.println(FIVE_NUMBER_MATCH.getMessage() + result + A_FEW.getMessage());
    }
    public void bonusMatch(int result) {
        System.out.println(FIVE_AND_BONUS_NUMBER_MATCH.getMessage() + result + A_FEW.getMessage());
    }
    public void sixMatch(int result) {
        System.out.println(SIX_NUMBER_MATCH.getMessage() + result + A_FEW.getMessage());
    }
    public void rateOfReturn(BigDecimal result){
        StringBuilder sb = new StringBuilder();
        sb.append(RATE_OF_RETURN.getMessage()).append(result).append(PERCENT.getMessage());
        System.out.println(sb);
    }
}
