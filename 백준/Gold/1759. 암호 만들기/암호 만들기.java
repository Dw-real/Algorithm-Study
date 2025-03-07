import java.io.*;
import java.util.*;

public class Main {
    static char[] letter;
    static ArrayList<String> pwd;

    static void makePwd(char[] output, boolean[] visited, int start, int l, int depth) {
        if (depth == l) {
            checkPwd(output);
            return;
        }
        for (int i=start; i<letter.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = letter[i];
                makePwd(output, visited, i + 1, l, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void checkPwd(char[] output) {
        int m = 0; // 모음의 개수
        int j = 0; // 자음의 개수
        String s = "";

        for (char c : output) {
            s += c;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                m++;
            else
                j++;
        }

        // 최소 1개의 모음과 2개의 자음으로 이루어진 경우엔 암호의 가능성 있음
        if (m >= 1 && j >= 2)
            pwd.add(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken()); // 암호의 길이
        int c = Integer.parseInt(st.nextToken());

        letter = new char[c];
        pwd = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<c; i++) {
            letter[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(letter);

        makePwd(new char[l], new boolean[c], 0, l, 0);

        for (String s : pwd) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}