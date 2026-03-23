class Solution {
     public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[number.length()];
        for (int i=0; i<number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
        }
        int idx = 0;
        for (int i=0; i<number.length() - k; i++) {
            int max = 0;
            for (int j=idx; j<=i+k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
    
}