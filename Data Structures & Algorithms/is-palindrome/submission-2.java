class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length()-1;
        char[] word = s.toCharArray();

        while(left < right){
            if(word[left] != word[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
