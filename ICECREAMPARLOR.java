import java.io.*;
import java.util.*;

public class ICECREAMPARLOR {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor( int m, Vector<Integer> arr)
    {
    	int[] selected = new int[2];
    	for(int i = 0; i < arr.size(); i++)
    	{
    		if(((m - arr.get(i))!= arr.get(i)) && (arr.contains(m - arr.get(i)) == true))
    		{
    			selected[0] = i+1;
    			selected[1] = arr.indexOf((m - arr.get(i)))+1;
    			break;
    		}
    		else if((m - arr.get(i)) == arr.get(i))
    		{
    			selected[0] = i;
    			int value = arr.get(i);
    			for(int j=i+1; i < arr.size(); i++)
    			{
    				if(arr.get(j) == value)
    				{
    						selected[1] = j+1;
    						break;
    				}
    			}
    		}
    	}
    	return selected;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException 
    {
        int tc = scanner.nextInt();
        while (tc-- > 0) 
        {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            Vector<Integer> arr = new Vector<Integer>();
            scanner.nextLine();
            String[] arrItems = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) 
                arr.add(Integer.parseInt(arrItems[i])) ;

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) 
            {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                	System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
