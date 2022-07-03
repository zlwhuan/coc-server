package com.coc.algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Leo
 */
public class HtmlTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (!str.startsWith("<")) {
            System.out.println("NO");
            return;
        }

        Stack<String> stack = new Stack<>();
        String temp = "";
        boolean b = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '<'){
                b = true;
                continue;
            }else if(c == '/'){
                b = false;
            }else if (c == '>'){
                if (temp.length() == 0){
                    System.out.println("NO");
                    return;
                }
                if (b){
                    stack.push(temp);
                }else {
                    String pop = stack.pop();
                    if (!temp.equals(pop)){
                        System.out.println("NO");
                        return;
                    }
                }
                temp = "";
            }else {
                temp += c;
            }
        }
        if (stack.empty()){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
