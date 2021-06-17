package practice;

public class Addition {
    public static void main(String[] args) {
        
    }
    // 2->4->3  l1          9->9->9->9->9->9->9
    // 5->6->4  l2          9->9->9->9
    // 7->0->8  head        8->9->9->9->0->0->0->1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0, sum = 0;

        while(l1.next != null || l2.next != null){
            sum = l1.val + l2.val + carry;

            if(sum > 9){
                sum = sum % 10;
                carry = sum / 10;
            }
            current.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            current.next = new ListNode();
        }
        while(l1.next != null){
            sum = l1.val + carry;
            if(sum > 9){
                sum = sum % 10;
                carry = sum / 10;
            }
            current.val = sum;
            l1 = l1.next;
            current.next = new ListNode();
        }
        return head;
    }
}

class ListNode{

    int val;
    ListNode next;

    ListNode(){
        next = null;
    }

    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
