import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class MasterClass
{
	public static LinkedHashMap<String, Integer> customerInQueue = new LinkedHashMap<String, Integer>();
	
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String csvFile = "C:\\Users\\Archana\\Desktop\\Restaurant\\input.csv";
		String line = "";
		String cvsSplitBy = ",";
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) 
			{
				String[] grp = line.split(cvsSplitBy);
				customerInQueue.put(grp[0], Integer.parseInt(grp[1]));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		Set set = customerInQueue.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext())
		{
	         Map.Entry me = (Map.Entry)i.next();
//	         System.out.print(me.getKey() + ": ");
//	         System.out.println(me.getValue());
	         SeatingArrangement.seatingArrangement();
	         i.remove();
	    }
	}

}
