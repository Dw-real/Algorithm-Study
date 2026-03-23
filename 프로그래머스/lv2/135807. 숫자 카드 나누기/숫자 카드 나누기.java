class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);

        boolean flagA = gcdA != 1 && isNotDivide(arrayB, gcdA);
        boolean flagB = gcdB != 1 && isNotDivide(arrayA, gcdB);

        if (flagA && flagB)
            answer = Math.max(gcdA, gcdB);
        else if (flagA)
            answer = gcdA;
        else if (flagB)
            answer = gcdB;
        
        return answer;
    }

    public int getGcd(int[] arr) {
        int res = arr[0];

        for (int i=1; i<arr.length; i++) {
            res = gcd(res, arr[i]);
            if (res == 1) break;
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public boolean isNotDivide(int[] arr, int gcd) {
        for (int num : arr) {
            if (num % gcd == 0)
                return false;
        }
        return true;
    }
}