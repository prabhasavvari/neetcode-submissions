class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;

        int longestStreak = 1;
        int currentStreak = 1;

        Arrays.sort(nums); 

        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            else if(nums[i] == nums[i-1] + 1){
                currentStreak++;
            }
            else {
                longestStreak = Math.max(currentStreak, longestStreak);
                currentStreak = 1; //start the streak again
            }
        }

        //This updates if all the elements in array form the sequence
        longestStreak = Math.max(currentStreak, longestStreak);

        return longestStreak;
    }
}
