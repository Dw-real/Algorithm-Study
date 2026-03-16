import java.io.*;
import java.util.*;

class Main {
    static String[] name;
    static int[] upper;

    static String getTitle(int power) {
        int low = 0;
        int high = upper.length - 1;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (upper[mid] >= power)
                high = mid;
            else
                low = mid + 1;
        }

        return name[high];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 칭호의 개수
        int m = Integer.parseInt(st.nextToken()); // 캐릭터의 개수

        name = new String[n];
        upper = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            name[i] = st.nextToken();
            upper[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            bw.write(getTitle(Integer.parseInt(br.readLine())) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}