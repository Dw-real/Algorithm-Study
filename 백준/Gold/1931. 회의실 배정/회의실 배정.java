import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        if (this.end == m.end)
            return this.start - m.start;
        else
            return this.end - m.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 회의의 개수
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }
        int e = meetings.poll().end;
        int count = 1;
        while (!meetings.isEmpty()) {
            Meeting now = meetings.poll();

            if (now.start >= e) {
                e = now.end;
                count++;
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}