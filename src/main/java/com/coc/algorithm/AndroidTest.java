package com.coc.algorithm;

import java.util.Scanner;

/**
 * @author Leo
 */
public class AndroidTest {

    static int[] fa = new int[100000];
    static int[] la = new int[100000];
    static int[] w = new int[100000];
    static int n, m;

    static int find(int x) {
        if (fa[x] != x) {
            int _fa = fa[x];
            fa[x] = find(fa[x]);
            w[x] += w[_fa];
        }
        return fa[x];
    }

    /**
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        for (int i = 1; i <= n; i++) {
            fa[i] = la[i] = i;
            w[i] = 0;
        }
        while (m-- > 0){
            int a, b;
            char c;
            str = sc.nextLine();
            arr = str.split(" ");
            c = arr[0].charAt(0);
            a = Integer.valueOf(arr[1]);
            b = Integer.valueOf(arr[2]);
            if (c == 'C'){
                fa[a] = la[b];
                la[find(b)] = la[a];
                w[a] = 1;
            }else {
                if(find(a) == find(b)){
//                    System.out.println(Math.max(0, Math.abs(w[a]-w[b]) - 1));
                    System.out.println("Yes");
                }else {
//                    System.out.println("-1");
                    System.out.println("No");
                }
            }
        }
    }
}
