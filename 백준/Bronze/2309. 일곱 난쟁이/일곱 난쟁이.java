import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> arr = new ArrayList<Integer>();
        int sum = 0;
        int x = 0;
        int y = 0;

        for (int i=0; i<9; i++) {
            int height = Integer.parseInt(br.readLine());
            arr.add(height);    
            sum += height;
        }

        for (int i=0; i<arr.size(); i++) {
            for (int j=i+1;  j<arr.size(); j++) {
                if (sum - arr.get(i) - arr.get(j) == 100) {
                    x = arr.get(i);
                    y = arr.get(j);
                    break;
                }
            }
        }

        Collections.sort(arr);

        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i) != x && arr.get(i) != y)
                bw.write(arr.get(i)+ "\n");
        }

        br.close();
        bw.close();
    }
}