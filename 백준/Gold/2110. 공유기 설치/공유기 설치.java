import java.io.*;
import java.util.*;

public class Main {
    static boolean isPossible(int[] house, int c, int mid) {
        int tmp = 1; // 설치한 공유기 수
        int start = house[0];

        for (int i=1; i<house.length; i++) {
            if (start + mid <= house[i]) {
                tmp++;
                start = house[i];
            }
            if (tmp == c)
                return true;
        }

        return false;
    }

    static int getLongest(int[] house, int c, int low, int high) {
        int mid;
        int ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (isPossible(house, c, mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 집의 개수
        int c = Integer.parseInt(st.nextToken()); // 공유기의 수

        int[] house = new int[n];
        for (int i=0; i<n; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int high = house[n - 1] - house[0]; // 가장 긴 거리
        int ans = getLongest(house, c, 1, high);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
