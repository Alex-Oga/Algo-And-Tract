import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        Collections.sort(arr);
        int total = 0;
        for (int i=0; i<arr.size()-1; i++) {
            if (binarySearch(arr, i, arr.size()-1, arr.get(i)+k) == 1)
                total++;
            if (arr.get(i)+k > arr.get(arr.size()-1))
                break;
        }
        return total;
    }
    public static int binarySearch(List<Integer> arr, int l, int r, int x) {
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr.get(m) == x)
                return 1;
            if (arr.get(m) < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> tes = new ArrayList<>();
        tes.add(1);
        tes.add(2);
        tes.add(3);
        tes.add(4);
        System.out.println(pairs(1, tes));

    }
}
