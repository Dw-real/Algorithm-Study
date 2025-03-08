import java.io.*;
import java.util.*;

class Num {
    int n; // 부른 숫자
    int s; // 스트라이크
    int b; // 볼

    public Num(int n, int s, int b) {
        this.n = n;
        this.s = s;
        this.b = b;
    }
}

public class Main {
    static boolean isValid(int num) {
        int a = num / 100; // 백의 자리 수
        int b = num % 100 / 10; // 십의 자리 수
        int c = num % 100 % 10; // 일의 자리 수

        if (b == 0 || c == 0)
            return false;
        
        return a != b && b != c && a != c;
    }

    static boolean getInfo(int num, int n, int s, int b) {
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++) {
            if (String.valueOf(num).charAt(i) == String.valueOf(n).charAt(i))
                strike++;
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i != j && String.valueOf(num).charAt(i) == String.valueOf(n).charAt(j))
                    ball++;
            }
        }

        return strike == s && ball == b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 질문 횟수
        ArrayList<Num> nums = new ArrayList<>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            nums.add(new Num(num, strike, ball));
        }

        int count = 0;

        for (int i=100; i<=999; i++) {
            if (!isValid(i))
                continue;

            boolean flag = true;

            for (Num num : nums) {
                int nn = num.n;
                int s = num.s;
                int b = num.b;

                if (!getInfo(i, nn, s, b)) {
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}