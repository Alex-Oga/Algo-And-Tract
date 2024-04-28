import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route {

    static int jeanisRoute(int[] k, int[][] roads) {
        int total = 0;
        List<List<Integer>> route = new ArrayList<>();
        for (int i=0; i< roads.length; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(roads[i][0]);
            a.add(roads[i][1]);
            a.add(roads[i][2]);
            route.add(a);
            a = new ArrayList<>();
            a.add(roads[i][1]);
            a.add(roads[i][0]);
            a.add(roads[i][2]);
            route.add(a);
        }

        List<Integer> allK = new ArrayList<>();
        for (int i=0; i<k.length; i++) {
            allK.add(k[i]);
        }

        List<Integer> search = new ArrayList<>();

        int first = allK.get(0);
        while (search.containsAll(allK) != true) {
            for (int i=0; i<route.size(); i++) {
                if (route.get(i).get(0) == first) {
                    total++;
                    search.add(first);
                    first = route.get(i).get(0);
                }
            }
        }

        return total;

    }

    public static void main(String[] args) {
        int[] k = {1, 3, 4};
        int[][] roads = {{1, 2, 1}, {2, 3, 2}, {2, 4, 2}, {3, 5, 3}};
        System.out.println(jeanisRoute(k, roads));
    }
}
