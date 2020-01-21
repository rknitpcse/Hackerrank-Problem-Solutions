import java.io.*;
public class IOClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader in =null;
		FileWriter out = null;
		try {
			in = new FileReader("C:/Users/rakkumar/Desktop/Codes/Java/FirstProject/src/a.txt");
			out = new FileWriter("C:/Users/rakkumar/Desktop/Codes/Java/FirstProject/src/b.txt");
			int c;
			while((c = in.read()) != -1)
			{
				out.write(c);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		finally {
			if(in!=null)
				in.close();
			if(out!=null)
				out.close();
			System.out.println("Process Completed..");
		}

	}

}
