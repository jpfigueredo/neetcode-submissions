class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // get the most frequent and return the k numbers of top frequents
        // probably can apply max-heap
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i ++){
            result[i] = heap.poll()[1];
        }
        return result;
    }
}
