import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0)
                break;

            int[] arr = new int[2 * n + 1];
            for (int i=2; i<=2 * n; i++) {
                arr[i] = i;
            }
            int count = 0;
            for (int i=2; i<=Math.sqrt(2 * n); i++) {
                if (arr[i] == 0) continue;

                for (int j=i+i; j<=2 * n; j+=i) {
                    arr[j] = 0;
                }
            }

            for (int i=n + 1; i<=2 * n; i++) {
                if (arr[i] != 0)
                    count++;
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
