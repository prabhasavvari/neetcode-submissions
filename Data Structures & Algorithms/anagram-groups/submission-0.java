class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){ 
            // count char freqency  
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                sb.append('#').append(freq[i]);
            }

            String key = sb.toString(); //unique key ex: #12#2..

            // create new pair in map
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s); // add matched new string to the key
        }

        return new ArrayList<>(map.values());
    }
}
