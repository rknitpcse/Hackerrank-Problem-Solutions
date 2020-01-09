import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Problem Name: Jesse and Cookies
 * Problem Link: https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
public class JACHackerRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); 
		for(int i=0; i < n; i++)
			heap.offer(scan.nextInt());
		int noOperations = 0;
		while(heap.peek() < k)
		{
			if(heap.size() >= 2 )
			{
				int least_a = heap.poll();
				int least_b = heap.poll();
				heap.offer(least_a + 2 * least_b);
				noOperations++;
			}
			else
			{
				noOperations = -1;
				break;
			}
		}
		System.out.println(noOperations);
		scan.close();
	}
}
