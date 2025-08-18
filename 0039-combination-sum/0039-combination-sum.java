class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int[] candidates, int remaining, int start) {
        if (remaining < 0) {
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            currentCombination.add(candidates[i]);
            backtrack(result, currentCombination, candidates, remaining - candidates[i], i);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}