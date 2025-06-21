package de2;



        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class phan1_de2 {

    // Hàm kiểm tra số lẻ
    public boolean laSoLe(int n) {
        return n % 2 != 0;
    }

    @Test
    void testSoLe_1() {
        assertTrue(laSoLe(1)); // Biên trái
    }

    @Test
    void testSoChan_2() {
        assertFalse(laSoLe(2)); // Biên phải
    }

    @Test
    void testSoLeAm() {
        assertTrue(laSoLe(-3)); // Số lẻ âm
    }

    @Test
    void testSoChanLon() {
        assertFalse(laSoLe(10000)); // Số chẵn lớn
    }

    @Test
    void testSoLeLon() {
        assertTrue(laSoLe(9999)); // Số lẻ lớn
    }
}

