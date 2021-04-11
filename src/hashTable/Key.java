package hashTable;

public class Key {
	private String key; 
	public Key(String k) {
		key = k;
	}
	public String getKey() {
		return key;
	}
	public int hashMethod() {
		int hashcode = 0;
		String key = this.getKey();
		for(int i = 0; i < key.length(); i++) {
		hashcode = hashcode + (int) key.charAt(i);
		
		}
		return (hashcode % 13);
	}
}
