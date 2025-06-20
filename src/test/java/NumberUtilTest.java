import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilTest {

    @Test
    void testNegativeInput() {
        assertEquals(0, NumberUtil.sumOdd(-5));
    }

    @Test
    void testZero() {
        assertEquals(0, NumberUtil.sumOdd(0));
    }

    @Test
    void testOddNumber() {
        assertEquals(9, NumberUtil.sumOdd(5)); // 1+3+5
    }

    @Test
    void testEvenNumber() {
        assertEquals(9, NumberUtil.sumOdd(6)); // 1+3+5
    }
    @Test
    void test() {
        assertEquals(0, NumberUtil.sumOdd(-9)); // 1+3+5
    }
}
