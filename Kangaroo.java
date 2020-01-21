import java.util.*;
public class Kangaroo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  scan = new Scanner(System.in);
		String[] x1v1x2v2_tmp = scan.nextLine().split(" ");
		if(x1v1x2v2_tmp.length == 4)
		{
			int x1 = Integer.parseInt(x1v1x2v2_tmp[0]);
			int v1 = Integer.parseInt(x1v1x2v2_tmp[1]);
			int x2 = Integer.parseInt(x1v1x2v2_tmp[2]);
			int v2 = Integer.parseInt(x1v1x2v2_tmp[3]);
			System.out.println(kangaroo(x1, v1, x2, v2));
		}
		scan.close();
	}

	private static String kangaroo(int x1, int v1, int x2, int v2) {
		// TODO Auto-generated method stub
		if( (v1-v2) > 0 && (x2-x1) % (v1-v2) == 0) 
			return "YES";
		else		
			return "NO";
	}
}
