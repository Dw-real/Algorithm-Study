import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());

        int sum = 0;
        int index = 1;
        int top = 1;
        int bottom = 1;

        while (true) {
            sum += index;
            if (sum >= x)
                break;
            index++;
        }

        if (index % 2 ==0) { 
            top = index;
        
            for (int i=0; i<sum-x; i++) {
                top -= 1;
                bottom += 1;
            }
        }
        else if (index % 2 == 1) {
            bottom = index;

            for (int i=0; i<sum-x; i++) {
                top += 1;
                bottom -= 1;
            }
        }

        bw.write(top + "/" + bottom + "\n");

        br.close();
        bw.close();
    }
}
