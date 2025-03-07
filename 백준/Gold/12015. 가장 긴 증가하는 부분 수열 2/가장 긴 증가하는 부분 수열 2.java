import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        int[] LIS = new int[n]; // 가장 긴 증가하는 부분 수열
        int[] arr = new int[n]; // 기존 수열
        int length = 1; // 가장 긴 증가하는 부분 수열의 길이

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];

        for (int i=1; i<n; i++) {
            int key = arr[i];

            if (LIS[length - 1] < key) {
                length++;
                LIS[length - 1] = key;
            }

            else {
                int low = 0;
                int high = length;

                while (low < high) {
                    int mid = (low + high) / 2;

                    if (key <= LIS[mid]) {
                        high = mid;
                    }
                    else {
                        low = mid + 1;
                    }
                }
                LIS[low] = key;
            }
        }

        bw.write(length + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
