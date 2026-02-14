class Solution {
    public int maximumSum(int[] arr) {
       int noDelete = arr[0];
       int oneDelete = 0;
        int ans = arr[0];

        for(int i = 1;i<arr.length;i++){
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;
            
            noDelete = Math.max(noDelete+arr[i],arr[i]);
    
            oneDelete = Math.max(prevOneDelete +arr[i],prevNoDelete);
            ans = Math.max(ans,Math.max(noDelete,oneDelete));
        }
        return ans;
    }
}