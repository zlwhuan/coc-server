package com.coc.exam;

import java.util.Scanner;

/**
 * @author Leo
 */
public class Code7 {
    private static long findMgcNum(long m) {
        long tempNum = 0;
        if (m == 1) {
            return 1;
        }

        for (int n = 1; n <= m; n++) {
            for (int j = 1; j <= n; j++) {
                if (n % j == 0) {
                    tempNum += j;
                }
            }
            if (tempNum == m) {
                return n;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long m;
        long n;
        Scanner scanner = new Scanner(System.in);
        Long getNum = Long.parseLong(scanner.nextLine());
        int t = 0;
        //验证录入范围
        if (getNum > 10 || getNum < 1) {
            System.out.println(-1);
            return;
        } else {
            t = getNum.intValue();
        }

        long[] arrT = new long[t];
        for (int k = 0; k < t; k++) {
            long mi = 0;
            Long getNum2 = Long.parseLong(scanner.nextLine());
            // 验证录入范围2,这个地方可以继续改进一下，越贴合10的18次方，越高分
            if (getNum2 > 10000000 || getNum2 < 1) {
                System.out.println(-1);
                return;
            } else {
                mi = getNum2;
            }

            //

            arrT[k] = mi;
        }

        //找因数
        for (int i = 0; i < t; i++) {
            m = arrT[i];
            n = findMgcNum(m);
            System.out.println(n);
        }
    }

}
