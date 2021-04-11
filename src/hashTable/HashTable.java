package hashTable;
import java.util.*;

public class HashTable {
	LinkedList<Entry>[] hashTable = new LinkedList[13];
	int size = 0;
	public HashTable(){
		
	}
	public void insert(Key k, Value v) {
		//hash method returns one of 13 buckets where 
		//the key will be stored based on the corresponding hash code
		int index = k.hashMethod();
		
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
			hashTable[index].add(new Entry(k,v));
			return;
		}
	}
	
	//Method to find value that corresponds to a given key
	public Value searchValue(Key k) {
		//index tells us which bucket to search in 
		int index = k.hashMethod();
		
		//if the bucket is not instantiated, return null
		if(hashTable[index] == null) {
			return null;
		}
		else {
		// loop through the linked list looking for Key K to determine 
		// corresponding value v
		for(Entry entry : hashTable[index]) {
			if(entry.key.equals(k)) {
				return entry.value;
			}
		}
		// in the situation it is not found, return null
		}
		return null;
	}
	
	public void delete(Key k) {
		//If the key is non existent, return null
		if(k == null) {
			return;
		}
		// find the bucket corresponding to the key string by hashing the
		// given key
		int index = k.hashMethod();
		
		//If the hashtable array has not had the linked list instantiated as of yet
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
			hashTable[index].remove(delete);		}
	}
	
	//Searches to check if a given key is present in the hash table
	public boolean keyPresent(Key k) {
		//if the key is null, break
		if(k == null) {
			return false;
		}
		
		// find the bucket corresponding to the key string by hashing the
		// given key
		int index = k.hashMethod();
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
	
}
