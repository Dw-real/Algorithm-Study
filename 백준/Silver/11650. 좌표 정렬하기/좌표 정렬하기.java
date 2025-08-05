import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Dot implements Comparable<Dot> {

    private int x;
    private int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot d) {
        if (this.x == d.x)
            return this.y - d.y;
        else
            return this.x - d.x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 점의 개수
        PriorityQueue<Dot> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.add(new Dot(x, y));
        }

        while (!pq.isEmpty()) {
            Dot dot = pq.poll();
            bw.write(dot.getX() + " " + dot.getY() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
