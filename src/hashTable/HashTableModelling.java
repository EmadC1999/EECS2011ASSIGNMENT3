package hashTable;

public class HashTableModelling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable test = new HashTable();
		
		test.insert("Key1", 23);
		test.insert("/", 100);
		//Entry testEntry = new Entry(new Key ("Key2") , new Value (25));
		System.out.println(test.keyPresent("Key1"));
		System.out.println(test.keyPresent("/"));
		
		System.out.println(test.searchValue("/"));
		
		test.delete("/");
		test.dumpMap();
		test.delete("Key1");
		System.out.println(test.keyPresent("Key1"));
		test.dumpMap();
		
	}
}
