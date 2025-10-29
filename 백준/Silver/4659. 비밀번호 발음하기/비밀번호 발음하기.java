import java.io.*;
import java.util.*;

class Main {
    static Set<Character> moeum = Set.of('a', 'e', 'i', 'o', 'u');

    static String check(String pwd) {
        boolean valid = true;
        boolean conti = true; // 연속된 자음 또는 연속된 모음 판별
        int count = 1; // 연속된 모음/자음의 수

        int m = 0; // 모음의 수

        char start = pwd.charAt(0);

        if (moeum.contains(start)) {
            m++;

        } else {
            conti = false;
        }


        for (int i = 1; i < pwd.length(); i++) {
            char c = pwd.charAt(i);

            if (moeum.contains(c))
                m++;

            // 2번 조건
            if (conti && moeum.contains(c)) {
                count++;
            } else if (conti && !moeum.contains(c)) {
                count = 1;
                conti = false;
            } else if (!conti && !moeum.contains(c)) {
                count++;
            } else {
                count = 1;
                conti = true;
            }

            if (count >= 3) {
                valid = false;
                break;
            }

            // 3번 조건
            if ((c != 'e' && c != 'o') && (c == pwd.charAt(i - 1))) {
                valid = false;
                break;
            }
        }

        // 1번 조건
        if (m == 0)
            valid = false;

        if (valid)
            return "<" + pwd + "> is acceptable.";
        else
            return "<" + pwd + "> is not acceptable.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String pwd = br.readLine();

            if (pwd.equals("end"))
                break;

            bw.write(check(pwd) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
