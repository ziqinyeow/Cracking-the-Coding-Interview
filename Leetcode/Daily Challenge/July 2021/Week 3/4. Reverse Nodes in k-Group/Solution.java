
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        if (k == 1 || list.size() < k) {
            return head;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < list.size(); i += k) {
            if (list.size() - i < k) {
                break;
            }
            for (int j = i; j < i + k; j++) {
                s.push(list.get(j));
            }
            for (int j = i; j < i + k; j++) {
                list.set(j, s.pop());
            }
        }

        ListNode dummy = new ListNode(0, head);
        for (int i = 0; i < list.size(); i++) {
            head.val = list.get(i);
            head = head.next;
        }
        return dummy.next;
    }
}
