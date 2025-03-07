import java.io.*;
import java.util.*;

class Code implements Comparable<Code> {
    int num;
    int count;
    int index;

    public Code(int num, int count, int index) {
        this.num = num;
        this.count = count;
        this.index = index;
    }

    @Override
    public int compareTo(Code c) {
        if (this.count == c.count)
            return this.index - c.index;
        else
            return c.count - this.count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        LinkedHashMap<Integer, Code> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, new Code(num, 1, i));
            }
            else {
                Code code = map.get(num);
                code.count++;
                map.put(num, code);
            }
        }
        PriorityQueue<Code> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Code> entry : map.entrySet()) {
            pq.add(new Code(entry.getKey(), entry.getValue().count, entry.getValue().index));
        }
        
        while (!pq.isEmpty()) {
            Code now = pq.poll();
            for (int i=0; i<now.count; i++) {
                bw.write(now.num + " ");
            }
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
