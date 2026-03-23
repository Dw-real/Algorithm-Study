class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0; i<arr1.length; i++) {
            int a1 = arr1[i];
            int a2 = arr2[i];
            answer[i] = overlap(a1, a2, n);
        }
        return answer;
    }

    public String overlap(int a1, int a2, int n) {
        StringBuilder sb = new StringBuilder();
        String b1 = String.format("%" + n + "s", Integer.toBinaryString(a1)).replace(' ', '0');
        String b2 = String.format("%" + n + "s", Integer.toBinaryString(a2)).replace(' ', '0');
        
        for (int i=0; i<n; i++) {
            if (b1.charAt(i) == b2.charAt(i) && b1.charAt(i) == '0')
                sb.append(' ');
            else if ((b1.charAt(i) == b2.charAt(i) && b1.charAt(i) == '1')  || (b1.charAt(i) != b2.charAt(i)))
                sb.append('#');
        }
        return sb.toString();
    }
}