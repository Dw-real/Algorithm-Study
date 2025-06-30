import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            int count = 0;
            StringTokenizer st = null;

            bw.write(m / 2 + 1 + "\n");

            while (count < m) {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine(), " ");
                }
                while (st.hasMoreTokens() && count < m) {
                    list.add(Integer.parseInt(st.nextToken()));

                    if ((count + 1) % 2 == 1) { // 홀수번째 수를 읽을 때
                        Collections.sort(list);

                        bw.write(list.get(count / 2) + " ");
                    }
                    count++;
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
