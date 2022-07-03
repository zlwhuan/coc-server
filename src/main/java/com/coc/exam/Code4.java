package com.coc.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Leo
 */
public class Code4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        list = list.stream().sorted().collect(Collectors.toList());
        Collections.reverse(list);
        List<Integer> tmp = new ArrayList<>(list);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            if (isRight(tmp)) {
                tmp.forEach(x -> {
                    System.out.print(x);
                });
                System.out.println();
                break;
            } else {
                tmp.remove(i);
                if (isRight(tmp)) {
                    tmp.forEach(x -> {
                        System.out.print(x);
                    });
                    System.out.println();
                    break;
                } else {
                    tmp = new ArrayList<>(list);
                }
            }
        }
    }

    static boolean isRight(List list) {
        int temp = 0;
        for (Object in : list) {
            temp += (int) in;
        }
        if (temp % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
