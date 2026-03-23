import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0;
        int zeroCount = 0; // 알아볼 수 없는 수의 개수
        ArrayList<Integer> winNums = new ArrayList<>();
        for (int i=0; i<win_nums.length; i++) {
            winNums.add(win_nums[i]);
        }
        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            if (winNums.contains(lottos[i]))
                win++;
        }
        answer[0] = getRank(win + zeroCount);
        answer[1] = getRank(win);
        
        return answer;
    }

    public int getRank(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}