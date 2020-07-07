package addtwonumbers;

/**
 * @author zhaohongxin
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currVal;
        int preVal = 0;

        currVal = l1.val + l2.val + preVal;
        if ((currVal)/10 >= 1) {
            currVal = currVal - 10;
            preVal = 1;
        } else {
            preVal = 0;
        }
        ListNode result = new ListNode(currVal);
        ListNode tmp = result;
        while (null != l1.next && null != l2.next) {
            l1 = l1.next;
            l2 = l2.next;
            currVal = l1.val + l2.val + preVal;
            if ((currVal)/10 >= 1) {
                currVal = currVal - 10;
                preVal = 1;
            } else {
                preVal = 0;
            }
            tmp.next = new ListNode(currVal);
            tmp = tmp.next;
        }
        if (l2.next != null) {
           l1 = l2;
        }
        while (null != l1.next) {
            l1 = l1.next;
            currVal = l1.val + preVal;
            if ((currVal)/10 >= 1) {
                currVal = currVal - 10;
                preVal = 1;
            } else {
                preVal = 0;
                tmp.next = new ListNode(currVal);
                tmp.next.next = l1.next;
                break;
            }
            tmp.next = new ListNode(currVal);
            tmp = tmp.next;
        }
        if (preVal == 1) {
            tmp.next = new ListNode(1);
        }
        return result;
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
