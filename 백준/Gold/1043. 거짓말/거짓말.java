import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] person; // 진실을 아는 사람
    static ArrayList<Integer>[] party;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 파티의 수

        parent = new int[n + 1];
        party = new ArrayList[m];

        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int t = Integer.parseInt(st.nextToken());
        person = new int[t];
        for (int i=0; i<t; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken()); // 각 파티에 오는 사람 수
            for (int j=0; j<num; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i=0; i<m; i++) {
            int first = party[i].get(0);

            for (int j=1; j<party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        int result = 0; // 진실을 말하지 않아도 되는 파티 수

        for (int i=0; i<m; i++) {
            int first = party[i].get(0);
            boolean flag = true;
            for (int j=0; j<person.length; j++) {
                if (find(first) == find(person[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}