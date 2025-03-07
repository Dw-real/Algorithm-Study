import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<String> words = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length();
        });

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String word = br.readLine();
            if (!words.contains(word))
                words.add(word);
        }

        while (!words.isEmpty()) {
            bw.write(words.poll() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
