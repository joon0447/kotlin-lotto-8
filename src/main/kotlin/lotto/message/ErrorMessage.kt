package lotto.message


enum class ErrorMessage(val text: String) {
    AMOUNT_IS_LESS_THAN_ONE_THOUSAND("구입 금액은 1000원 이상이어야 합니다."),
    AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND("구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    AMOUNT_IS_NOT_NUMBER("구입 금액은 숫자이어야 합니다."),

    INVALID_WINNING_NUMBERS_COUNT("당첨 번호의 개수는 6개이어야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("모든 당첨 번호는 숫자이어야 합니다."),
    INVALID_WINNING_NUMBERS_RANGE("모든 당첨 번호는 1~45 사이의 숫자이여야 합니다.");

    fun formattedText(): String {
        return "[ERROR] $text"
    }
}