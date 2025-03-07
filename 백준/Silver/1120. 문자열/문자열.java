import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        int min = 51;
        int length = b.length() - a.length();

        for (int i=0; i<=length; i++) {
            int count = 0;
            String tmp = b.substring(i, i + a.length());
            for (int j=0; j<a.length(); j++) {
                if (tmp.charAt(j) != a.charAt(j)) {
                    count++;
                }
            }
            min = Math.min(count, min);
        }

        bw.write(min + "" + "\n");
        
        br.close();
        bw.close();
    }
}
