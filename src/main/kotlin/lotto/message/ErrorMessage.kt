package lotto.message

enum class ErrorMessage(val text: String) {
    AMOUNT_IS_LESS_THAN_ONE_THOUSAND("[ERROR] 구입 금액은 1000원 이상이어야 합니다."),
    AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    AMOUNT_IS_NOT_NUMBER("[ERROR] 구입 금액은 숫자이어야 합니다.")
}