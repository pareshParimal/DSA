/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> mp = new HashMap<>();
        return dfs(node, mp);
    }

    Node dfs(Node node, Map<Node, Node> mp) {
        if (node == null) {
            return null;
        }

        if (mp.containsKey(node)) {
            return mp.get(node);
        }

        Node copy = new Node(node.val);
        mp.put(node, copy);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei, mp));
        }

        return copy;
    }
}