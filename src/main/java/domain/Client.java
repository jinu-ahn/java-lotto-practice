package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static util.ErrorMessage.INVALID_NOT_THOUSAND_DIVIDE_MONEY;
import static util.Constants.*;

public class Client {
    private final int money;

    public Client(int money) {
        this.money = money;
    }

    /* 랜덤한 6개의 서로 다른 번호 생성 */
    public List<Integer> createRandomNumbers() {
        List<Integer> numbers;
        do {
            numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_SIZE);
        } while (duplicatedNumber(numbers) != MAX_SIZE);
        Collections.sort(numbers);
        return numbers;
    }

    /* 중복된 숫자 검증 */
    private int duplicatedNumber(List<Integer>numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        return set.size();
    }

    /* 구입한 로또 개수 */
    public int getLottoCount() {
        if(money % DIVIDE != ZERO) {
            throw new IllegalArgumentException(INVALID_NOT_THOUSAND_DIVIDE_MONEY.getErrorMessage());
        }
        return money / DIVIDE;
    }

    public double getMoney() {
        return this.money;
    }


}
