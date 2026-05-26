class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // array sorted, check right and left
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            if(numbers[left]+numbers[right]==target){
                return new int[]{left+1, right+1};
            }
            
            int complement = target-numbers[left];
            if(numbers[right] > complement){
                right--;
            } else {
                left++;
            }
            
        }
        return null;
    }
}
