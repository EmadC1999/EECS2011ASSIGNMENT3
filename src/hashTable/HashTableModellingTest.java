package hashTable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class HashTableModellingTest {

	/* Test used to ensure the map can be search for a certain key as well as searched
	 * for the value that a certain key is paired with
	 */
	@Test
	void entrySearching() {
		HashTable<Integer> map= new HashTable<Integer>();
		
		//Tests the functionality of the keyPresent and searchValue methods
		map.insert("testKey", 25);
		assertTrue(map.keyPresent("testKey"));
		assertEquals(map.searchValue("testKey"), 25);
		
		map.insert("Contact1", 5);
		assertTrue(map.keyPresent("Contact1"));
		assertEquals(map.searchValue("Contact1"), 5);
		
		map.insert("KMs_Driven", 100000);
		assertTrue(map.keyPresent("KMs_Driven"));
		assertEquals(map.searchValue("KMs_Driven"), 100000);
		
		//Tests for Other Objects
		HashTable<Date> map2 = new HashTable<Date>();
		map2.insert("Date", new Date());
		assertTrue(map2.keyPresent("Date"));
		
	}
	
	/* Tests the functionality of entry removal for the HashTable class */
	@Test
	void entryRemoval() {
		HashTable map = new HashTable();
		
		map.insert("John", 90);
		map.insert("Speed", 50);
		map.insert("Volume", 100);
		
		//Tests the functionality of the delete method
		map.delete("Speed");
		assertFalse(map.keyPresent("Speed"));
		assertEquals(map.searchValue("Speed"), null);
		
		map.delete("John");
		assertFalse(map.keyPresent("John"));
		assertEquals(map.searchValue("John"), null);
		
		
	}
	
	/* Tests if the HashTable can handle the over-writing of incorrect entry values with the same key */
	@Test
	void doubleEntry() {
		HashTable map = new HashTable();
		
		map.insert("mode", 10);
		map.insert("mode", 2);
		
		assertEquals(map.searchValue("mode"), 2);
	}
	

}
