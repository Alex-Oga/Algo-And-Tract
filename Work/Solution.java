import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        List<List<Integer>> ori = new ArrayList<>();
        for (int i=0; i<len; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            List<Integer> ad = new ArrayList<>();
            ad.add(a);
            ad.add(b);
            ori.add(ad);
        }
        List<List<Integer>> cop = new ArrayList<>(ori);
        ori.sort((x, y) -> {
            for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
                if (x.get(i) != y.get(i)) {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });

        BigDecimal x1 = BigDecimal.valueOf(ori.get(0).get(0));
        BigDecimal x2 = BigDecimal.valueOf(ori.get(1).get(0));
        BigDecimal y1 = BigDecimal.valueOf(ori.get(0).get(1));
        BigDecimal y2 = BigDecimal.valueOf(ori.get(1).get(1));
        BigDecimal subX = x2.subtract(x1);
        BigDecimal subY = y2.subtract(y1);
        BigDecimal multX = subX.multiply(subX);
        BigDecimal multY = subY.multiply(subY);
        BigDecimal all = multX.add(multY);
        BigDecimal c = all.sqrt(new MathContext(15));
        List<List<Integer>> tru = new ArrayList<>();
        tru.add(ori.get(0));
        tru.add(ori.get(1));

        for (int i=0; i<len-1; i++) {
            BigDecimal xx1 = BigDecimal.valueOf(ori.get(i).get(0));
            BigDecimal xx2 = BigDecimal.valueOf(ori.get(i+1).get(0));
            BigDecimal yy1 = BigDecimal.valueOf(ori.get(i).get(1));
            BigDecimal yy2 = BigDecimal.valueOf(ori.get(i+1).get(1));
            subX = xx2.subtract(xx1);
            subY = yy2.subtract(yy1);
            multX = subX.multiply(subX);
            multY = subY.multiply(subY);
            all = multX.add(multY);
            BigDecimal cc = all.sqrt(new MathContext(15));

            if (cc.compareTo(c) == -1) {
                tru = new ArrayList<>();
                c = cc;
                tru.add(ori.get(i));
                tru.add(ori.get(i+1));
            }
        }
        int firstIndex = cop.indexOf(tru.get(0));
        int secondIndex = cop.indexOf(tru.get(1));
        StringBuilder ans = new StringBuilder();

        if (firstIndex < secondIndex) {
            ans.append(firstIndex);
            ans.append(" ");
            ans.append(secondIndex);
            ans.append(" ");
            ans.append(String.format("%.6f", c.doubleValue()));
        }
        else {
            ans.append(secondIndex);
            ans.append(" ");
            ans.append(firstIndex);
            ans.append(" ");
            ans.append(String.format("%.6f", c.doubleValue()));
        }
        System.out.println(ans.toString());
    }
}