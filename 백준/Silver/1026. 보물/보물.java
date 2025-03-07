import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a); // 오름차순 정렬
        Collections.sort(b, Collections.reverseOrder()); // 내림차순 정렬

        int min = 0;

        for (int i=0; i<n; i++) {
            min += (a.get(i) * b.get(i));
        }

        bw.write(min + "\n");

        br.close();
        bw.close();
    }
}