package hashTable;
import java.util.*;

public class HashTable <T> {
	LinkedList<Entry<T>>[] hashTable = new LinkedList[13];
	
	public HashTable(){
		
	}
	
	public int hashMethod(String k) {
		int hashcode = 0;
		for(int i = 0; i < k.length(); i++) {
		hashcode = hashcode + (int) k.charAt(i);
		}
		return (hashcode % 13);
	}
	
	public void insert(String k, T v) {
		//hash method returns one of 13 buckets where 
		//the key will be stored based on the corresponding hash code
		int index = hashMethod(k);
		
		//If the bucket is empty, instantiate a linked list to store new entries
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
			hashTable[index].add(new Entry(k, v));
			return;
		}
		// if the Linked list has already been instantiated, add a new node
		//at the end of the linked list 
		else {
			for(Entry entry : hashTable[index]) {
				if(entry.key.equals(k)) {
					entry.value = v;
					return;
				}
			}
			hashTable[index].addFirst(new Entry(k,v));
			return;
		}
	}
	
	//Method to find value that corresponds to a given key
	public T searchValue(String k) {
		//index tells us which bucket to search in 
		int index = hashMethod(k);
		
		//if the bucket is not instantiated, return null
		if(hashTable[index] == null) {
			return null;
		}
		else {
		// loop through the linked list looking for Key K to determine 
		// corresponding value v
		for(Entry entry : hashTable[index]) {
			if(entry.key.equals(k)) {
				return (T) entry.value;
			}
		}
		// in the situation it is not found, return null
		}
		return null;
	}
	
	public void delete(String k) {
		//If the key is non existent, return null
		if(k == null) {
			return;
		}
		// find the bucket corresponding to the key string by hashing the
		// given key
		int index = hashMethod(k);
		
		//If the hash table array has not had the linked list instantiated as of yet
		//return null
		if(hashTable[index] == null) {
			return;
		}
		
		// create a null node to swap with the corresponding Key in the situation
		//that the corresponding key is found
		Entry delete = null;
		
		//Loop through bucket and look for key
		for(Entry entry : hashTable[index]) {
			if(entry.key.equals(k)) {
				//if key is found, set delete to node which needs to be deleted 
				delete = entry;
				break;
			}
			
		}
		
		if(delete == null) {
			//If no node is found, exit
			return;
		}
		else {
			//remove the Entry "Delete" from the node in the linked list
			hashTable[index].remove(delete);		
			}
	}
	
	//Searches to check if a given key is present in the hash table
	public boolean keyPresent(String k) {
		//if the key is null, break
		if(k == null) {
			return false;
		}
		
		// find the bucket corresponding to the key string by hashing the
		// given key
		int index = hashMethod(k);
		//if hash Table at index has not been instantiated, return false
		if(hashTable[index] == null) {
			return false;
		}

		//If hash table at index is instantiated, loop through bucket 
		//checking to see if key is present in bucket 
		for(Entry entry : hashTable[index]) {
			if(entry.key.equals(k)) {
				return true;
			}
		}
		return false;
	}
	
	public void dumpMap()
	{
		for (int i = 0; i < 13; ++i)
		{
			if ( hashTable[i] != null)
			{
				for (Entry entry : hashTable[i])
				{
					System.out.println(entry.key + ": " + entry.value + ", Hashcode: " + hashMethod(entry.key) + "\n");
				}
			}	
		}
	}
	
}
