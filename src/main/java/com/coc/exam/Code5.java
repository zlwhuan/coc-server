package com.coc.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Leo
 */
public class Code5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        int k = sqrtCla(n);
        int result = 0;
        if (k >= 3) {
            int sumK = clac(k);

            int sum3 = clac(3);

            int sumK_3 = clac((k - 3));
            result = sumK / sum3 * sumK_3;
        }

        System.out.println(result);

    }

    static int sqrtCla(int n) {
        int kai = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            kai = (int) Math.sqrt(i);

            // Math.sqrt()开方，例如2=(int)Math.sqrt(4)；
            if (kai * kai == i) {
                // System.out.println(i);
                list.add(i);
            }
        }
        return list.size();
    }

    static int clac(int n) {
        int r = 1;
        for (int i = n; i > 0; i--) {
            r *= i;
        }
        return r;
    }

}
