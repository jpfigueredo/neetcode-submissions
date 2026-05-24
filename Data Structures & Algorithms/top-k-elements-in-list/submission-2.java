class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Create Map with frequencies
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int num: nums){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // 2. Create PriorityQueue to "sort" it
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> frequency.get(n1) - frequency.get(n2)
        );
        for(int num: frequency.keySet()){
            heap.add(num);
            if(heap.size() > k){
                heap.poll();
            }
        }

        // 3. Merge 1 and 2 within a int[] result to return
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}
