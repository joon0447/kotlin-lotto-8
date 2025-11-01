package lotto.model

import lotto.constant.Rank
import lotto.constant.message.ErrorMessage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호 정상 입력하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또 번호 중 범위를 벗어난 값이 있으면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1,2,3,-50,100,6))
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText(), exception.message)
    }

    @Test
    fun `로또 당첨 계산`() {
        val winningNumber = listOf(1,2,3,4,5,6)
        val myLotto = mutableListOf<List<Int>>()
        myLotto.add(listOf(1,2,3,4,5,6)) // 1등
        myLotto.add(listOf(1,2,3,4,5,10)) // 2등
        myLotto.add(listOf(1,2,3,4,5,40)) // 3등
        myLotto.add(listOf(1,2,3,4,10,20)) // 4등
        myLotto.add(listOf(1,2,3,10,20,30)) // 5등

        val lotto = Lotto(winningNumber)

        val result = lotto.calculateWinningResults(myLotto, 10)
        assertEquals(1, result[Rank.FIRST])
        assertEquals(1, result[Rank.SECOND])
        assertEquals(1, result[Rank.THIRD])
        assertEquals(1, result[Rank.FOURTH])
        assertEquals(1, result[Rank.FIFTH])
    }

    @Test
    fun `로또 당첨 계산 2`() {
        val winningNumber = listOf(1,2,3,4,5,6)
        val myLotto = mutableListOf<List<Int>>()
        myLotto.add(listOf(1,2,3,4,5,6)) // 1등
        myLotto.add(listOf(1,2,3,4,5,6)) // 1등
        myLotto.add(listOf(1,2,3,10,20,30)) // 5등
        myLotto.add(listOf(1,2,3,10,20,30)) // 5등
        myLotto.add(listOf(1,2,3,10,20,30)) // 5등

        val lotto = Lotto(winningNumber)

        val result = lotto.calculateWinningResults(myLotto, 10)
        assertEquals(2, result[Rank.FIRST])
        assertEquals(0, result[Rank.SECOND])
        assertEquals(0, result[Rank.THIRD])
        assertEquals(0, result[Rank.FOURTH])
        assertEquals(3, result[Rank.FIFTH])
    }
}
