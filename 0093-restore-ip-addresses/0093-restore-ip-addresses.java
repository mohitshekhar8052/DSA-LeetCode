import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }
    
    private void backtrack(String s, int index, int parts, String current, List<String> result) {
        // If we have 4 parts and used all characters
        if (parts == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); // remove last dot
            return;
        }
        
        // If invalid state
        if (parts == 4 || index == s.length()) {
            return;
        }
        
        // Try segment lengths 1 to 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String segment = s.substring(index, index + len);
            
            // Check valid segment
            if ((segment.startsWith("0") && segment.length() > 1) || 
                Integer.parseInt(segment) > 255) {
                continue;
            }
            
            backtrack(s, index + len, parts + 1, current + segment + ".", result);
        }
    }
}
