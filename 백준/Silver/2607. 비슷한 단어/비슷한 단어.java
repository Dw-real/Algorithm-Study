import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String firstWord = br.readLine();
        int ans = 0; // 같은 구성을 갖는 단어의 수

        for (int i = 0; i < n - 1; i++) {
            String word = br.readLine();
            List<Character> alphabet = new ArrayList<>();

            int count = 0; // 다른 문자의 개수

            for (int j = 0; j < firstWord.length(); j++) {
                alphabet.add(firstWord.charAt(j));
            }

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (alphabet.contains(c)) {
                    alphabet.remove(Character.valueOf(c));
                } else {
                    count++;
                }
            }

            if (count <= 1 && alphabet.size() <= 1)
                ans++;
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}