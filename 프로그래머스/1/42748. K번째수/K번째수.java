import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];

            int[] arr = new int[end - start + 1];
            int index = start - 1;
            for (int j = 0; j < arr.length; j++) {
                arr[j] = array[index++];
            }
            Arrays.sort(arr);
            answer[i] = arr[idx - 1];
        }
        return answer;
    }
}