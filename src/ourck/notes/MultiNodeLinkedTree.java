package ourck.notes;
/*-------------------------------------
 *	OURCK - 具有多个子节点的LinkedTree实现
 *	2018年4月20日 下午10:19:27
 *-------------------------------------
 */

import java.util.LinkedList;

class MultiNodeLinkedTree<T> { // imp Iterable?
	
	public class Node {
		private LinkedList<Node> childNodes;
		private T data;
		
		public Node() { data = null; }
		
		public Node(T res) { data = res; }
		
		public void attach(Node childnodes) { childNodes.add(childnodes); }
		
		public LinkedList<Node> getChildNodes() { return childNodes; }
		
		public void setData(T val) { data = val; }
		
		public T getData() { return data; } // TODO Erasure & NullPointerExp.
	}	
	
	private Node root = null;
	
	public void LinkedTree() { root = new Node(); }
	
	public Node getRoot() { return root; }

}