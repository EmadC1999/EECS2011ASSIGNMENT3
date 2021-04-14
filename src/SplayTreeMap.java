package Splay_Tree_Map;

public class SplayTreeMap<T> {

	//attributes of SplayTreeMap
	private Node<T> root;
	private int entries=0; 	//records number of entries
	/** constructor	**/
	public SplayTreeMap()
	{
		//initial root
		root=null;
	}
	/**
	 * splay function which rearranges nodes of the tree map
	 * @param node - the node to rearrange in the tree map
	 */
	private void splay(Node<T> node) 
	{
		while (!isRoot(node)) 	//while the node still has parents
		{
			//parent and grandparent node, set using direct referencing.
			Node<T> parent = node.parent;
			Node<T> grand = parent.parent;
			//zig case
			if (grand==null) 
			{
				//if current node is parent's left node,
				//up left zig (rotate between current node and parent node)
				if (node==parent.left)
					rotate('L',node, parent); 
				//up right zig (rotate between current node and parent node)
				else rotate('R',node,parent);	
			}
			else 
			{
				//if current node is on the left branch
				if (node==parent.left)
				{
					//downwards slope diagonal zig zig
					if(parent == grand.left)  //if parent is on the left branch
					{
						//rotate between parent node and grandparent node
						rotate('L',parent,grand);
						//rotate between current node and parent node
						rotate('L',node,parent);
					}//zig zag going up left then up right
					else //if parent is on right branch
					{	// > zig-zag
						rotate('L',node,node.parent);
						rotate('R', node, node.parent);
					}
				}else		//if current node is on the left branch
				{
					if(parent==grand.left) //if parent is on left branch
					{	// < zig-zag
						rotate('R',node, node.parent);	//rotate between node and node parent
						rotate('L', node, node.parent);
					}else
					{	//upwards slope diagonal zig-zig
						//rotate between parent node and grandparent node
						rotate('R', parent, grand);	
						//rotate between current node and parent node
						rotate('R',node,parent);	
					}
				}
			}
		}
		root=node;		//set the root to current node once it has no parents
	}
	/**
	 * Insert function. Insert a key value pair to the tree, saved as a type node
	 * @param key
	 * @param value
	 */
	public void insert(String key, T value)
	{
		//store compare to values
		int cmp=0;
		//placeholder nodes
		Node<T> node=root;
		Node<T> parent=null;
		//while current node is non empty 
		while (node!=null)
		{
			parent=node;
			//compare nodes
			cmp=key.compareTo(parent.getKey());
			//store on right branch if more
			if (cmp>0)
				node=node.right;
			//store on left branch if less
			else if(cmp<0)
				node=node.left;
			//break if the given key already exists.
			//in that case just change the value
			else if (cmp==0)
			{
				node.setValue(value); 
				break;
			}
		}
		// making a new node, the node's position is sorted in the while loop above
		// if the map is empty or if key has not found
		if (cmp!=0 || root==null)
		{
			//initialize the node
			node= new Node<T>();
			node.setKey(key);
			node.setValue(value);
			node.parent=parent;	
			//adjust parent branches
			if (parent==null)
				root=node;
			else if (key.compareTo(parent.getKey())>0)
				parent.right=node;
			else parent.left=node;
			//splay the node
			splay(node);
			// increment number of entries
			entries++;
		}
	}
	/**
	 * Rotates or "switches" places between a child and parent nodes, with a given direction
	 * @param dir	specifies direction of the branch 'L' for left branch, 'R' for right branch
	 * @param child		child node
	 * @param parent 	parent node
	 */
	private void rotate(char dir, Node<T> child, Node<T> parent)
	{
		if (dir=='L')	//if child is on left branch, check requirements
		{
			if ((child == null) || (parent == null) || (parent.left != child) || (child.parent != parent))
				throw new RuntimeException("TREE ALLIGNMENT ERROR");
		}
		else	//if child is on left branch, check requirements
		{
			if ((child == null) || (parent == null) || (parent.right != child) || (child.parent != parent))
				throw new RuntimeException("TREE ALLIGNMENT RROR");
		}
		// child node switches places with child node's grandparent if not null
		if(parent.parent != null)
		{
			if(parent==parent.parent.left)
				parent.parent.left=(child);
			else
				parent.parent.right=(child);
		}
		//if child node is left branch
		if (dir=='L')
		{
			//replace parents for child's right branch
			if(child.right != null)
				child.right.parent=(parent);
			//switch/rotate between child and grand parent
			child.parent=(parent.parent);
			parent.parent=(child);
			//adjust branch nodes
			parent.left=child.right;
			child.right=parent;
		}else //child node is right branch
		{ 
			//replace parents for child's left branch
			if(child.left != null)
				child.left.parent=(parent);
			//switch/ rotate between child and grand parent
			child.parent=(parent.parent);
			parent.parent=(child);
			//adjust branch nodes
			parent.right=child.left;
			child.left=parent;
		}
	}
	/**
	 * Search function. Searches for the value corresponding to the given key
	 * @param key
	 * @return null if not found, otherwise returns the value
	 */
	public T search(String key)
	{
		//placeholder nodes
		Node<T> current=root;
		Node<T> last=null;
		//'flag' variable which stores compareTo values
		int cmp=0;	
		while(current!=null)
		{
			last=current;	//save the current node
			cmp=key.compareTo(current.getKey());	//compare each node's key
			if(cmp<0)
				current=current.left;	//next node in left branch if key is less
			else if (cmp>0)
				current=current.right;	//next node in right branch if key is more
			else if (cmp==0)
			{
				splay(current);		//splay the node if found
				return current.getValue();	//return the value
			}
		}
		//if the tree is empty 
		if (last!=null)
		{
			splay(last);	//splay the key closest to the given key
			return null;	
		}else	// if key was not found
		{
			return null;
		}
	}
	/**
	 * Remove function. removes a given key's node from the tree
	 * @param key
	 */
	public void remove(String key)
	{		
		boolean found=false;
		//placeholder nodes
		Node<T> current=root;
		Node<T> last=null;
		//stores compareTo values
		int cmp=0;
		//search for key
		while(current!=null)
		{
			//compare keys with the current node
			cmp=key.compareTo(current.getKey());
			if(cmp<0){   
				last=current;
				current=current.left;
			}
			else if (cmp>0){   
				last=current;
				current=current.right;
			}
			else {//cmp must be 0
				splay(current); //move to root
				found=true;
				break;
			}			
		}
		if (found)
		{
			//current node holds the key of the value to be deleted
			//if current node's both child are non empty
			if((current.left!=null && current.right!=null)) 
			{
				last= current.left;	//store current left child
				//keep getting the right child since the right most stores a key closest 
				//to deleted key
				while(last.right!=null) //while there is still right branch
					last=last.right;	
				//connect deleted key's right branch with the right most of the 
				// deleted key's left branch
				last.right=current.right;
				// save last as the deleted key's right branch parent
				current.right.parent=last;
				current.left.parent=null;
				root=current.left;
				splay(last);	//splay the node
			}//if current node's right child is empty
			else if (current.left != null)
			{
				// save last as the deleted key's left branch parent
				current.left.parent=null;
				root=current.left;
			}//if current node's left child is empty
			else if (current.right!=null)
			{
				// save last as the deleted key's right branch parent
				current.right.parent=null;
				root=current.right;
			}
			else
			{
				root=null;		//current node is the only node in the map -root
			}
			//nullify the node's pointer to other nodes
			current.parent=null;
			current.left=null;
			current.right=null;
			entries--;	//adjust entries
		}
		else
			System.out.println("not found in remove");
	}
	/** returns true if the parameter node n is the root of the tree **/
	private boolean isRoot(Node<T> n)
	{
		return n.parent==null;
	}
	/** returns true if map is empty **/
	public boolean isEmpty()
	{
		return (root==null)&&(entries==0);
	}
	/**
	 * returns number of nodes in the tree
	 * @return
	 */
	public int numberOfNodes()
	{
		return entries;
	}
	/** resets the tree **/
	public void dumpTree()
	{
		entries=0;
		root=null;
	}

	//methods for debugging
	// Prints the tree in ascending order
	public void display()
	{
		System.out.println("\n entries "+entries+"\troot: "+root.getKey()+"\n");
		display(root);
	}
	private void display(Node<T> r)
	{
		if (r != null)
		{
			display(r.left);
			System.out.print("k: "+r.getKey()+"\tvalue: "+r.getValue()+"\n");
			display(r.right);
		}
	}


}
