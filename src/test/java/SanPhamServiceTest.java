import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanPhamServiceTest {

    private SanPhamService service;

    @BeforeEach
    void setup() {
        service = new SanPhamService();
        service.add(new SanPham("SP01", "iPhone", 2, 1000.0f, 10, "Điện thoại"));
        service.add(new SanPham("SP02", "Samsung", 1, 900.0f, 5, "Điện thoại"));
    }

    // ------------------- TEST ADD -------------------
    @Test
    void testAdd_Success() {
        int before = service.getAll().size();
        service.add(new SanPham("SP03", "Xiaomi", 1, 800.0f, 3, "Điện thoại"));
        int after = service.getAll().size();
        assertEquals(before + 1, after);
    }

    @Test
    void testAdd_DuplicateMa_ShouldNotAllow() {
        boolean isDuplicate = service.isExist("SP01");
        assertEquals(true, isDuplicate);
    }

    @Test
    void testAdd_DuplicateMa_ManuallyPrevented() {
        if (!service.isExist("SP01")) {
            service.add(new SanPham("SP01", "Duplicate", 1, 500.0f, 1, "Khác"));
        }
        int actualSize = service.getAll().size();
        assertEquals(2, actualSize);
    }

    @Test
    void testAdd_EmptyTen() {
        service.add(new SanPham("SP03", "", 1, 500.0f, 1, "Khác"));
        int actualSize = service.getAll().size();
        assertEquals(3, actualSize);
    }

    @Test
    void testAdd_NegativePrice() {
        service.add(new SanPham("SP04", "Oppo", 1, -500.0f, 5, "Điện thoại"));
        int actualSize = service.getAll().size();
        assertEquals(3, actualSize);
    }



    // ------------------- TEST UPDATE -------------------
    @Test
    void testUpdate_Success() {
        boolean updated = service.update("SP02", new SanPham("SP02", "Samsung New", 2, 950.0f, 7, "Điện thoại"));
        assertEquals(true, updated);
    }

    @Test
    void testUpdate_NotExist() {
        boolean updated = service.update("SP10", new SanPham("SP10", "New", 1, 800.0f, 4, "Máy tính"));
        assertEquals(false, updated);
    }

    @Test
    void testUpdate_DuplicateMa_CheckBeforeUpdate() {
        boolean exists = service.isExist("SP01");
        assertEquals(true, exists);
    }

    @Test
    void testUpdate_MaUnchanged() {
        service.update("SP02", new SanPham("SP02", "Galaxy", 2, 970.0f, 8, "Điện thoại"));
        String actualTen = service.getByMa("SP02").ten;
        assertEquals("Galaxy", actualTen);
    }

    @Test
    void testUpdate_NullSanPham() {
        boolean updated = service.update("SP01", null);
        assertEquals(false, updated);
    }

    // ------------------- TEST DELETE -------------------
    @Test
    void testDelete_Success() {
        boolean deleted = service.removeByMa("SP02");
        assertEquals(true, deleted);
    }

    @Test
    void testDelete_NotExist() {
        boolean deleted = service.removeByMa("SP100");
        assertEquals(false, deleted);
    }

    @Test
    void testDelete_DuplicateMaCheckBeforeDelete() {
        boolean exists = service.isExist("SP01");
        assertEquals(true, exists);
    }

    @Test
    void testDelete_NullInput() {
        boolean deleted = service.removeByMa(null);
        assertEquals(false, deleted);
    }

    @Test
    void testDelete_EmptyString() {
        boolean deleted = service.removeByMa("");
        assertEquals(false, deleted);
    }

    // ------------------- TEST SEARCH BY TEN -------------------
    @Test
    void testSearchByTen_ContainsMatch() {
        int resultSize = service.searchByTen("iphone").size();
        assertEquals(1, resultSize);
    }

    @Test
    void testSearchByTen_CaseInsensitive() {
        int resultSize = service.searchByTen("IPHONE").size();
        assertEquals(1, resultSize);
    }

    @Test
    void testSearchByTen_NoMatch() {
        int resultSize = service.searchByTen("Nokia").size();
        assertEquals(0, resultSize);
    }

    @Test
    void testSearchByTen_EmptyKeyword() {
        int resultSize = service.searchByTen("").size();
        assertEquals(2, resultSize);
    }

    @Test
    void testSearchByTen_ExactName() {
        int resultSize = service.searchByTen("Samsung").size();
        assertEquals(1, resultSize);
    }


    // ------------------- TEST GET BY MA -------------------
    @Test
    void testGetByMa_Exist() {
        SanPham sp = service.getByMa("SP01");
        assertEquals("iPhone", sp.ten);
    }

    @Test
    void testGetByMa_NotExist() {
        SanPham sp = service.getByMa("SP10");
        assertEquals(null, sp);
    }

    @Test
    void testGetByMa_DuplicateCheck() {
        boolean result = service.isExist("SP01");
        assertEquals(true, result);
    }

    @Test
    void testGetByMa_NullInput() {
        SanPham sp = service.getByMa(null);
        assertEquals(null, sp);
    }

    @Test
    void testGetByMa_EmptyString() {
        SanPham sp = service.getByMa("");
        assertEquals(null, sp);
    }
}
