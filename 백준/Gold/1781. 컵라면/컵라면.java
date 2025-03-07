import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int deadline;
    int ramen;

    public Problem(int deadline, int ramen) {
        this.deadline = deadline;
        this.ramen = ramen;
    }

    @Override
    public int compareTo(Problem p) {
        if (p.deadline == this.deadline)
            return p.ramen - this.ramen; // 데드라인이 같다면 라면이 많은 순으로 정렬
        else
            return this.deadline - p.deadline;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 문제의 개수

        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            pq.add(new Problem(deadLine, ramen));
        }

        int ans = 0;

        PriorityQueue<Integer> r = new PriorityQueue<>();

        while (!pq.isEmpty()) {
            Problem p = pq.poll();
            r.add(p.ramen);

            if (r.size() > p.deadline)
                r.poll();
        }

        while (!r.isEmpty()) {
            ans += r.poll();
        }

        bw.write(ans + "\n");

        br.close();
        bw.close();
    }
}