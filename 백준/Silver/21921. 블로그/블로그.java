import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 블로그 시작 후 지난 일수
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int count = 1;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }
        max = sum;

        for (int i = x; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - x];

            if (max < sum) {
                max = sum;
                count = 1;
            } else if (max == sum) {
                count++;
            }
        }


        if (max == 0) {
            bw.write("SAD\n");
        } else {
            bw.write(max + "\n" + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
