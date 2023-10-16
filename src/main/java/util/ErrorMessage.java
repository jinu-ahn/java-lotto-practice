package util;

public enum ErrorMessage {
    INVALID_NOT_THOUSAND_DIVIDE_MONEY("1000원 단위로 입력해 주세요."),
    INVALID_OVER_SIZE("로또 번호가 6개이어야 합니다."),
    INVALID_NUMBER_RANGE("1부터 45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATED_NUMBER("중복된 숫자가 있습니다."),
    INVALID_NOT_NUMBER("숫자만 입력해 주세요.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + this.errorMessage;
    }
}
