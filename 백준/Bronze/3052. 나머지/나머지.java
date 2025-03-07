import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[10];

        for (int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());

            arr[i] = n % 42;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<10; i++) {
            if (!list.contains(arr[i]))
                list.add(arr[i]);
        }

        bw.write(list.size() + "" + "\n");
        br.close();
        bw.close();
    }
}
