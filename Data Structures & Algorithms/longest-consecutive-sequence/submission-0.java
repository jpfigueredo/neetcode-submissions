class Solution {
    public int longestConsecutive(int[] nums) {
        int longestConsecutive = 0;
        Set<Integer> sequence = new HashSet<>();

        for (int num : nums) {
            sequence.add(num);
        }

        for (int num: sequence) {
            if(!sequence.contains(num-1)){
                int count = 0;
                while (sequence.contains(num)) {
                    count++;
                    num++;
                }
            longestConsecutive = Math.max(count, longestConsecutive);
            }
        }

        return longestConsecutive;
    }
}
