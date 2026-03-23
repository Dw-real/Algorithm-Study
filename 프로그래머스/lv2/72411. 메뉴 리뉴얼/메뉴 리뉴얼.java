import java.util.*;

class Solution {
    static int[] max = new int[11]; // 각 길이의 코스 메뉴 중 가장 많이 주문된 수
    static TreeMap<String, Integer> menu;

    public String[] solution(String[] orders, int[] course) {
        menu = new TreeMap<>((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length();
        });

        for (int k : course) {
            for (String order : orders) {
                if (k <= order.length()) {
                    makeCourse(order, "", k, 0);
                }
            }
        }
        ArrayList<String> result = new ArrayList<>();

        for (String c : menu.keySet()) {
            if (menu.get(c) == max[c.length()] && max[c.length()] >= 2)
                result.add(c);
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public void makeCourse(String order, String c, int length, int depth) {
        if (c.length() == length) {
            char[] ch = c.toCharArray();
            Arrays.sort(ch);
            c = new String(ch);
            menu.put(c, menu.getOrDefault(c, 0) + 1);
            max[length] = Math.max(max[length], menu.get(c));
            return;
        }
        for (int i=depth; i<order.length(); i++) {
            makeCourse(order, c + order.charAt(i), length, i + 1);
        }
    }
}