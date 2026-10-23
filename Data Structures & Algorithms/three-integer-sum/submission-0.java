class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int pivot = nums[i];

            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = pivot + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(pivot, nums[left], nums[right]));

                    // Move both pointers to look for other pairs
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return result;
    }
}
