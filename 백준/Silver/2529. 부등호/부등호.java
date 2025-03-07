import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static ArrayList<String> list;
    static int[] op;

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth) {
        if (depth == output.length) {
            getAnswer(output);
            return;
        }
        else {
            for (int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    output[depth] = arr[i];
                    permutation(arr, output, visited, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static void getAnswer(int[] arr) {
        boolean flag = true;
        
        for (int i=0; i<op.length; i++) {
            if (op[i] == 0) {
                if (arr[i] > arr[i+1])
                    flag = true;
                else {
                    flag = false;
                    break;
                }  
            }
            if (op[i] == 1) {
                if (arr[i] < arr[i+1])
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            String str = "";
            for (int i=0; i<arr.length; i++) {
                str += arr[i];
            }
            list.add(str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        op = new int[n];
        list = new ArrayList<String>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0; i<10; i++) {
            arr[i] = i;
        }

        for (int i=0; i<n; i++) {
            String str = st.nextToken();
            if (str.equals(">"))
                op[i] = 0;
            else if (str.equals("<"))
                op[i] = 1;
        }

        permutation(arr, new int[n+1], new boolean[10], 0);
        
        int maxIndex = 0;
        int minIndex = 0;

        for (int i=0; i<list.size(); i++) {
            if (new BigInteger(list.get(i)).compareTo(new BigInteger(list.get(maxIndex))) > 0)
                maxIndex = i;
            if (new BigInteger(list.get(i)).compareTo(new BigInteger(list.get(minIndex))) < 0)
                minIndex = i;
        }
        
        bw.write(list.get(maxIndex) + "\n" + list.get(minIndex) + "\n");

        br.close();
        bw.close();
    }
}
