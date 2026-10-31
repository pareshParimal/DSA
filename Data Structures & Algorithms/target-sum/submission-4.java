class Solution {
    class Node {
        int num;
        int target;

        Node(int num, int target) {
            this.num = num;
            this.target = target;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Node)) {
                return false;
            }

            Node other = (Node) obj;

            return num == other.num && target == other.target;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, target);
        }
    }
    int res, len;
    Integer[][] memo;
    Map<Node, Integer> map;
    public int findTargetSumWays(int[] nums, int target) {
        res = target;
        len = nums.length;
        map = new HashMap<>();
        return dfs(nums, 0, target);
    }

    int dfs(int[] nums, int ind, int target) {
        if (ind > len) {
            return 0;
        }
        if (ind == len) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        Node node = new Node(ind, target);

        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(
            node, dfs(nums, ind + 1, target - nums[ind]) + dfs(nums, ind + 1, target + nums[ind]));
        return map.get(node);
    }
}
