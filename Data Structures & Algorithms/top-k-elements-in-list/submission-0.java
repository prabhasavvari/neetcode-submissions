class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mp.get(a) - mp.get(b));


        for(int i : mp.keySet()){
            pq.offer(i);

            if(pq.size() > k){
                pq.poll(); //remove teh least frequent element
            }
        }

        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }

        return ans;
    }
}
