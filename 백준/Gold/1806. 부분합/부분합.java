import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sIndex = 0;
        int eIndex = 0;

        int sum = arr[0];
        int len = Integer.MAX_VALUE;
        while (eIndex < n - 1) {
            if (sum >= s) {
                len = Math.min(len, eIndex - sIndex + 1);
                sum -= arr[sIndex];
                sIndex++;
            }
            else {
                eIndex++;
                sum += arr[eIndex];
            }
        }
        while (sIndex <= eIndex) {
            if (sum >= s) {
                len = Math.min(len, eIndex - sIndex + 1);
                sum -= arr[sIndex];
                sIndex++;
            }
            else
                break;
        }

        if (len == Integer.MAX_VALUE) {
            bw.write(0 + "\n");
        } else {
            bw.write(len + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
