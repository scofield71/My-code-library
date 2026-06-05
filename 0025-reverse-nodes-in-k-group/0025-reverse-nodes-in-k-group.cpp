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

    ListNode* reverseKGroup(ListNode* head, int k) {
        int count = 1;
        ListNode* tmp = head;
        while(tmp!=NULL && count<k) {
            tmp = tmp->next;
            count++;
        }
        if(tmp==NULL) return count==k ? reverseList(head) : head;
        ListNode* nextGroup = tmp->next;
        tmp->next = NULL;
        ListNode* newHead = reverseList(head);
        ListNode* tail = head;
        head->next = nextGroup;
        while(nextGroup!=NULL) {
            tmp = nextGroup;
            count=1;
            while(tmp!=NULL && count<k) {
                tmp = tmp->next;
                if(tmp!=NULL) count++;
            }
            if(tmp==NULL) {
                if (count==k) {
                    cout<<"Count meet"<<endl;
                    tail->next = NULL;
                    ListNode* tmpHead = reverseList(nextGroup);
                    tail->next = tmpHead;
                    nextGroup->next = NULL;
                    return newHead;
                } else {
                    return newHead;
                }
            }
            tail->next = NULL;
            ListNode* tmpNextGroup = tmp->next;
            tmp->next = NULL;
            ListNode* tmpHead = reverseList(nextGroup);
            nextGroup->next = tmpNextGroup;
            tail->next = tmpHead;
            tail = nextGroup;
            nextGroup = tmpNextGroup;
        }
        return newHead;
    }
};