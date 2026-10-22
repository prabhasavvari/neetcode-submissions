class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;

        int[] freqS = new int[26];
        int[] freqT = new int[26];
        StringBuilder sS = new StringBuilder();
        StringBuilder tS = new StringBuilder();

        for(int i=0; i<n1; i++){
            freqS[s.charAt(i) - 'a']++;
            freqT[t.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++){
            sS.append('#').append(freqS[i]);
            tS.append('#').append(freqT[i]);
        }

        return sS.toString().equals(tS.toString());
    }
}
