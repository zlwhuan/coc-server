package com.coc.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Leo
 */
public class Code6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String temp = scanner.nextLine();
        int zeroNum = 0;
        List<String> group = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Integer num = null;
            if (i == (n - 1)) {
                num = Integer.valueOf(temp.substring(i));
            } else {
                num = Integer.valueOf(temp.substring(i, i+1));
            }

            if (num == 0) {
                zeroNum ++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String[] split = scanner.nextLine().split(" ");
            int a = Integer.valueOf(split[0]);
            int b = Integer.valueOf(split[1]);

            boolean flag = true;
            for (int j = 0; j < group.size(); j++) {
                temp = group.get(j);
                if (temp.contains(a + "")) {
                    group.set(j, group.get(j) + b);
                    flag = false;
                    break;
                } else if (temp.contains(b + "")) {
                    group.set(j, group.get(j) + a);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                group.add(a + "" + b);
            }
        }

        System.out.println(zeroNum + group.size());

    }
}
