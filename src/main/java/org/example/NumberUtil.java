public class NumberUtil {
    public static int sumOdd(int n) {
        if (n < 1) return 0;
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }
}
