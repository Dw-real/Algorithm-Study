import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> list;
    static boolean[] visited;

    static void getAnswer(String[] arr, int n, int k, int depth, String tmp) {
        if (depth == k) {
            if (!list.contains(tmp)) {
                list.add(tmp);
            }
            return;
        }
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                getAnswer(arr, n, k, depth + 1, tmp + arr[i]);
                visited[i] = false;
            }
        }
    } 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        list = new ArrayList<String>();
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }

        getAnswer(arr, n, k, 0, "");
        bw.write(list.size() + "" + "\n");

        br.close();
        bw.close();
    }
}
