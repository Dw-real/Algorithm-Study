import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split("-");

        int ans = 0;
        
        if (str[0].contains("+"))
            ans = summ(str[0]); 
        else
            ans = Integer.parseInt(str[0]);

        for (int i=1; i<str.length; i++) {
            ans -= summ(str[i]);
        }

        bw.write(ans + "\n");

        br.close();
        bw.close();
    }

    public static int summ(String str) {
        int sum = 0;

        String add[] = str.split("\\+");

        for (int i=0; i<add.length; i++) {
            sum += Integer.parseInt(add[i]);
        }

        return sum;
    }
}