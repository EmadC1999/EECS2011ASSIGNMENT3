package Splay_Tree_Map;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplayTreeMap myMap= new SplayTreeMap();
		myMap.insert("o", 15);
		myMap.insert("j", 10);
		myMap.insert("q", 17);
		myMap.insert("g", 7);
		myMap.insert("e", 5);
		myMap.insert("k", 11);
		myMap.insert("l", 12);
		myMap.insert("h", 8);
		
		System.out.println("=== check order ===");
		myMap.display();

		//add if to check if null then print not found else print value
		String find="g";
		Object val=myMap.search(find);
		if (val!=null)
			System.out.println(find+" found");
		else
			System.out.println(find+" not found");
		System.out.println("=== check order ===");
		myMap.display();
		find="h";
		val=myMap.search(find);
		if (val!=null)
			System.out.println(find+" found");
		else
			System.out.println(find+" not found");
		System.out.println("=== check order ===");
		myMap.display();
		find="i";
		val=myMap.search(find);
		if (val!=null)
			System.out.println(find+" found");
		else
			System.out.println(find+" not found");
		System.out.println("=== check order ===");
		myMap.display();
		myMap.remove("q");
		System.out.println("=== check order ===");
		myMap.display();
		myMap.insert("q", 17);
		System.out.println("=== check order ===");
		myMap.display();
		myMap.remove("o");
		System.out.println("=== check order ===");
		myMap.display();
		myMap.insert("l", 111);
		System.out.println("=== check order ===");
		myMap.display();
		System.out.println("Nodes: "+myMap.numberOfNodes()+" isEmpty: "+myMap.isEmpty());
		myMap.dumpTree();
		System.out.println("Nodes: "+myMap.numberOfNodes()+" isEmpty: "+myMap.isEmpty());


	}

}
