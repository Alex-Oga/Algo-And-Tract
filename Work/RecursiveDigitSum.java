import java.math.BigInteger;

public class RecursiveDigitSum {

    public static int superDigit(String n, int k) {
        BigInteger total = digit(n).multiply(BigInteger.valueOf(k));
        while (total.compareTo(BigInteger.valueOf(9)) == 1) {
            String str = total+"";
            total = digit(str);
        }
        return total.intValue();
    }

    public static BigInteger digit(String n) {
        if (n.length() == 1) {
            return new BigInteger(n);
        }

        int len = n.length();
        String a = n.substring(0, (len+1)/2);
        String b = n.substring(a.length());

        return digit(a).add(digit(b));

    }

    public static void main(String[] args) {
        String n = "148";
        System.out.println(superDigit(n, 3));
    }

}
