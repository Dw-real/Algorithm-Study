import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] inDegree = new int[26];
        ArrayList<Integer>[] graph = new ArrayList[26];

        for (int i=0; i<26; i++) {
            graph[i] = new ArrayList<>();
        }

        if (skill.length() > 1) {
            for (int i = 1; i < skill.length(); i++) {
                graph[skill.charAt(i - 1) - 'A'].add(skill.charAt(i) - 'A');
                inDegree[skill.charAt(i) - 'A']++;
            }
        }

        for (int i=0; i<skill_trees.length; i++) {
            String tree = skill_trees[i];
            int[] copy = inDegree.clone();
            boolean flag = true;

            for (int j=0; j<tree.length(); j++) {
                char c = tree.charAt(j);
                if (copy[c - 'A'] != 0) {
                    flag = false;
                    break;
                } else {
                    for (int next : graph[c - 'A']) {
                        if (copy[next] == 0)
                            continue;
                        copy[next]--;
                    }
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}