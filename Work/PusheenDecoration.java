import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PusheenDecoration {

    public static void decoration(int N, int[] n) {
        int total = 0;
        for (int i=0; i<N; i++) {
            if (n[i] == 0) {
                total++;
                i+=2;
            }
        }
        System.out.print(total);
    }

    public static void main (String[] args) {
        int t, N;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++) {
            N = sc.nextInt();
            int[] n = new int[N];
            for (int j=0; j<N; j++) {
                n[j] = sc.nextInt();
            }
            System.out.print("Case "+(i+1)+": ");
            decoration(N, n);
            System.out.println("");
        }
    }
}
