class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();

        while(i < str.length()){
            // Find the position of the '#' delimiter
            int hashIdx = str.indexOf('#', i);

            // Extract the length number stored before the '#'
            int length = Integer.parseInt(str.substring(i, hashIdx));

            // Move pointer past the '#' to get the actual string
            int start = hashIdx + 1;
            int end = start + length;

            result.add(str.substring(start, end));

            // Advance pointer to the start of the next length prefix
            i = end;
        }

        return result;
    }
}
