package lotto.constant.message


enum class ErrorMessage(val text: String) {
    INVALID_AMOUNT_RANGE("구입 금액은 1000원 이상이어야 합니다."),
    INVALID_AMOUNT_UNIT("구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    INVALID_AMOUNT_FORMAT("구입 금액은 숫자이어야 합니다."),

    INVALID_WINNING_NUMBERS_COUNT("당첨 번호의 개수는 6개이어야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("모든 당첨 번호는 숫자이어야 합니다."),
    INVALID_WINNING_NUMBERS_RANGE("모든 당첨 번호는 1~45 사이의 숫자이여야 합니다."),
    INVALID_WINNING_NUMBERS_DUPLICATE("입력된 당첨 번호 중 중복된 값이 존재합니다."),

    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 숫자이어야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1~45 사이의 숫자이여야 합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE("당첨 번호는 보너스 번호로 사용할 수 없습니다.");

    fun formattedText(): String {
        return "[ERROR] $text"
    }
}