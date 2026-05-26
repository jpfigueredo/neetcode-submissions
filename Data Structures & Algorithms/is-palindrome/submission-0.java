class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // remove special characters and spaces
        // check if the size is even
        // We can do 2 things here, substrings cutting the string in half and reversing the second one to check if they are equal
        // or do a two pointer from right to left and left to right and finish in the middle
        int left = 0;
        int right = s.length()-1;
        char[] word = s.toCharArray();

        // O(n/2)
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
