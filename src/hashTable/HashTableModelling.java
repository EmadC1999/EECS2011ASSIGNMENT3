package hashTable;

public class HashTableModelling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable test = new HashTable();
		Key test2 = new Key("Test2");
		Key test3 = new Key("TestingYfdbd");
		Key test4 = new Key("fqweg");
		Key test5 = new Key("Test2");
		System.out.println(test2.hashMethod());
		System.out.println(test3.hashMethod());
		System.out.println(test4.hashMethod());
		System.out.println(test5.hashMethod());
		
	}

}
