import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> list = new ArrayList<>();

    public void add(SanPham sp) {
        list.add(sp);
    }

    public boolean removeByMa(String ma) {
        return list.removeIf(sp -> sp.ma.equals(ma));
    }

    public boolean isExist(String ma) {
        return list.stream().anyMatch(sp -> sp.ma.equals(ma));
    }

    public List<SanPham> getAll() {
        return list;
    }
}
