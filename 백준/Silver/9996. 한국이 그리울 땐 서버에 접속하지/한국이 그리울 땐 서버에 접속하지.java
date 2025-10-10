import java.io.*;
import java.util.*;

public class Main {

    static boolean validFileName(String[] s, String name) {
        String pre = s[0];
        String post = s[1];

        boolean valid1 = false; // * 기준 앞쪽 패턴과 일치하는지 여부
        boolean valid2 = false; // * 기준 뒤쪽 패턴과 일치하는지 여부

        if (name.length() < pre.length() + post.length())
            return false;

        for (int i = 0; i < pre.length(); i++) {
            valid1 = name.charAt(i) == pre.charAt(i);
            if (!valid1)
                break;
        }

        for (int i = 0; i < post.length(); i++) {
            valid2 = name.charAt(name.length() - post.length() + i) == post.charAt(i);
            if (!valid2)
                break;
        }


        return valid1 && valid2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 파일의 개수

        String pattern = br.readLine();
        String[] s = pattern.split("\\*"); // *을 기준으로 분리

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            if (validFileName(s, name)) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
