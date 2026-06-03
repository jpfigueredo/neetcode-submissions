class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // put the values on the stack if the next value(s) is lesser than this one
        // if it is higher, return stack.size() and clear the stack and go to the next ith element
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return result;
    }
}
