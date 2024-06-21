/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        var prev: ListNode = null
        var curr: ListNode = head
        while (curr != null){
            val nextTemp=curr.next
            curr.next=prev
            prev=curr
            curr=nextTemp
        }
        prev
    }
}