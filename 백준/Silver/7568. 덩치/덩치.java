import java.io.*;
import java.util.*;

public class Main {
    static String getRank(ArrayList<int[]> info) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (true) {
            int rank = 1;
            if (index == info.size())
                break;
            for (int i=0; i<info.size(); i++) {
                int weight = info.get(index)[0];
                int height = info.get(index)[1];

                if (weight < info.get(i)[0] && height < info.get(i)[1])
                    rank++;
            }
            sb.append(rank + " ");
            index++;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> info = new ArrayList<int[]>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            info.add(new int[]{weight, height});
        }

        bw.write(getRank(info) + "\n");

        br.close();
        bw.close();
    }
}
