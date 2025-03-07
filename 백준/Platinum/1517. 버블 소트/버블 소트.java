import java.io.*;
import java.util.*;

public class Main {
    static int[] tmp;
    static long result;

    static void merge_sort(int[] arr, int left, int right) {
        if (left >= right) 
            return;

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                tmp[idx] = arr[l];
                idx++;
                l++;
            }
            else {
                tmp[idx] = arr[r];
                result = result + r - idx;
                idx++;
                r++;
            }
        }

        while (l <= mid) {
            tmp[idx] = arr[l];
            idx++;
            l++;
        }

        while (r <= right) {
            tmp[idx] = arr[r];
            idx++;
            r++;
        }

        for (int i=left; i<=right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        tmp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        result = 0; // swap이 일어난 횟수
        merge_sort(arr, 0, n - 1);
        
        bw.write(result + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
