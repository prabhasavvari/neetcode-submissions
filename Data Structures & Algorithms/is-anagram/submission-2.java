class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false; //not anagram

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for(int i=0; i<n1; i++){
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        // Arrays.equals() correctly compares the contents of two int arrays
        return Arrays.equals(freqS, freqT);
    }
}
