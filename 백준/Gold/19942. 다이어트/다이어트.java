import java.io.*;
import java.util.*;

public class Main {
    static int mp, mf, ms, mv; // 단백질, 지방, 탄수화물, 비타민
    static int[] p, f, s, v, price;
    static int minPrice = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> combi = new ArrayList<>();

    static void chooseIngredient(int[] arr, int[] output, boolean[] visited, int count, int start, int depth) {
        if (depth == count) {
            if (isPossible(output)) {
                if (minPrice > getPrice(output)) {
                    minPrice = getPrice(output);
                    combi.clear();
                    combi.add(toList(output));
                } else if (minPrice == getPrice(output)) {
                    combi.add(toList(output));
                }
            }
            return;
        }
        for (int i=start; i<arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                chooseIngredient(arr, output, visited, count, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isPossible(int[] arr) {
        int pp = 0;
        int ff = 0;
        int ss = 0;
        int vv = 0;
        for (int num : arr) {
            pp += p[num];
            ff += f[num];
            ss += s[num];
            vv += v[num];
        }

        return pp >= mp && ff >= mf && ss >= ms && vv >= mv;
    }

    static int getPrice(int[] arr) {
        int total = 0;

        for (int num : arr) {
            total += price[num];
        }

        return total;
    }

    static ArrayList<Integer> toList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 식재료의 수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        f = new int[n + 1];
        s = new int[n + 1];
        v = new int[n + 1];
        price = new int[n + 1];

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i + 1;
        }

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            p[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=n; i++) { // 재료 선택은 1~n개
            chooseIngredient(arr, new int[i], new boolean[n], i, 0, 0);
        }

        if (combi.isEmpty())
            bw.write(-1 + "\n");
        else {
            combi.sort((list1, list2) -> {
                for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                    if (!list1.get(i).equals(list2.get(i))) {
                        return list1.get(i) - list2.get(i);
                    }
                }
                return list1.size() - list2.size();
            });

            bw.write(minPrice + "\n"); // 최소 가격 출력
            for (int num : combi.get(0)) { // 첫 번째 배열 출력
                bw.write(num + " ");
            }
            bw.write("\n");


        }



        bw.flush();
        bw.close();
        br.close();
    }
}
