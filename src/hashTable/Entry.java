package hashTable;

public class Entry <T> {
	public String key;
	public T value;
	public Entry(String k, T v) {
		key = k;
		
		value = v;
	}
}
