/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head) return NULL;
        unordered_map<Node*, Node*> ourmap;
        Node* newHead = new Node(head->val);
        ourmap[head] = newHead;
        Node* tmp = head->next;
        Node* tracker = newHead;
        while(tmp!=NULL) {
            Node* tmpNode = new Node(tmp->val);
            tracker->next = tmpNode;
            ourmap[tmp]=tmpNode;
            tmp=tmp->next;
            tracker=tracker->next;
        }
        tmp = head;
        tracker = newHead;
        while(tmp!=NULL) {
            tracker->random = ourmap[tmp->random];
            tmp = tmp->next;
            tracker = tracker->next;
        }
        return newHead;
    }
};