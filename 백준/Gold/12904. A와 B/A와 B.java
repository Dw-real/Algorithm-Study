import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(); // S
        String t = br.readLine(); // T

        boolean isValid = false;

        while (!t.equals("")) {
            if (t.equals(s)) {
                isValid = true;
                break;
            }
            // 문자열의 뒤에 A를 추가한 경우
            if (t.charAt(t.length() - 1) == 'A')
                t = t.substring(0, t.length() - 1);
            // 문자열을 뒤집고 B를 추가한 경우
            else if (t.charAt(t.length() - 1) == 'B') {
                t = t.substring(0, t.length() - 1);
                String tmp = "";

                for (int i=t.length() - 1; i>=0; i--) {
                    tmp += t.charAt(i);
                }
                t = tmp;
            }
        }

        if (isValid)
            bw.write(1 + "\n");
        else
            bw.write(0 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}