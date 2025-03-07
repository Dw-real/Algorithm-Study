import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int e = Integer.parseInt(st.nextToken()); // 지구  1<=e<=15
        int s = Integer.parseInt(st.nextToken()); // 태양  1<=s<=28
        int m = Integer.parseInt(st.nextToken()); // 달   1<=m<=19

        int year = 0;
        int ee = 0;
        int ss = 0;
        int mm = 0;

        while (true) {
            if (ee == e && ss == s && mm == m) {
                break;
            }
            ee++;
            ss++;
            mm++;
            if (ee == 16)
                ee = 1;
            if (ss == 29)
                ss = 1;
            if (mm == 20)
                mm = 1;
            year++;
        }

        bw.write(year + "" + "\n");

        br.close();
        bw.close();
    }
}
