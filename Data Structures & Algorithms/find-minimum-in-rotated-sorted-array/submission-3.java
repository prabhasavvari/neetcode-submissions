class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int mid = l + (r - l) / 2;

            // If mid element is greater than the rightmost element, 
            // the min must be in the right half.
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            // Otherwise, the min is at mid or in the left half
            else{
                r = mid;
            }
        }

        // When l meets r, we have found the minimum element
        return nums[l];
    }
}
