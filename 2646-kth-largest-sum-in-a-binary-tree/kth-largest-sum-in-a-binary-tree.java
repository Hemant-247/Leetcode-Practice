class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        ArrayList<Long> sums = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode front = q.remove();
                sum += front.val;

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            sums.add(sum);
        }

        if (sums.size() < k) return -1;

        Collections.sort(sums, Collections.reverseOrder());

        return sums.get(k - 1);
    }
}