import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        ArrayList<Integer> primeNum = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= n; j = j + i) {
                arr[j] = 0;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                primeNum.add(i);
            }
        }

        int count = 0; // 연속된 소수의 합으로 나타낼 수 있는 경우의 수

        int start = 0;
        int end = 0;

        int sum = 0;

        while (start < primeNum.size() && end <= primeNum.size()) {
            if (sum >= n) {
                if (sum == n) count++;
                sum -= primeNum.get(start++);
            } else {
                if (end == primeNum.size())
                    break;
                sum += primeNum.get(end);
                end++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}