package hashTable;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable main = new HashTable();
		
		
		Scanner mainScan = new Scanner(System.in);  
		String call = "true";
	    while(call != "q" || call != "Q") {
	    	System.out.println("Please enter a Method: \n Please input the character corresponding to the method you would like to invoke\n(i)nsert \n(d)elete \n(s)earch \n(p)rint \n(q)uit");
	    call = mainScan.nextLine();

	    if(call.equals("i") || call.equals("I")) {
	    	
	    	System.out.println("Enter Key you wish to insert");
	    	String key = mainScan.nextLine();
	 	   	System.out.println("Enter number value corresponding to key");
	 	   	String valueString = mainScan.nextLine();
	 	   	int value = Integer.parseInt(valueString);
	    	main.insert(key, value);
	    }
	    
	    else if(call.equals("d") || call.equals("D"))  {
	    	System.out.println("Enter Key you wish to delete");
	    	String key = mainScan.nextLine();
	    	main.delete(key);
	    }
	    
	    else if(call.equals("s") || call.equals("S")) {
	    	System.out.println("Enter Key of which you wish to see the correspinding value");
	    	String key = mainScan.nextLine();
	    	System.out.println(main.searchValue(key));
	    }
	    
	    else if(call.equals("p") || call.equals("P")) {
	    	main.dumpMap();
	    }
	    
	    else if(call.equals("q") || call.equals("Q")) {
	    	break;
	    }
	    
	    else {
	    	System.out.println("Invalid entry, please re-enter");
	    }
	    
	   // String key = mainScan.nextLine();
	   //System.out.println("Enter value");
	   // String value = mainScan.nextLine();
	}
	}

}
