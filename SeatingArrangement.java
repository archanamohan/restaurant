import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Tables extends Thread
{
	private Thread t;
	private String grpName;
	private String threadName;
	   
	Tables(String name, String grp)
	{
		threadName = name;
		grpName = grp;
		System.out.println("Group "+ grp +" occupying " +  threadName );
	}
	
	public void run()
	{
		System.out.println("Running "+ grpName +"  "+threadName );
	    try
	    {
	    	int x = (int)(Math.random()*(4500-3000)) + 3000;
	    	// Let the thread sleep for a while.
	        Thread.sleep(x);
	    }
	    catch (InterruptedException e)
	    {
	    	System.out.println("Table " +  threadName + " interrupted.");
	    }
	    System.out.println("Table " +  threadName + " having Group "+grpName+" is now empty.");
	}
}


public class SeatingArrangement
{
	public static void seatingArrangement()
	{
		String g = MasterClass.customerInQueue.entrySet().iterator().next().getKey(); //get the group name
		int n = MasterClass.customerInQueue.entrySet().iterator().next().getValue(); //get the number of people in the group
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		if(n <= 2)
		{
			Tables T1 = new Tables( "Table-1", g);
			executor.execute(T1);
		}
		else if(n > 2 && n <= 4)
		{
			Tables T2 = new Tables( "Table-2", g);
			executor.execute(T2);
		}
		else if(n > 4 && n <= 8)
		{
			Tables T3 = new Tables( "Table-3", g);
			executor.execute(T3);
		}
		else if(n > 8)
		{
			//to be decided
		}
		executor.shutdown();
		return;
	}
}
