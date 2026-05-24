class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // priority queue ordenada por frequência (menor frequência primeiro)
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> freqMap.get(n1) - freqMap.get(n2)
        );
        
        for (int num : freqMap.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}