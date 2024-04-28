import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PusheenSwap {

    public static void swap(int N, int n[],  int ascend[]) {
        int total = 0;
        for (int i=0; i<N; i++) {
            while (ascend[i] != n[i]) {
                total++;
                int swapFirst = n[i];
                int swapSecond = n[swapFirst-1];
                n[swapFirst-1] = swapFirst;
                n[i] = swapSecond;
            }
        }
        System.out.println(""+total);
    }

    public static void main (String[] args) {
        int t, N;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i=0; i<t; i++) {
            N = sc.nextInt();
            int[] n = new int[N];
            int[] ascend = new int[N];
            for (int j=0; j<N; j++) {
                n[j] = sc.nextInt();
                ascend[j]  = j+1;
            }
            System.out.print("Case "+(i+1)+": ");
            swap(N, n, ascend);
        }
    }
}
