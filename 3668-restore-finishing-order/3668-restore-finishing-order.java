class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set = new HashSet<>();
        for (int f : friends) {
            set.add(f);
        }

        List<Integer> list = new ArrayList<>();
        for (int o : order) {
            if (set.contains(o)) {
                list.add(o);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
