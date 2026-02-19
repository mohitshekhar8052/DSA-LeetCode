class Solution {
    public int countBinarySubstrings(String s) {

        int prevGroup = 0;
        int currGroup = 1;
        int count = 0;

        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;   // same character group continues
            } else {
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // last group comparison
        count += Math.min(prevGroup, currGroup);

        return count;
    }
}
