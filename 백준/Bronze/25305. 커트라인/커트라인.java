import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int score[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int j=0; j<n; j++) {
            score[j] = Integer.parseInt(st.nextToken());
        }

        mergeSort(score, 0, n-1);

        bw.write(score[num-1] + "");
        bw.write("\n");

        br.close();
        bw.close();
    }

    public static void mergeSort(int[] arr, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);    
        }
    }

    public static void merge(int arr[], int left, int mid, int right) {
        int sorted[] = new int[arr.length];
        int a = left; 
        int b = mid + 1; 
        int c = left;

        while (a <= mid && b <= right) {
            if (arr[a] >= arr[b])
                sorted[c++] = arr[a++];
            else
                sorted[c++] = arr[b++];
        }

        if (a > mid) {
            for (int i=b; i<=right; i++)
                sorted[c++] = arr[i];
        }
        else {
            for (int i=a; i<=mid; i++)
                sorted[c++] = arr[i];
        }

        for (int i=left; i<=right; i++) {
            arr[i] = sorted[i];
        }
    }
}