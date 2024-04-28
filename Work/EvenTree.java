import java.util.*;

public class EvenTree {
    static int evenForest(int tNodes, int tEdges, List<Integer> tFrom, List<Integer> tTo) {
        int cut = 0;
        List<List<Integer>> allLines = new ArrayList<>();
        System.out.println(tFrom);
        System.out.println(tTo);
        int current = 1;
        while (current<=tTo.size()) {
            Set<Integer> a = new HashSet<>();
            for (int i=0; i<tFrom.size(); i++) {
                if (tTo.get(i) == current) {
                    a.add(tFrom.get(i));
                }
            }
            if (a.size() > 0)
                allLines.add(new ArrayList<>(a));
            current ++;
        }
        for (int i=0; i<allLines.size(); i++) {
            if (allLines.get(i).size()%2 == 1)
                cut++;
        }
        System.out.println(allLines);
        return cut+1;
    }

    public static void main(String[] args) {
        List<Integer> from = new ArrayList<>();
        from.add(1);
        from.add(1);
        from.add(2);
        from.add(2);
        from.add(5);
        List<Integer> to = new ArrayList<>();
        to.add(2);
        to.add(5);
        to.add(3);
        to.add(4);
        to.add(6);
        System.out.println(evenForest(6, 5, to, from));
    }
}
