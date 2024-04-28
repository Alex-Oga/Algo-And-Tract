import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        int smallest = Math.abs(arr.get(0) - arr.get(1));
        List<Integer> lst = new ArrayList<>();
        Collections.sort(arr);

        for (int i=0; i<arr.size()-1; i++) {
            int a = arr.get(i);
            int b = arr.get(i+1);

            if (Math.abs(a-b) == smallest) {
                lst.add(a);
                lst.add(b);
            }

            if (Math.abs(a-b) < smallest) {
                smallest = Math.abs(a-b);
                lst = new ArrayList<>();
                lst.add(a);
                lst.add(b);
            }
        }

        return lst;
    }


    public static void main(String[] args) {
        List<Integer> tes = new ArrayList<Integer>();
        tes.add(-20);
        tes.add(-3916237);
        tes.add(-357920);
        tes.add(-3620601);
        tes.add(7374819);
        tes.add(-7330761);
        tes.add(30);
        tes.add(6246457);
        tes.add(-6461594);
        tes.add(266854);
        System.out.println(closestNumbers(tes));
    }
}
