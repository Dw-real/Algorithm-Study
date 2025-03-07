import java.io.*;

public class Main {
    static String checkPwd(String pwd) {
        boolean pass = true;

        int count = 0; // 모음
        int c_count = 0; // 연속되는 자음
        int v_count = 0; // 연속되는 모음

        for (int i=0; i<pwd.length(); i++) {
            char c = pwd.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                c_count = 0;
                count++;
                v_count++;
                
                if (v_count == 3) {
                    pass = false;
                    break;
                }
            }
            else {
                v_count = 0;
                c_count++;

                if (c_count == 3) {
                    pass = false;
                    break;
                }
            }
            
            if (i != 0) {
                char c1 = pwd.charAt(i - 1);

                if (c == c1 && !(c == 'e' || c == 'o'))
                    pass = false;
                else if (c == c1 && (c1 == 'e' || c1 == 'o') && v_count != 3)
                    pass = true;  
            }
        }
        
        if (count == 0)
            pass = false;

        if (pass) {
            return "<" + pwd + "> is acceptable.";
        }
        else{
            return "<" + pwd + "> is not acceptable.";
        }
                 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();

        while (true) {
            String pwd = br.readLine();

            if (pwd.equals("end"))
                break;

            sb.append(checkPwd(pwd) + "\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
