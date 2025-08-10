import java.io.*;

public class Main {
    static boolean[] visited; // 각 알파벳에 대한 방문 처리 배열

    static int checkGroupWord(String word) {
        boolean isCheckWord = true;
        char start = word.charAt(0);
        visited[start - '0' - 49] = true;

        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (word.charAt(i - 1) != c) {
                if (visited[c - '0' - 49]) {
                    isCheckWord = false;
                    break;
                }
            }
            visited[c - '0' - 49] = true;
        }
        if (isCheckWord)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0; // 그룹 단어의 개수
        for (int i = 0; i < n; i++) {
            visited = new boolean[26];
            String word = br.readLine();
            count += checkGroupWord(word);
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
