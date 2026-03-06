import java.io.*;
import java.util.*;

class Class implements Comparable<Class> {
    int s;
    int t;

    public Class(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public int compareTo(Class c) {
        return this.s - c.s;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 수업의 개수

        PriorityQueue<Class> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.t));

        ArrayList<Class> classes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            classes.add(new Class(s, t));
        }

        Collections.sort(classes);

        for (Class c : classes) {
            if (!pq.isEmpty() && c.s >= pq.peek().t) {
                pq.poll();
            }
            pq.add(c);
        }

        bw.write(pq.size() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}