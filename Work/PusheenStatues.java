import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PusheenStatues {

    public static int forward(List<List<Integer>> statues, int index, int color) {
        int total = 0;
        int col = 0;
        if (index >= statues.size())
            return 0;
        for (int i=index; i<statues.size(); i++) {
            int smallest = 0;
            for (int j=0; j<3; j++) {
                if (j == color)
                    continue;
                if (smallest == 0) {
                    smallest = statues.get(i).get(j);
                    col = j;
                }
                else if (statues.get(i).get(j) < smallest) {
                    smallest = statues.get(i).get(j);
                    col = j;
                }
            }
            color = col;
            total += smallest;
        }
        return total;
    }
    public static void statue(List<List<Integer>> statues, int N) {
        int first = statues.get(0).get(0);
        first += forward(statues, 1, 0);
        int second = statues.get(0).get(1);
        second += forward(statues, 1, 1);
        int third = statues.get(0).get(2);
        third += forward(statues, 1, 2);
        if (first < second && first < third)
            System.out.println(first);
        else if (second < first && second < third) {
            System.out.println(second);
        }
        else {
            System.out.println(third);
        }
    }

    public static void main (String[] args) {
        int t, N;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++) {
            List<List<Integer>> items = new ArrayList<>();
            N = sc.nextInt();
            for (int j=0; j<N; j++) {
                List<Integer> item = new ArrayList<>();
                item.add(sc.nextInt());
                item.add(sc.nextInt());
                item.add(sc.nextInt());
                items.add(item);
            }
            System.out.print("Case "+(i+1)+": ");
            statue(items, N);
        }
    }
}