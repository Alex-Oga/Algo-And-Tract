import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IceCreamParlor {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        List<Integer> a = new ArrayList<>();
        for (int i=0; i< arr.size()-1; i++) {
            int first = arr.get(i);
            if (first < m) {
                a.add(i+1);
                for (int j=i+1; j<arr.size(); j++) {
                    int second = arr.get(j);
                    if (second < m && first + second == m) {
                        a.add(j+1);
                        return a;
                    }
                }
                a.remove(0);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        List<Integer> tes = new ArrayList<>();
        tes.add(1);
        tes.add(3);
        tes.add(4);
        tes.add(6);
        tes.add(7);
        tes.add(9);
        System.out.println(icecreamParlor(9, tes));
    }

}