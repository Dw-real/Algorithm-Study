import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람
        
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for (int i=0; i<n+m; i++) {
            String name = br.readLine();
            if (map.containsKey(name))
                map.put(name, map.get(name) + 1);
            else
                map.put(name, 1);
        }

        int count = 0;

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() != 1) {
                count++;
                sb.append(entry.getKey() + "\n");
            }
                
        }

        bw.write(count + "" + "\n" + sb.toString());

        br.close();
        bw.close();
    }
}
