import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int p;
    int l;

    public Problem(int p, int l) {
        this.p = p;
        this.l = l;
    }

    @Override
    public int compareTo(Problem problem) {
        if (problem.l == this.l) {
            return this.p - problem.p;
        } else {
            return this.l - problem.l;
        }
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeSet<Problem> set = new TreeSet<>();
        HashMap<Integer, Problem> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine()); // 추천 리스트에 있는 문제의 수
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            set.add(problem);
            map.put(p, problem);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem problem = new Problem(p, l);
                set.add(problem);
                map.put(p, problem);
            } else if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    bw.write(set.last().p + "\n");
                } else {
                    bw.write(set.first().p + "\n");
                }
            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                Problem problem = map.get(p);
                if (problem != null) {
                    set.remove(problem);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
