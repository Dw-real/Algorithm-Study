import java.io.*;
import java.util.*;

public class Main {
    static int binarySearch(int a, int[] b, int length) {
        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (b[mid] < a) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // A의 수
            int m = Integer.parseInt(st.nextToken()); // B의 수

            int[] a = new int[n];
            int[] b = new int[m];

            int count = 0; // A가 B를 잡아먹는 경우
            
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            
            for (int j=0; j<n; j++) {
                count += binarySearch(a[j], b, m);
            }

            bw.write(count + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
