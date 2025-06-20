import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SanPhamServiceTest {
    SanPhamService service;

    @BeforeEach
    void setUp() {
        service = new SanPhamService();
        service.add(new SanPham("SP01", "Điện thoại", 2023, 1000, 5, "Công nghệ"));
    }

    @Test
    void testRemoveTonTai() {
        assertTrue(service.removeByMa("SP01"));
    }

    @Test
    void testRemoveKhongTonTai() {
        assertFalse(service.removeByMa("SP02"));
    }

    @Test
    void testMaTonTai() {
        assertTrue(service.isExist("SP01"));
    }

    @Test
    void testMaKhongTonTai() {
        assertFalse(service.isExist("XXX"));
    }
}
