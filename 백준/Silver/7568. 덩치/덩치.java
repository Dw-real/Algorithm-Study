import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Body {
    int weight;
    int height;

    public Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Body[] arr = new Body[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i] = new Body(weight, height);
        }


        for (int i = 0; i < n; i++) {
            int r = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int w1 = arr[i].weight;
                    int h1 = arr[i].height;
                    int w2 = arr[j].weight;
                    int h2 = arr[j].height;

                    if (w1 < w2 && h1 < h2)
                        r++;
                }
            }
            rank[i] = r;
        }

        for (int ans : rank) {
            bw.write(ans + " ");
        }
        bw.write("\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
