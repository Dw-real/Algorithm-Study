import java.io.*;
import java.util.*;

class Main {
    static int min = 2000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;
        int a1 = 0;
        int a2 = 0;

        while (s < e) {
            int sum = arr[s] + arr[e];

            if (Math.abs(sum) <= min) {
                a1 = s;
                a2 = e;
                min = Math.abs(sum);
            }

            if (sum < 0)
                s++;
            else
                e--;
        }

        bw.write(arr[a1] + " " + arr[a2] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
