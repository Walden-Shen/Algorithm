public class TrieST<Value>{
	private static class Node{
		private Object value;
		private Node[] next = new Node[R];
	}
	private static final int R = 256;
	private Node root = new Node();

	public void put(String key, Value val){
		root = put(root, key, val, 0);
	}
	public Node put(Node x, String key, Value val, int d){
		if(x = null) x = new Node();
		if(d == key.length()) {x.val = val; return x;}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
}
