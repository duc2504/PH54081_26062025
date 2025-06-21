package de4;
//Sử dụng các kỹ thuật biên/kỹ thuật phân vùng tương đương viết unit test
// để thực hiện chức năng liệt kê các số từ 1 đến 100, bỏ qua các số chia hết cho 5. ( ít nhất 5 unit test)




import org.junit.jupiter.api.Test;

        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;
        import static org.junit.jupiter.api.Assertions.*;

public class phan1 {



    List<Integer> listNumbers() {
        return IntStream.rangeClosed(1, 100)
                .filter(i -> i % 5 != 0)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    void testListSize() {
        assertEquals(80, listNumbers().size()); // Có 20 số chia hết cho 5 từ 1-100
    }

    @Test
    void testNoDivisibleBy5() {
        assertTrue(listNumbers().stream().noneMatch(i -> i % 5 == 0));
    }

    @Test
    void testFirstAndLastElements() {
        List<Integer> result = listNumbers();
        assertEquals(1, result.get(0));
        assertEquals(99, result.get(result.size() - 1));
    }

    @Test
    void testContainsSpecificNumber() {
        assertTrue(listNumbers().contains(7));
        assertFalse(listNumbers().contains(10));
    }

    @Test
    void testAllElementsInRange() {
        assertTrue(listNumbers().stream().allMatch(i -> i >= 1 && i <= 100));
    }
}
