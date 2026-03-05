import java.io.*;
import java.util.*;

class Main {
    static int val = Integer.MAX_VALUE; // 특성값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 용액의 수

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int solution1 = 0;
        int solution2 = 0;

        if (arr[n - 1] < 0) { // 알칼리성 용액만 있는 경우
            solution1 = arr[n - 2];
            solution2 = arr[n - 1];
        } else if (arr[0] > 0) { // 산성 용액만 있는 경우
            solution1 = arr[0];
            solution2 = arr[1];
        } else {
            int start = 0;
            int end = n - 1;

            while (start < end ) {
                int sum = arr[start] + arr[end];
                int value = Math.abs(sum);

                if (value <= val) {
                    val = value;
                    solution1 = arr[start];
                    solution2 = arr[end];
                }
                if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        bw.write(solution1 + " " + solution2 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}