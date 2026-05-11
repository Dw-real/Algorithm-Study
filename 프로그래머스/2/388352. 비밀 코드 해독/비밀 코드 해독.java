import java.util.*;

class Solution {
    static int answer;
    static int[] arr;
    static boolean[] visited;

    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        visited = new boolean[n + 1];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        List<HashSet<Integer>> question = new ArrayList<>();
        for (int[] quest : q) {
            HashSet<Integer> code = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                code.add(quest[i]);
            }
            question.add(code);
        }
        combi(arr, visited, new int[5], question, ans, 0, 0);

        return answer;
    }

    public void combi(int[] arr, boolean[] visited, int[] output, List<HashSet<Integer>> question,
                      int[] ans, int start, int depth) {
        if (depth == 5) {
            if (isValidCode(output, question, ans)) {
                answer++;
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combi(arr, visited, output, question, ans, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isValidCode(int[] output, List<HashSet<Integer>> q, int[] ans) {
        for (int i = 0; i < q.size(); i++) {
            int count = 0;
            for (int j = 0; j < output.length; j++) {
                if (q.get(i).contains(output[j])) {
                    count++;
                }
            }
            if (count != ans[i]) {
                return false;
            }
        }
        return true;
    }
}