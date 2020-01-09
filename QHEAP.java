import java.util.*;
/*
 * Problem Name: QHEAP1
 * Problem Link: https://www.hackerrank.com/challenges/qheap1/problem
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
public class QHEAP {

    public static void main(String ... args) {
    	// implementing heap variable
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); 
        Scanner scan = new Scanner(System.in);
        int queries = scan.nextInt();
        while(queries-- > 0)
            {
            	int opration = scan.nextInt();
            	int data=0;
            	switch(opration)
                {
                	case 1:
                		data = scan.nextInt();
                		heap.offer(data); // add data
                		break;
                	case 2:
                		data = scan.nextInt();
                		heap.remove(data);
                		break;
                	case 3:
                		System.out.println(heap.peek());
                		break;
                }
            }
        scan.close();
    }
}