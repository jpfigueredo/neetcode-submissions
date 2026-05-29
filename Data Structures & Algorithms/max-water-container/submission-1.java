class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calcula a largura e a altura do recipiente
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            // Atualiza a área máxima encontrada
            maxArea = Math.max(maxArea, currentArea);
            
            // Move o ponteiro que possui a menor altura
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
