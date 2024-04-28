import java.util.*;

public class journeyToTheMoon {


    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        int total = 0;
        for (int i=0; i<n; i++) {
            List<Integer> a = new ArrayList<>();
            a.add(i);
            int t = 0;
            for (int j=0; j<astronaut.size(); j++) {
                if (astronaut.get(j).contains(i)) {
                    t+=1;
                    continue;
                }
            }
            if (t == 0)
                astronaut.add(a);
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Set<Integer> a = new HashSet<>();
            if (all.contains(i))
                continue;
            all.add(i);
            a.add(i);
            int to=0;
            while (to==0) {
                int to2=0;
                for (int j = 0; j < astronaut.size(); j++) {
                    List<Integer> check = astronaut.get(j);
                    if (Collections.disjoint(check, a) == false) {
                        a.addAll(check);
                        all.addAll(check);
                        astronaut.remove(check);
                        j--;
                        to2++;
                    }
                }
                if (to2==0)
                    to=1;
            }
            ans.add(new ArrayList<>(a));
        }
        for (int i=0; i<ans.size(); i++) {
            for (int j=i+1; j<ans.size(); j++) {
                total += ans.get(i).size()*ans.get(j).size();
            }
        }
        System.out.println(ans);
        return total;
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> d = new ArrayList<>();
        a.add(5);
        a.add(3);
        b.add(0);
        b.add(1);
        c.add(2);
        c.add(3);
        d.add(0);
        d.add(4);
        test.add(a);
        test.add(b);
        test.add(c);
        test.add(d);
        System.out.println(journeyToMoon(6, test));
    }
}
