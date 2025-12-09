import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 파일의 개수
        TreeMap<String, Integer> files = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            String extension = file.split("\\.")[1];
            files.put(extension, files.getOrDefault(extension, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : files.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
