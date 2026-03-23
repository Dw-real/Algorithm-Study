import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> term = new HashMap<>();
        ArrayList<Integer> destroy = new ArrayList<>();

        for (String item : terms) {
            String[] str = item.split(" ");
            term.put(str[0], Integer.parseInt(str[1]));
        }
        String[] todayStr = today.split("\\.");
        int todayYear = Integer.parseInt(todayStr[0]);
        int todayMonth = Integer.parseInt(todayStr[1]);
        int todayDay = Integer.parseInt(todayStr[2]);
        int todayDate = (todayYear * 12 * 28) + todayMonth * 28 + todayDay;

        for (int i=0; i< privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            String type = str[1];
            String[] date = str[0].split("\\.");

            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]) + term.get(type);
            int day = Integer.parseInt(date[2]);

            int end = (year * 12 * 28) + month * 28 + day;

            if (todayDate >= end)
                destroy.add(i + 1);
        }

        return destroy.stream().mapToInt(Integer::intValue).toArray();
    }
}