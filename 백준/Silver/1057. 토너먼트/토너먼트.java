import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        boolean matched = false;
        int ans = 1;

        for (int i=0; i<n; i++) {
            if ((j + 1) / 2 == (h + 1) / 2) {
                matched = true;
                break;
            }
            ans++;
            j = (j + 1) / 2;
            h = (h + 1) / 2;
        }

        if (matched)
            bw.write(ans + "\n");
        else
            bw.write(-1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
