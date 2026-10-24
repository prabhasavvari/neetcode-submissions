class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int longest = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()){
            if(set.contains(s.charAt(right))){
                longest = Math.max(set.size(), longest);

                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(s.charAt(right));
            right++;
        }

        longest = Math.max(set.size(), longest);
        return longest;
    }
}
