import java.util.*;
/*
 * Problem Name: Reverse a doubly linked list
 * Problem Link: https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
public class ReverseDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // the reverse member function reverse the whole DLL
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    	DoublyLinkedListNode start = head;
    	Stack<Integer> stack = new Stack<Integer>();
    	while(start != null)
    	{
    		stack.push(start.data);
    		start = start.next;
    	}
    	start = head;
    	while(start != null)
    	{
    		start.data = stack.pop();
    		start = start.next;
    	}
    	return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int t = scanner.nextInt();
        

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1);
            
        }

        scanner.close();
    }
}
