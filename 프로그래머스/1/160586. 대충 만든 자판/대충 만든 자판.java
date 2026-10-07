class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];

            int count = 0;
            for (int j = 0; j < target.length(); j++) {
                int minCount = 101; // 자판을 누르는 최소 횟수
                char c = target.charAt(j);
                for (String key : keymap) {
                    if (key.indexOf(c) >= 0 && key.indexOf(c) + 1 < minCount) {
                        minCount = key.indexOf(c) + 1;
                    }
                }
                count += minCount;
                if (minCount == 101) {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}