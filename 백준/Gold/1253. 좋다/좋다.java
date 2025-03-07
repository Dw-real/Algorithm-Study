import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 수의 개수

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int k=0; k<n; k++) {
            int num = arr[k];

            int i = 0;
            int j = n - 1;
            while (i < j) {
                if (arr[i] + arr[j] == num) {
                    // 서로 다른 두 수의 합이어야 함
                    if (i !=k && j != k) {
                        count++;
                        break;
                    }
                    else if (i == k) {
                        i++;
                    }
                    else if (j == k) {
                        j--;
                    }
                }
                else if (arr[i] + arr[j] < num) {
                    i++;
                }
                else {
                    j--;
                }
            }
        }

        bw.write(count + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
