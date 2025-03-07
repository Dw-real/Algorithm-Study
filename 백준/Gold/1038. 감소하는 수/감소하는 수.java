import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Long> decreaseNum = new ArrayList<>(); // 감소하는 수

    static void dfs(long num, int depth) {
        if (depth > 10)
            return;
        decreaseNum.add(num);

        // num의 1의 자리 수 보다 작은 수를 붙여 감소하는 수 만들기
        for (long i=0; i<num % 10; i++) {
            dfs((num * 10) + i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (long i=0; i<10; i++) {
            dfs(i, 1);
        }

        Collections.sort(decreaseNum);

        // 9876543210 -> 1022번째 감소하는 수
        if (n >= 1023)
            bw.write(-1 + "\n");
        else
            bw.write(decreaseNum.get(n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}