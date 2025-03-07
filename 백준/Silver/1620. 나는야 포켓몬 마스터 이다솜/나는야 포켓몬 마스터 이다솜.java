import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] nameGuide = new String[n + 1];
        HashMap<String, Integer> guide = new HashMap<String, Integer>();

        for (int i=1; i<=n; i++) {
            String name = br.readLine();
            guide.put(name, i);
            nameGuide[i] = name;
        }


        for (int i=0; i<m; i++) {
            String s = br.readLine();

            try {
                int num = Integer.parseInt(s);
                sb.append(nameGuide[num]).append("\n");
            }
            catch(NumberFormatException ne) {
                sb.append(guide.get(s)).append("\n");
            }
        }
        
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
