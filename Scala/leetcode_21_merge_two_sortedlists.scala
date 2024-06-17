/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = (list1, list2) match {
       case (null, list2) => list2
       case (list1, null) => list1
       case (list1, list2) if (list1.x <= list2.x) => {
            list1.next = mergeTwoLists(list1.next, list2)
            list1
       }
       case (list1, list2) if (list1.x > list2.x) => {
            list2.next = mergeTwoLists(list1, list2.next)
            list2
       }
    }
}