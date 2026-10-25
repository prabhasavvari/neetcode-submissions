class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Frequency array for uppercase English letters
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            
            // Track the frequency of the single most frequent character in the current window
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            // If characters to replace (window length - maxFreq) exceed k, shrink window from left
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum valid window length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
