/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* helper(Node* node, unordered_map<Node*, Node*>& clone) {
        if(node==NULL) return NULL;
        if(clone.find(node)!=clone.end()) return clone[node];
        // cout<<node<<" "<<parent<<endl;
        Node* newNode = new Node(node->val);
        clone[node]=newNode;
        for(int i=0;i<node->neighbors.size();i++) {
            Node* p = helper(node->neighbors[i],clone);
            newNode->neighbors.push_back(p);
        }
        return newNode;
    }
    Node* cloneGraph(Node* node) {
        unordered_map<Node*, Node*> clone;
        return helper(node,clone);
    }
};