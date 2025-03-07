import java.io.*;

public class Main {
    static void selection_sort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int max = i;
            for (int j=i + 1; j<arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (arr[i] < arr[max])
                swap(arr, i, max);
            }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] arr = new int[str.length()];    

        for (int i=0; i<str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        selection_sort(arr);

        for (int i=0; i<arr.length; i++) {
            bw.write(arr[i] + "");
        }
        bw.write("\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
