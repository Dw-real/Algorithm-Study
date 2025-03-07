import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int m = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = n - 1;

        int count = 0; // 갑옷을 만들 수 있는 경우의 수
        while (s < e) {
            int sum = arr[s] + arr[e];

            if (sum < m) {
                s++;
            }
            else if (sum > m) {
                e--;
            } else {
                count++;
                s++;
                e--;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}