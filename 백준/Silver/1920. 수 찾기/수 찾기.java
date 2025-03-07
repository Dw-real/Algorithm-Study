import java.io.*;
import java.util.*;

public class Main {
    static int binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (num == arr[mid])
                return mid;
            else if (num < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (binarySearch(arr, num) != -1)
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
