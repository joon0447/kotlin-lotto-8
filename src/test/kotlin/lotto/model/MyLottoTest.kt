package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MyLottoTest {

    private lateinit var myLotto: MyLotto

    @BeforeEach
    fun `초기 설정`() {
        myLotto = MyLotto()
    }

    @Test
    fun `로또를 발급할 때 모든 로또의 번호가 1~45 범위 안에 속한다`() {
        myLotto.createLottos("3000")
        val lottos = myLotto.getLottos()

        for (lotto in lottos) {
            assertEquals(6, lotto.size)
            assertTrue(lotto.all { it in 1..45 })
        }
    }

    @Test
    fun `로또를 발급할 때 입력한 가격에 맞는 로또 개수를 발급한다`() {
        myLotto.createLottos("5000")
        assertEquals(5, myLotto.getLottos().size)
    }
}
