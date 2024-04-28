import java.util.*;
import java.util.function.Supplier;

public class Test {
    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> pairs = new ArrayList<>();
        int smallestNumber = Math.abs(arr.get(0) - arr.get(1));
        pairs.add(arr.get(0));
        pairs.add(arr.get(1));

        for (int i=0; i<arr.size(); i++) {
            for (int j=i+1; j<arr.size(); j++) {
                if (i == 0 && j == 1)
                    continue;
                if (Math.abs(arr.get(i) - arr.get(j)) == smallestNumber) {
                    pairs.add(arr.get(i));
                    pairs.add(arr.get(j));
                }
                else if (Math.abs(arr.get(i) - arr.get(j)) < smallestNumber) {
                    smallestNumber = Math.abs(arr.get(i) - arr.get(j));
                    pairs = new ArrayList<>();
                    pairs.add(arr.get(i));
                    pairs.add(arr.get(j));
                }
            }
        }
        Collections.sort(pairs);
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
