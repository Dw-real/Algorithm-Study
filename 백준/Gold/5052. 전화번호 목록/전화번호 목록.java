import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            String ans = "YES";
            ArrayList<String> phoneNum = new ArrayList<String>();
            int n = Integer.parseInt(br.readLine());

            for (int j=0; j<n; j++) {
                String s = br.readLine();
                phoneNum.add(s);
            }
            Collections.sort(phoneNum);
            
            for (int j=1; j<phoneNum.size(); j++) {
                if (phoneNum.get(j).startsWith(phoneNum.get(j-1))) {
                    ans = "NO";
                    break;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
