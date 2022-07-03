package com.coc.algorithm;

import java.util.Scanner;

/**
 * @author Leo
 */
public class MultiplyTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int a = Integer.parseInt(arr[2]);
        int b = Integer.parseInt(arr[3]);

        if (a == b) {
            System.out.println(0);
            return;
        }
        if (a > b || b % a != 0) {
            System.out.println(-1);
        }

        int tmp = b / a;
        int m = x > y ? x : y;
        int n = x > y ? y : x;
        int count = 0;
        while (tmp > 1) {
            if (tmp % m == 0) {
                tmp /= m;
                count ++;
            } else if (tmp % n == 0) {
                tmp /= n;
                count ++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        if (tmp == 1) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }
}
