public class TST<Value>{
	private Node root;
	private class Node{
		private Value val;
		private char c;
		private Node left, mid, right;
	}

	public void put(String key, Value val){
		root = put(root, key, val, 0);
	}
	private Node put(Node node, String key, Value val, int d){
		char a = key.charAt(d);
		if(node == null) { node = new Node(); node.c = a;}
		if(a < node.c) node.left = put(node.left, key, val, d);
		else if(a > node.c) node.right = put(node.right, key, val, d);
		else if(d < key.length() - 1) node.mid = put(node.mid, key, val, d + 1);
		else node.val = val;
		return node;
	}
	public boolean contains(String key){
		return get(key) != null;
	}
	public Value get(String key){
		Node x = get(root, key, 0);
		if(x == null) return null;
		return x.val;
	}
	private Node get(Node x, String key, int d){
		if(x == null) return null;
		char c = key.charAt(d);
		if (c < x.c) return get(x.left, key, d);
		else if(c > x.c) return get(x.right, key, d);
		else if (d < key.length() - 1) return get(x.mid, key, d + 1);
		else return x;
	}
}
