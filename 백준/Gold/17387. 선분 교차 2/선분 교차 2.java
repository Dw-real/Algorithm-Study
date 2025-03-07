import java.io.*;
import java.util.*;

public class Main {
    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (temp > 0)
            return 1;
        else if (temp < 0)
            return -1;
        else
            return 0;
    }

    // 선분겹침 여부 확인
    static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2) &&
        Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2)) return true;
        
        return false;
    }

    static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1);
        int cdb = ccw(x3, y3, x4, y4, x2, y2);

        if (abc * abd == 0 && cda * cdb == 0) {// 선분이 일직선일 때
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        }
        else if (abc * abd <= 0 && cda * cdb <= 0) { // 선분이 교차하는 경우
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());
        
        boolean cross = isCross(x1, y1, x2, y2, x3, y3, x4, y4);
        if (cross)
            bw.write(1 + "\n");
        else
            bw.write(0 + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
