import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            HashMap<String, Integer> wear = new HashMap<String, Integer>();
            int n = Integer.parseInt(br.readLine());
            int count = 1;
            for (int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String clothes = st.nextToken();

                if (!wear.containsKey(clothes))
                    wear.put(clothes, 1);
                else
                    wear.put(clothes, wear.get(clothes) + 1);
            }
            
            for (int value : wear.values()) {
                count *= (value + 1);
            }
            sb.append(count - 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
