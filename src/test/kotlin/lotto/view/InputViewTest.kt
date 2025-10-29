package lotto.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class InputViewTest {

    @Test
    fun `inputPrice 값 입력 확인하기`() {
        val fakeInput = "1000"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())
        System.setIn(inputStream)

        val result = InputView.inputPurchaseAmount()

        assertEquals("1000", result)
    }
}
