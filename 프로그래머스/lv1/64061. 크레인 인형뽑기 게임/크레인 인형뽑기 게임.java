import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        for (int i=0; i<moves.length; i++) {
            int pos = moves[i] - 1;
            for (int j=0; j<board.length; j++) {
                int doll = board[j][pos];
                if (doll == 0) continue;
                board[j][pos] = 0;
                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
                break;
            }
        }
        return answer;
    }
}