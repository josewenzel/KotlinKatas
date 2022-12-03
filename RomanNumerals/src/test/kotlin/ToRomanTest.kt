import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ToRomanTest {
    @Test
    fun `that 1 returns I`() {
        val result = 1.toRoman()
        expectThat(result).isEqualTo("I")
    }

    @Test
    fun `that 2 returns II`() {
        val result = 2.toRoman()
        expectThat(result).isEqualTo("II")
    }
}
