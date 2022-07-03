package com.coc.algorithm;

import org.springframework.data.relational.core.sql.In;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leo
 */
public class CubeTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String str;
        String[] arr;
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> unOwned = new ArrayList<>();
//        Set<Integer> all = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        for (int i = 0; i < N; i++) {
            str = sc.nextLine();
            arr = str.split(" ");
            List<Integer> collect = Arrays.asList(arr).stream().map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> un = set.stream().filter(v -> !collect.contains(v)).collect(Collectors.toList());
            Collections.sort(un);
            unOwned.add(un);
            set.addAll(collect);
        }
        if (set.size() < 10) {
            for (int i = 1; i < 10; i++) {
                if (!set.contains(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : unOwned) {
            list.forEach(v -> {
                Integer count = map.getOrDefault(v, 0);
                map.put(v, count + 1);
            });
        }
        List<Integer> collect = map.keySet().stream().collect(Collectors.toList());
        Collections.sort(collect);
        String num = "";
        int last = -1;
        for (Integer index : collect) {
            if ((N % 2 == 0 && map.get(index) > N / 2) || ((N % 2 != 0 && map.get(index) > N / 2))) {
                if (last > 0 && last < index) {
                    continue;
                } else {
                    num += index;
                    last = index;
                }
            }
        }
        if (num.isEmpty()) {

        }
        while (num.length() <= N / 2) {
            num += last;
        }
        System.out.println(num);
        /**
         * 3
         * 1 2 3 4 5 6
         * 6 5 2 8 2 9
         * 0 1 5 9 7 6
         */
//        Collections.sort(list);
//        StringBuffer stringBuffer = new StringBuffer();
//        String numStr = String.join("", list.stream().map(v -> v.toString()).collect(Collectors.toList()));
//        Integer num = Integer.valueOf(numStr) - 1;
//        System.out.println();
    }
}
