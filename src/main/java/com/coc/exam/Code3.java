package com.coc.exam;

import java.util.Scanner;

/**
 * @author Leo
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        str = str.substring(1, str.length() - 1);
        String[] arrayStr = str.split("\\)\\(");
        if (arrayStr.length == 1) {
            System.out.println(1);
        } else {
            Integer[] integers = new Integer[arrayStr.length];
            double sum = 1;
            double result = 0;
            for (int i = 0; i < arrayStr.length; i++) {
                Integer integer = Integer.valueOf(arrayStr[i].replace("x", ""));
                sum *= integer;
                result += 1.0 / integer;
                integers[i] = integer;
            }
            System.out.println((Math.round(result * sum) % 10007));
        }
    }
}
