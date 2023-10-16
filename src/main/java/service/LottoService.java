package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.BonusNumber;
import domain.Client;
import domain.Lotto;
import view.InputView;
import view.OutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static util.Constants.*;
public class LottoService {
    private final InputView inputView;
    private final Client client;
    private final Lotto lotto;
    private final BonusNumber bonusNumber;
    private final OutputView outputView;

    private final int[] winningCount = new int[5];
    private final List<List<Integer>> numberList = new ArrayList<>();

    public LottoService() {
        inputView = new InputView();
        outputView = new OutputView();
        client = new Client(inputMoney());
        inputView.resetList(client.getLottoCount(),numberList);
        printNumberList();
        lotto = new Lotto(winningNumbers());
        bonusNumber = new BonusNumber(lotto.getNumbers(),inputBonusNumber());
    }
    /* 로또 구입 */
    private int inputMoney() {
        outputView.purchaseAmountMessage();
        return inputView.getMoney();
    }
    /* 로또 생성 */
    private List<Integer> createNumberList() {
        List<Integer> randomNumbers = client.createRandomNumbers();
        numberList.add(randomNumbers);
        return randomNumbers;
    }
    /* 구입한 로또 번호 리스트 출력*/
    private void printNumberList() {
        outputView.buyLottoMessage(client.getLottoCount());
        for(int i=0;i< client.getLottoCount();i++) {
            outputView.numberList(createNumberList());
        }
    }

    /* 당첨 번호 */
    private List<Integer> winningNumbers() {
        outputView.winningNumbers();
        return inputView.createWinningNumbers();
    }

    /* 보너스 번호 */
    private int inputBonusNumber() {
        outputView.bonusNumber();
        return inputView.bonusNumber();
    }

    /* 당첨 결과 */
    public void winningResult() {
        for(int i=0;i< client.getLottoCount();i++) {
            int result = winningNumberCount(lotto.getNumbers(), numberList.get(i));
            if (result == THREE_MATCH) winningCount[THREE_MATCH_INDEX]++;
            if (result == FOUR_MATCH) winningCount[FOUR_MATCH_INDEX]++;
            if (result == FIVE_MATCH) winningCount[checkBonusNumber(bonusNumber.getBonusNumber(), numberList.get(i))]++;
            if (result == SIX_MATCH) winningCount[SIX_MATCH_INDEX]++;
        }
    }

    /* 보너스 넘버 당첨 확인 */
    private int checkBonusNumber(int bonusNumber, List<Integer> numberList) {
        if(numberList.contains(bonusNumber))
            return FIVE_AND_BONUS_MATCH_INDEX;
        return FIVE_MATCH_INDEX;
    }

    /* 당첨 개수 카운트 */
    private int winningNumberCount(List<Integer> winningNumbers, List<Integer> numbers){
        int count = 0;
        for (Integer number : numbers) {
            if(winningNumbers.contains(number)) count++;
        }
        return count;
    }

    /* 통계 */
    public double printStatistics() {
        double result = 0;
        int threeMatchCount = winningCount[THREE_MATCH_INDEX];
        int fourMatchCount = winningCount[FOUR_MATCH_INDEX];
        int fiveMatchCount = winningCount[FIVE_MATCH_INDEX];
        int bonusMatchCount = winningCount[FIVE_AND_BONUS_MATCH_INDEX];
        int sixMatchCount = winningCount[SIX_MATCH_INDEX];

        outputView.statistics();
        outputView.threeMatch(threeMatchCount);
        result += THREE_MATCH_PRICE * threeMatchCount;
        outputView.fourMatch(fourMatchCount);
        result += FOUR_MATCH_PRICE * fourMatchCount;
        outputView.fiveMatch(fiveMatchCount);
        result += FIVE_MATCH_PRICE * fiveMatchCount;
        outputView.bonusMatch(bonusMatchCount);
        result += FIVE_AND_BONUS_MATCH_PRICE * bonusMatchCount;
        outputView.sixMatch(sixMatchCount);
        result += SIX_MATCH_PRICE * sixMatchCount;

        return result;
    }
    /* 총 수익률 계산 */
    public void rateOfReturn(double result) {
        double money = client.getMoney();
        BigDecimal bd = new BigDecimal((result/money)*ROUND);
        outputView.rateOfReturn(bd.setScale(1,RoundingMode.HALF_UP));
    }
}
