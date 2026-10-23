class Solution {
    public int maxArea(int[] heights) {
        int n= heights.length;
        int l=0, r=n-1;
        int max = 0;
        
        while(l < r){
            int width = r - l;
            int water = Math.min(heights[l], heights[r]) * width;
            max = Math.max(max, water);
            
            if(heights[l] <= heights[r]) l++;
            else r--;
        }
        return max;
    }
}
