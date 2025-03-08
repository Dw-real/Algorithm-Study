import java.io.*;
import java.util.*;

class Ingredient {
    int sour;
    int bitter;

    public Ingredient(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }
}

public class Main {
    static int min = Integer.MAX_VALUE;
    
    static void combination(ArrayList<Ingredient> list, Ingredient[] output, boolean[] visited, int start, int depth, int count) {
        if (depth == count) {
            getMin(output);
            return;
        }
        for (int i=start; i<list.size(); i++) {
            visited[i] = true;
            output[depth] = list.get(i);
            combination(list, output, visited, i + 1, depth + 1, count);
            visited[i] = false;
        }
    }

    static void getMin(Ingredient[] output) {
        int sumS = 1;
        int sumB = 0;

        for (int i=0; i<output.length; i++) {
            sumS *= output[i].sour;
            sumB += output[i].bitter;
        }
        min = Math.min(min, Math.abs(sumS - sumB));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        ArrayList<Ingredient> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            list.add(new Ingredient(sour, bitter));
        }

        for (int i=1; i<=n; i++) {
            combination(list, new Ingredient[i], new boolean[n], 0, 0, i);
        }
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
