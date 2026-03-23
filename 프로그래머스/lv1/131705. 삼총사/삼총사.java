class Solution {
    static int answer = 0;
    static int[] trio = new int[3];
    static boolean[] visited;

    public int solution(int[] number) {
        visited = new boolean[number.length];
        combi(trio, number, visited, 0, 3, 0);
        return answer;
    }

    public void combi(int[] trio, int[] number, boolean[] visited, int start, int r, int depth) {
        if (depth == r) {
            int sum = 0;
            for (int i=0; i<trio.length; i++) {
                sum += trio[i];
            }
            if (sum == 0) answer++;
            return;
        }
        for (int i=start; i<number.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                trio[depth] = number[i];
                combi(trio, number, visited, i + 1, r, depth + 1);
                visited[i] = false;
            }
        }
    }
}