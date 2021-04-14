package Splay_Tree_Map;

public class Node <T>{
	//attributes of a node
	private String key;
	private T value = null; 
	public Node<T> parent = null;
	public Node<T> left=null;
	public Node<T> right=null;

	/**
	 * Constructor
	 * @param key
	 * @param value
	 */
	public Node(String key,T value) {
		this.value = value;
		this.key=key;
		left=null;
		right=null;
		parent=null;
	}
	/**
	 * Default constructor
	 */
	public Node() {
		this(null,null,null,null,null);
	}
	/**
	 * Constructor 
	 * @param key
	 * @param value
	 * @param parent
	 * @param left
	 * @param right
	 */
	public Node(String key, T value, Node<T> parent, Node<T> left, Node<T> right)
	{
		this.key=key;
		this.value = value;
		this.left=left;
		this.right=right;
		this.parent=parent;
	}
	/**
	 * Constructor to copy a node
	 * @param node
	 */
	public Node(Node<T> node)
	{
		this(node.getKey(),(T)node.getValue(), node.parent, node.left, node.right);
	}
	//mutator methods
	public void setValue(T value) {
		this.value = value;
	}
	public void setKey(String str)
	{
		key=str;
	}

	public T getValue()
	{
		return value;
	}
	public String getKey()
	{
		return key;
	}
	

}
