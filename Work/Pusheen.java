import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Pusheen {
    public static void push(int N, int k, int[] n, int total) {
        if (total % k == 0) {
            System.out.println(total);
        }
    }

    public static void main (String[] args) {
        int t, N, k;
        int total = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++) {
            N = sc.nextInt();
            k = sc.nextInt();
            int[] n = new int[N];
            for (int j=0; j<N; j++) {
                int a = sc.nextInt();
                n[j] = a;
                total += a;
            }
            System.out.print("Case "+(i+1)+": ");
            push(N, k, n, total);
        }
    }
}
