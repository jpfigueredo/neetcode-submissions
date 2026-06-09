class Solution {
    public int carFleet(int target, int[] positions, int[] speeds) {
        int[][] pairs = new int[positions.length][2];
        for(int i = 0; i < positions.length; i++){
            pairs[i][0] = positions[i];
            pairs[i][1] = speeds[i];
        }
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for(int[] p : pairs){
            stack.push((double) (target-p[0])/p[1]);
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() -2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
