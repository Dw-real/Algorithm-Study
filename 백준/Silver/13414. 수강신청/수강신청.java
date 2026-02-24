import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> wait = new LinkedHashSet<>();

        for (int i = 0; i < l; i++) {
            String studentId = br.readLine();

            if (!wait.contains(studentId)) {
                wait.add(studentId);
            } else {
                wait.remove(studentId);
                wait.add(studentId);
            }
        }

        int count = 0;

        for (String id : wait) {
            if (count == k)
                break;
            bw.write(id + "\n");
            count++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}