package lotto.enums;

public enum ErrorMessage {
    EMPTY_PURCHASE_AMOUNT("[ERROR] 구입 금액을 입력하지 않았습니다."),
    NOT_A_NUMBER("[ERROR] 구입 금액은 숫자로 입력해야 합니다."),
    INVALID_AMOUNT("[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다."),
    PURCHASE_AMOUNT_TOO_LARGE("[ERROR] 구입 금액이 너무 큽니다."),

    EMPTY_WINNING_NUMBERS("[ERROR] 당첨 번호를 입력하지 않았습니다."),
    INVALID_WINNING_NUMBERS_COUNT("[ERROR] 당첨 번호는 6개의 숫자로 입력해야 합니다."),
    NOT_A_VALID_NUMBER("[ERROR] 당첨 번호는 숫자로 입력해야 합니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 당첨 번호에 중복된 숫자가 포함되어 있습니다."),

    EMPTY_BONUS_NUMBER("[ERROR] 보너스 번호를 입력하지 않았습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자로 입력해야 합니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
