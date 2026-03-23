import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        ArrayList<String> phoneNum = new ArrayList<>();
        for (String phone : phone_book) {
            phoneNum.add(phone);
        }
        Collections.sort(phoneNum);
        
        for (int i = 1; i < phoneNum.size(); i++) {
            if (phoneNum.get(i).startsWith(phoneNum.get(i - 1))) {
                return false;
            }
        }
        return answer;
    }
}