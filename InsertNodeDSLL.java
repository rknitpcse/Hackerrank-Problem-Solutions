import java.util.*;
/*
 * Problem Name: Inserting a Node Into a Sorted Doubly Linked List
 * Problem Link: https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem 
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
public class InsertNodeDSLL {

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
    /*
    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
	*/
    public static void printDoublyLinkedList(DoublyLinkedListNode node) {
        while (node != null) {
            
            System.out.print(node.data + " ");

            node = node.next;

        }
        System.out.println();
    }
    //sortedInsert member function to insert a node that not violate the DSLL properties
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    	DoublyLinkedListNode start = head;
    	DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    	DoublyLinkedListNode startPrev=null;
    	while(start != null)
    	{
    		if(start.data >= data)
    		{
    			// inserting newNode at first position
    			if(start == head)
    			{
    				DoublyLinkedListNode headNodeAddress = start.prev;
    				DoublyLinkedListNode prevNode = head;
    				head = newNode;
    				newNode.next = prevNode;
    				newNode.prev = headNodeAddress;
    				break;
    			}
    			// inserting newNode at middle position
    			else
    			{
        			DoublyLinkedListNode prevNode = start.prev;
        			newNode.prev = prevNode;
        			newNode.next = start; 
        			prevNode.next = newNode;
        			break;
    			}
    			
    		}
    		startPrev = start;
    		start = start.next;
    	}
    	// inserting newNode at last position
    	if(start == null && startPrev != null)
    	{
    		startPrev.next = newNode;
    		newNode.prev = startPrev;
    	}
    	return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);
            
            printDoublyLinkedList(llist1);
            //printDoublyLinkedList(llist1, " ", bufferedWriter);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
