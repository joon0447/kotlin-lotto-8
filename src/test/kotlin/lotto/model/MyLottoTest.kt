package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MyLottoTest {

    private lateinit var myLotto: MyLotto

    @BeforeEach
    fun Setup() {
        myLotto = MyLotto()
    }

    @Test
    fun `생성된 로또 번호 확인`() {
        myLotto.createLottos("3000")
        val lottos = myLotto.getLottos()

        for (lotto in lottos) {
            assertEquals(6, lotto.size)
            assertTrue(lotto.all { it in 1..45 })
        }
    }

    @Test
    fun `로또 생성 개수 확인`() {
        myLotto.createLottos("5000")
        assertEquals(5, myLotto.getLottos().size)
    }
}
