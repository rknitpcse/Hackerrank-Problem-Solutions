import java.util.*;
public class FindRunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Vector<Integer> nums = new Vector<Integer>();
		while(n-- > 0)
		{
			nums.add(scan.nextInt());
			int midIndex = (int) Math.floor(nums.size() / 2);
			Collections.sort(nums);
			if(nums.size() % 2 == 0)
				System.out.println( (float) ( ((float)nums.get(midIndex-1) + (float)nums.get(midIndex)) / 2.0 ) );
			else
				System.out.println( (float)nums.get(midIndex) );
		}
		scan.close();
	}
	
}
