import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        TreeMap<String, String> log = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String enter = st.nextToken();

            log.put(name, enter);
        }

        for (String name : log.keySet()) {
            if (log.get(name).equals("enter"))
                bw.write(name + "\n");
        }
        
        br.close();
        bw.close();
    }
}
