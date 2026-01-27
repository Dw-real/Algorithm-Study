import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) { // col번째 컬럼 값이 같은 경우 기본 키 기준 내림차순 정렬
                return o2[0] - o1[0];
            } else { // 다른 경우 col번째 컬럼 값 기준 오름차순 정렬
                return o1[col - 1] - o2[col - 1];
            }
        });

        int[] si = new int[row_end - row_begin + 1];

        int idx = 0;

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int s = 0;
            for (int j = 0; j < data[i].length; j++) {
                s += (data[i][j] % (i + 1));
            }
            si[idx++] = s;
        }

        int answer = si[0];

        for (int i = 1; i < si.length; i++) {
            answer ^= si[i];
        }
        
        return answer;
    }
}