class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false; //not anagram

        int[] freq = new int[26];

        // Increment for characters in s, decrement for characters in t
        for(int i=0; i<n1; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

       // Check if all counts are back to 0
        for (int k : freq) {
            if (k != 0) {
                return false;
            }
        }

        return true;
    }
}
