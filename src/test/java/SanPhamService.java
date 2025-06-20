import java.util.ArrayList;
import java.util.List;

public class SanPhamService {

    private List<SanPham> list = new ArrayList<>();

    // CREATE
    public void add(SanPham sp) {
        list.add(sp);
    }

    // READ ALL
    public List<SanPham> getAll() {
        return list;
    }

    // READ BY MA
    public SanPham getByMa(String ma) {
        for (SanPham sp : list) {
            if (sp.ma.equals(ma)) {
                return sp;
            }
        }
        return null;
    }

    // UPDATE
    public boolean update(String ma, SanPham newSanPham) {
        if (newSanPham == null) return false; // <== Thêm dòng này để xử lý null

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ma.equals(ma)) {
                list.set(i, newSanPham);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean removeByMa(String ma) {
        return list.removeIf(sp -> sp.ma.equals(ma));
    }

    // EXISTS
    public boolean isExist(String ma) {
        return list.stream().anyMatch(sp -> sp.ma.equals(ma));
    }

    // TÌM KIẾM THEO TÊN (gần đúng, không phân biệt hoa thường)
    public List<SanPham> searchByTen(String keyword) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sp : list) {
            if (sp.ten.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(sp);
            }
        }
        return result;
    }

}
