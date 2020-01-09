import java.util.*;
/*
 * Problem Name: Jesse and Cookies
 * Problem Link: https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 * This solution is fine but the execution time is more. So this is not efficient.
 * For reducing time we need to use heap(find minimum : O(1), minheapify: O(log n)) 
 * instead of sort(find minimum : O(1), minheapify: O(n log n))
 */
public class JesseandCoockies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		Vector<Integer> nums = new Vector<Integer>();
		for(int i=0; i < n; i++)
			nums.add(scan.nextInt());
		//System.out.println(nums);
		int noOperations = 0;
		while(true)
		{
			Collections.sort(nums);
			if(nums.size() >= 2 )
			{
				if(!checkSweetness(nums, k))
				{
					int least_a = nums.get(0);
					int least_b = nums.get(1);
					int newSweet = (least_a + (2 * least_b));
					//System.out.println("least_a: " + least_a);
					//System.out.println("least_b: " + least_b);
					//System.out.println("newSweet: " + newSweet);
					nums.remove(0);
					nums.remove(0);
					//System.out.println("After deletion: "+nums);
					nums.add(newSweet);
					//System.out.println("After adding newSweet: "+nums);
					noOperations += 1;
					//System.out.println("noOperations: " + noOperations);
					//System.out.println(nums);
				}
				else
				{
					System.out.println(noOperations);
					break;
				}
			}
			else
			{
				System.out.println(-1);
				break;
			}
			
		}
		scan.close();
	}

	private static boolean checkSweetness(Vector<Integer> nums, int k) {
		// TODO Auto-generated method stub
		boolean sweetness = true;
		for(int i=0; i<nums.size(); i++)
		{
			if(nums.get(i) < k)
			{
				sweetness = false;
				break;
			}
		}
		return sweetness;
	}
	
}
