import java.util.*;

class Music implements Comparable<Music> {
    int id;
    int play;

    public Music(int id, int play) {
        this.id = id;
        this.play = play;
    }

    @Override
    public int compareTo(Music m) {
        if (this.play == m.play) { // 재생 횟수가 같은 경우 -> id 기준 오름차순
            return this.id - m.id;
        } else { // 재생 횟수가 다른 경우 -> 재생 횟수 기준 내림차순
            return m.play - this.play;
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> count = new HashMap<>(); // 장르별 재생 횟수
        HashMap<String, PriorityQueue<Music>> best = new HashMap<>(); // 장르별 우선 순위 음악

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            count.put(genre, count.getOrDefault(genre, 0) + plays[i]);
            PriorityQueue<Music> pq = best.getOrDefault(genre, new PriorityQueue<>());
            pq.add(new Music(i, play));
            best.put(genre, pq);
        }
        ArrayList<Integer> answer = new ArrayList<>();

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(count.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : entries) {
            PriorityQueue<Music> pq = best.get(entry.getKey());

            int len = pq.size() >= 2 ? 2 : 1;

            for (int i = 0; i < len; i++) {
                answer.add(pq.poll().id);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}