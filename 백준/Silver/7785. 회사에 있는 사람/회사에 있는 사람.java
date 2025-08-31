import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String log = st.nextToken();

            if (log.equals("enter")) {
                set.add(name);
            } else if (log.equals("leave")) {
                set.remove(name);
            }
        }

        for (String name : set) {
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
