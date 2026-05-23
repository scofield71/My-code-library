/*
// Definition for a Node.
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
    public Node helper(Node node, HashMap<Node,Node> ourmap) {
        if(node==null) return null;
        if(ourmap.containsKey(node)) return ourmap.get(node);
        Node newNode = new Node(node.val);
        ourmap.put(node,newNode);
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(helper(neighbor,ourmap));
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> ourmap = new HashMap<>();
        return helper(node,ourmap);
    }
}