import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sort = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = sort[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sort);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        for (int num : sort) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int num : arr) {
            bw.write(map.get(num) + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
