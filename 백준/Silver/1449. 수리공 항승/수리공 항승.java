import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 1;
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int maxPoint = arr[0] + (l - 1); // 테이프를 붙일 수 있는 최대 위치

        for (int i=0; i<n; i++) {
            if (arr[i] <= maxPoint)
                continue;
            maxPoint = arr[i] + (l - 1);
            count++;
        }

        bw.write(count + "\n");

        br.close();
        bw.close();
    }
}