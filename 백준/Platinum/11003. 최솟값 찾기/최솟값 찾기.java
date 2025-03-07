import java.io.*;
import java.util.*;

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new ArrayDeque<Node>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > value) {
                dq.removeLast();
            }

            dq.addLast(new Node(i, value));
            // 슬라이딩 윈도우
            if (dq.getFirst().index <= i - l) {
                dq.removeFirst();
            }
        
            bw.write(dq.getFirst().value + " ");
        }

        bw.write("\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
