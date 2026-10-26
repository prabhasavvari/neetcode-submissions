class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Found the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the LEFT half is sorted
            if (nums[l] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1; // Search left
                } else {
                    l = mid + 1; // Search right
                }
            } 
            // Otherwise, the RIGHT half must be sorted
            else {
                // Check if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1; // Search right
                } else {
                    r = mid - 1; // Search left
                }
            }
        }

        // return target not found -> -1
        return -1;
    }
}
