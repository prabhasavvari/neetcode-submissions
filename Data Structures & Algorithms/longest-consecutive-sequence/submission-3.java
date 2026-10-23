class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int longestStreak = 0;
        
        for(int n : nums){
            // Check if this number is the START of a sequence
            if(!set.contains(n-1)){
                int currentNum = n;
                int currentStreak = 1;

                // Count consecutive numbers going up
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
