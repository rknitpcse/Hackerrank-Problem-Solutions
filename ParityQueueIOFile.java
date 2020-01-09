import java.io.*;
/*
 * Developer Name: Rakesh Kumar
 * LinkedIn Profile: https://in.linkedin.com/in/rknitpcse-rkuohcs
 */
import java.util.*;
class Task{
	//private member variables 
	private int taskId = Integer.MIN_VALUE;
	private int priority = Integer.MAX_VALUE;
	//public member methods, getter and setter
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
}
//Comparing using Comparator Interface
class Sortbypriority implements Comparator<Task>
{
	@Override
	public int compare(Task t1, Task t2) {
		// TODO Auto-generated method stub
		return (t1.getPriority() - t2.getPriority());
	}
}
//Main Driver Class ParityQueueIOFile
public class ParityQueueIOFile  
{ 
	/*
	 * @Rakesh Kumar
	 */
	public static void main(String args[])  
	{  
		Scanner scan = new Scanner(System.in);
		try  
		{  
			
			//File file=new File("C:/Users/rakkumar/Desktop/a.txt");
			System.out.print("Enter the input file name: ");
			File file = new File(scan.next().toString());     //creates a new file instance
			scan.close(); 								      //close Scanner object scan
			FileReader fr = new FileReader(file);   		  //reads the file  
			BufferedReader br = new BufferedReader(fr);       //creates a buffering character input stream    
			Vector<Task> tasks = new Vector<Task>();	      //creates a vector tasks Task user define class type
			String line;                                   
			while((line=br.readLine())!=null)  
			{  
				String[] items = line.split(" ");             //splitting taskId and priority
				int taskId = Integer.parseInt(items[0]);	  //parsing String to integer and assigning to taskId
				int priority = Integer.parseInt(items[1]);    //parsing String to integer and assigning to priority
				Task tempTask = new Task();                   //creates new instance of Task class
				tempTask.setTaskId(taskId);                   //assigning taskId into the Task member variable
				tempTask.setPriority(priority);
				tasks.add(tempTask);                          //inserting the new instance into the tasks vector
				tempTask = null;   
			}  
			Iterator<Task> itr = tasks.iterator();            //creates new instance of Iterator for traversing data of tasks Vector
			while(itr.hasNext())
			{
				Task tmpTask = itr.next();                    //going to the next object of tasks Vector
				System.out.println("TaskId: "+tmpTask.getTaskId()+" Priority: "+ tmpTask.getPriority());
			}
		    Collections.sort(tasks, new Sortbypriority());    //sorting based on priority
		    System.out.println("After Sorting: ");
		    Iterator<Task> itr1 = tasks.iterator();           //creates new instance of Iterator for traversing data of tasks Vector
			while(itr1.hasNext())
			{
				Task tmpTask = itr1.next();                   //going to the next object of tasks Vector
				System.out.println("TaskId: "+tmpTask.getTaskId()+" Priority: "+ tmpTask.getPriority());
			}
			fr.close();                                       //closes the stream and release the resources    
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  
	}  
}  