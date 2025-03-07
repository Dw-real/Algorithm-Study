import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> books = new HashMap<>();

        for (int i=0; i<n; i++) {
            String name = br.readLine();
            books.put(name, books.getOrDefault(name, 0) + 1);
        }

        int count = 0;
        String best = "";

        for (Map.Entry<String, Integer> entry : books.entrySet()) {
            if (count < entry.getValue()) {
                count = entry.getValue();
                best = entry.getKey();
            } else if (count == entry.getValue()) {
                if (best.compareTo(entry.getKey()) > 0) {
                    best = entry.getKey();
                }
            }
        }

        bw.write(best + "\n");

        br.close();
        bw.close();
    }
}