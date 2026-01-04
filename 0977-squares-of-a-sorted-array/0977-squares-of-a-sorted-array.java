class Solution {
    public int[] sortedSquares(int[] nums) {

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // split negatives & positives
        for (int num : nums) {
            if (num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // if only positives
        if (neg.size() == 0) {
            for (int i = 0; i < pos.size(); i++) {
                pos.set(i, pos.get(i) * pos.get(i));
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();
        }

        // if only negatives
        if (pos.size() == 0) {
            for (int i = 0; i < neg.size(); i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }
            Collections.reverse(neg);
            return neg.stream().mapToInt(Integer::intValue).toArray();
        }

        // square negatives
        for (int i = 0; i < neg.size(); i++) {
            neg.set(i, neg.get(i) * neg.get(i));
        }
        Collections.reverse(neg);

        // square positives
        for (int i = 0; i < pos.size(); i++) {
            pos.set(i, pos.get(i) * pos.get(i));
        }

        // merge two sorted lists
        int i = 0, j = 0, id = 0;
        int n1 = neg.size(), n2 = pos.size();
        int[] res = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (neg.get(i) <= pos.get(j)) {
                res[id++] = neg.get(i++);
            } else {
                res[id++] = pos.get(j++);
            }
        }

        while (i < n1) {
            res[id++] = neg.get(i++);
        }

        while (j < n2) {
            res[id++] = pos.get(j++);
        }

        return res;
    }
}
