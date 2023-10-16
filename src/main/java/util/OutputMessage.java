package util;

public enum OutputMessage {
    PURCHASE_AMOUNT_MESSAGE("구입 금액을 입력해 주세요."),
    BUY_LOTTO_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n" + "---"),
    THREE_NUMBER_MATCH("3개 일치 (5,000원) - "),
    FOUR_NUMBER_MATCH("4개 일치 (50,000원) - "),
    FIVE_NUMBER_MATCH("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_NUMBER_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_NUMBER_MATCH("6개 일치 (2,000,000,000원) - "),
    A_FEW("개"),
    RATE_OF_RETURN("총 수익률은 "),
    PERCENT("%입니다.");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
