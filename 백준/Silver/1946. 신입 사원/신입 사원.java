import java.io.*;
import java.util.*;

class Employee implements Comparable<Employee> {
    int documentRank;
    int interviewRank;

    Employee(int documentRank, int interviewRank) {
        this.documentRank = documentRank;
        this.interviewRank = interviewRank;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.documentRank - employee.documentRank;
    }
}

public class Main {
    static int getAnswer(ArrayList<Employee> arr) {
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i).interviewRank < min) {
                count++;
                min = arr.get(i).interviewRank;
            }  
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Employee> arr = new ArrayList<Employee>();

            for (int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int documentRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());
                arr.add(new Employee(documentRank, interviewRank));
            }
            Collections.sort(arr);
            sb.append(getAnswer(arr) + "\n");    
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
