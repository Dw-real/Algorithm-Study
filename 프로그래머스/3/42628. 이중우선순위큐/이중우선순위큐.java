import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (String op : operations) {
            String[] str = op.split(" ");
            int num = Integer.parseInt(str[1]);
            if (str[0].equals("I")) {
                max.add(num);
                min.add(num);
            } else {
                if (num == 1 && !max.isEmpty()) {
                    int n = max.poll();
                    min.remove(n);
                } else if (num == -1 && !min.isEmpty()){
                    int n = min.poll();
                    max.remove(n);
                }
            }
        }
        
        if (!max.isEmpty() && !min.isEmpty()) {
            answer[0] = max.poll();
            answer[1] = min.poll();
            return answer;
        }
        return answer;
    }
}