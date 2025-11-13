import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Long> decreaseNum = new ArrayList<>();

    static void addDecreaseNum(long n, int digit) {
        // 가장 큰 감소하는 수 9876543210
        if (digit > 10) {
            return;
        }
        decreaseNum.add(n);

        for (int i = 0; i<n % 10; i++) {
            addDecreaseNum(n * 10 + i, digit + 1);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            addDecreaseNum(i, 1);
        }

        Collections.sort(decreaseNum);

        if (n > 1023) {
            bw.write(-1 + "\n");
        } else {
            bw.write(decreaseNum.get(n - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
