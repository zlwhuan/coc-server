package com.coc.exam;

import java.util.ArrayList;

/**
 * @author Leo
 */
public class Code2 {
    public static class Action {
        public int dot = 0;
        public int damage = 0;

        public Action(int dot, int damage) {
            this.dot = dot;
            this.damage = damage;
        }
    }

    public static void main(String[] args) {
        int dot = 0;
        int n = 4; 	// rounds
        int k = 50; 	// boss hp
        int round = 0;

        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new Action(10, 15));
        actions.add(new Action(10, 15));
        actions.add(new Action(10, 15));
        actions.add(new Action(10, 15));
        while (k > 0) {
            k -= dot;
            if (round < actions.size()) {
                Action action = actions.get(round);
                k -= action.damage;
                dot += action.dot;
            }
            round++;
        }
        System.out.println(round);
    }

}
