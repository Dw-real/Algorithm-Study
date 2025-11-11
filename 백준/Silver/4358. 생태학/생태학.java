import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        TreeMap<String, Integer> trees = new TreeMap<>();

        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.length() == 0) {
                break;
            }
            count++;
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : trees.entrySet()) {
            double ratio = ((double)entry.getValue() / (double)count) * 100;
            sb.append(entry.getKey()).append(String.format(" %.4f\n", ratio));
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
