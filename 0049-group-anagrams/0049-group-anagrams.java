class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
                Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // convert string to char array
            char[] arr = s.toCharArray();
            Arrays.sort(arr);   // sort characters
            String key = new String(arr);

            // if key not present, add new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // add original string to its group
            map.get(key).add(s);
        }

        // return all grouped anagrams
        return new ArrayList<>(map.values());

    }
}