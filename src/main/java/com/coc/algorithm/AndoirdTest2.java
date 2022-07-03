package com.coc.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Leo
 */
public class AndoirdTest2 {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        if (n == 0) {
            System.out.println(0);
        }

        String str = in.nextLine();
        if (str == null) {
            System.out.println(0);
        }

        String[] strArr = str.split(" ");
        int[] intArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (strArr[i].length() > 0) {
                intArr[i] = Integer.valueOf(strArr[i]);
            }

        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            int count = 0;

            for (int k = j + 1; k < n; k++) {

                if (intArr[j] < intArr[k] && intArr[k] % intArr[j] == 0) {

                    count++;

                }

            }
            max = Math.max(max, count);

        }

        System.out.println(max);


//             System.out.println();

    }


    void test() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                l.add(i);
            }
        }
        if (l.size() < 3) {
            System.out.println(0);
        } else if (l.size() == 3) {
            System.out.println(String.join(",", l.stream().map(String::valueOf).collect(Collectors.toList())));
        } else {
            List<List<Integer>> all = new ArrayList<>();
            for (int i = 0; i < l.size() - 2; i++) {
                for (int j = i + 1; j < l.size() - 1; j++) {
                    for (int k = j + 1; k < l.size(); k++) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(l.get(i));
                        temp.add(l.get(j));
                        temp.add(l.get(k));
                        all.add(temp);
                    }
                }
            }
            for (int i = 0; i < all.size(); i++) {
                System.out.println(String.join(",", all.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
            }
        }
    }
}
