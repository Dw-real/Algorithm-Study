import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> rainbowDance = new HashSet<>();
        rainbowDance.add("ChongChong");

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();

            if (rainbowDance.contains(a)) {
                rainbowDance.add(b);
            } else if (rainbowDance.contains(b)) {
                rainbowDance.add(a);
            }
        }

        bw.write(rainbowDance.size() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
