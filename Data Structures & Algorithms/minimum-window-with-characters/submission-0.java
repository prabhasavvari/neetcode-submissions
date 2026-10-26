class Solution {
    public String minWindow(String s, String t) {
        //store the t's character count in map
        HashMap<Character, Integer> targetCounts = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            targetCounts.put(c, (targetCounts.getOrDefault(c, 0) + 1));
        }

        //store the crrent window characters count in map
        HashMap<Character, Integer> windowCounts = new HashMap<>();

        int formed = 0;
        int left = 0;
        int minLengthWindow = Integer.MAX_VALUE;
        String resultString = "";

        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            windowCounts.put(c, (windowCounts.getOrDefault(c, 0) + 1));

            if(targetCounts.containsKey(c) && windowCounts.get(c).intValue() == targetCounts.get(c).intValue()){
                formed++;
            }

            // While our window is valid, record the length and try to shrink from the left
            while (left <= right && formed == targetCounts.size()) {
                // 1. Record the current valid window as a potential minimum answer
                if(right - left + 1 < minLengthWindow){
                    minLengthWindow = right - left + 1;
                    resultString = s.substring(left, right+1);
                }

                // 2. Character about to be kicked out of the window
                char leftChar = s.charAt(left);
                
                // 3. Before removing it, check if removing it will BREAK our validity
                if (targetCounts.containsKey(leftChar) && windowCounts.get(leftChar).intValue() == targetCounts.get(leftChar).intValue()) {
                    formed--; // Uh-oh, we lost a required character match!
                }

                // 4. Actually remove it from the window count and slide left forward
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                left++;
            }
        }

        return resultString;
    }
}
