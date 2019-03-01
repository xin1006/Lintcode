/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//每个LinkedList最多遍历两次, 时间复杂度 O(n), n为两LinkedList长度和空间复杂度O(1)

public class Solution {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        int lengthA = 0;
        int lengthB = 0;
        while (nodeA != null) {
            nodeA = nodeA.next;
            lengthA++;
        }
        
        while (nodeB != null) {
            nodeB = nodeB.next;
            lengthB++;
        }
        nodeA = headA;
        nodeB = headB;
        
        while(lengthA > lengthB){
            nodeA = nodeA.next;
            lengthA--;
        }
        while(lengthA < lengthB){
            nodeB = nodeB.next;
            lengthB--;
        }
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
        
    }
}