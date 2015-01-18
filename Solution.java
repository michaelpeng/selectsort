public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode headNode = head;
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode currPrev = head;
            ListNode curr = head.next;
            while (curr != null) {
                ListNode currNext = curr.next;
                ListNode comp = head;
                ListNode prev = null;
                boolean unmoved = true;
                while (comp != curr) {
                    if (curr.val >= comp.val) {
                        prev = comp;
                        comp = comp.next;
                    } else {        
                        currPrev.next = currNext;
                        unmoved = false;            
                        if (comp == head) {   
                            curr.next = head;
                            head = curr;
                        }
                        else {                 
                            curr.next = comp;
                            prev.next = curr;
                        }
                        break;
                    }
                }
                if (unmoved) {
                    currPrev = curr;
                }
               curr = currNext;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode thisHead = new ListNode(4);
        thisHead.next = new ListNode(19);
        thisHead.next.next = new ListNode(14);
        thisHead.next.next.next = new ListNode(5);
        // thisHead.next.next.next.next = new ListNode(8);
        // thisHead.next.next.next.next.next = new ListNode(3);
        ListNode wowHead = insertionSortList(thisHead);
        System.out.println(wowHead.val);
        wowHead = wowHead.next;
        System.out.println(wowHead.val);
        wowHead = wowHead.next;
        System.out.println(wowHead.val);
        wowHead = wowHead.next;
        System.out.println(wowHead.val);
        wowHead = wowHead.next;
        System.out.println(wowHead);
    }
}