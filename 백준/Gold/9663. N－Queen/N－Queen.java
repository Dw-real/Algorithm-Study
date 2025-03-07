import java.io.*;

public class Main {
    static int[] arr;
    static int n;
    static int ans = 0; // 퀸을 배치하는 방법의 수

    static void dfs(int start) {
        if (start == n) {
            ans += 1;
            return;
        }
        for (int i=0; i<n; i++) {
            boolean isValid = true;
            for (int j=0; j<start; j++) {
                // 같은 열에 있는 경우
                // 왼쪽, 오른쪽 대각선에 있는 경우
                if (arr[j] == i || arr[j] + (start - j) == i || arr[j] - (start - j) == i) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                arr[start] = i;
                dfs(start + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
