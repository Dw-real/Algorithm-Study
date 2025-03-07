import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] fact = new long[21];
        boolean[] visited = new boolean[21];

        fact[0] = 1;

        for (int i=1; i<=20; i++) {
            fact[i] = fact[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int q = Integer.parseInt(st.nextToken()); // 소문제 번호

        if (q == 1) {
            int[] arr = new int[n + 1];
            long k = Long.parseLong(st.nextToken()); // k번째 순열 구하기
            for (int i=1; i<=n; i++) {
                int cnt = 1;
                for (int j=1; j<=n; j++) {
                    if (visited[j]) continue;

                    if (k <= (fact[n - i] * cnt)) {
                        k -= (fact[n - i] * (cnt - 1));
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }

            for (int i=1; i<=n; i++) {
                bw.write(arr[i] + " ");
            }
        } else {
            int[] arr = new int[n + 1]; // 순서를 구할 배열
            long k = 1;
            for (int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j=1; j<arr[i]; j++) {
                    if (!visited[j])
                        cnt++;
                }
                k += cnt * fact[n - i];
                visited[arr[i]] = true;
            }

            bw.write(k + "\n");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
