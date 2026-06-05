/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head==NULL || head->next==NULL) return head;
        ListNode* tail = head;
        ListNode* curNode = head->next;
        ListNode* nextNode = curNode->next;
        head->next = NULL;
        while(nextNode!=NULL) {
            curNode->next = tail;
            tail = curNode;
            curNode = nextNode;
            nextNode = nextNode->next;
        }
        curNode->next = tail;
        return curNode;
    }
};