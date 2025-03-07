import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<a; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<b; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1)
                count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
