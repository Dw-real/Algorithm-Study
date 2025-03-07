import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 숌이 만든 n번째 영화

        int num = 665;
        int order = 0;

        while (true) {
            // 666이 들어있다면 order++
            if (String.valueOf(num).contains("666"))
                order++;
            if (order == n)
                break;

            num++;
        }

        bw.write(num + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}