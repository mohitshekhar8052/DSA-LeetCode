class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         Set<Integer> map = new HashSet<>();
         List<Integer> duplicates = new ArrayList<>();
         for(int num:nums){
            if(!map.add(num)){
                duplicates.add(num);
            }
         }
         return duplicates;
    }
}