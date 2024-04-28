import java.util.ArrayList;
import java.util.List;

public class TestTwo {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> pairs = new ArrayList<>();
        int smallestNumber = Math.abs(arr.get(0) - arr.get(1));
        pairs = smallerBigger(pairs, arr.get(0), arr.get(1));

        for (int i=0; i<arr.size(); i++) {
            for (int j=i+1; j<arr.size(); j++) {

                int a = arr.get(i);
                int b = arr.get(j);
                int abs = Math.abs(a - b);

                if (i == 0 && j == 1)
                    continue;

                if (abs == smallestNumber) {
                    pairs = sorte(pairs, a);
                    pairs = sorte(pairs, b);
                }
                else if (abs < smallestNumber) {
                    smallestNumber = abs;
                    pairs = new ArrayList<>();
                    pairs = smallerBigger(pairs, a, b);
                }
            }
        }
        return pairs;
    }

    public static List<Integer> sorte(List<Integer> pairs, int one) {
        // Case for Smaller than index 0
        if (one <= pairs.get(0)) {
            pairs.add(0, one);
            return pairs;
        }

        // Case for Bigger than last index
        if (one >= pairs.get(pairs.size()-1)) {
            pairs.add(one);
            return pairs;
        }
        // Loop to check for where to add values a and b, from 2nd to 2nd last index
        for (int i=1; i<pairs.size()-1; i++) {
            if (one <= pairs.get(i)) {
                pairs.add(i, one);
                break;
            }
        }


        return pairs;
    }

    public static List<Integer> smallerBigger(List<Integer> pairs, int a, int b) {

        if (a < b) {
            pairs.add(a);
            pairs.add(b);
        }
        else {
            pairs.add(b);
            pairs.add(a);
        }
        return pairs;
    }

    public static void main(String[] args) {
        List<Integer> tes = new ArrayList<Integer>();
        tes.add(5);
        tes.add(2);
        tes.add(3);
        tes.add(4);
        tes.add(1);
        System.out.println(closestNumbers(tes));
    }

}
