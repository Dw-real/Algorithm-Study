import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        PriorityQueue<Integer> positiveNum = new PriorityQueue<>((o1, o2) -> o2 - o1); // 양수
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>(); // 음수

        int one = 0; // 1의 개수
        int zero = 0; // 0의 개수

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) {
                positiveNum.add(num);
            } else if (num == 1) {
                one++;
            } else if (num == 0) {
                zero++;
            } else {
                negativeNum.add(num);
            }
        }

        int sum = 0;

        while (positiveNum.size() > 1) {
            sum += positiveNum.poll() * positiveNum.poll();
        }

        while (negativeNum.size() > 1) {
            sum += negativeNum.poll() * negativeNum.poll();
        }

        sum += one; // 1의 개수만큼 더함 -> 1은 곱하는 것보다 더하는 것이 더 큰 값이 나옴
        if (!positiveNum.isEmpty()) {
            sum += positiveNum.poll();
        }

        if (!negativeNum.isEmpty()) {
            if (zero == 0)
                sum += negativeNum.poll();
        }
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}