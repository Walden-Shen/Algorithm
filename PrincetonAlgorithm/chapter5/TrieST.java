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
	private Node put(Node x, String key, Value val, int d){
		if(x == null) x = new Node();
		if(d == key.length()) {x.value = val; return x;}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	public boolean contain(String key){
		return get(key) != null;
	}
	public Value get(String key){
		Node x = get(root, key, 0);
		if(x == null) return null;
		return (Value)x.value;
	}
	private Node get(Node node, String key, int d){
		if(node == null) return null;
		if(d == key.length() && node.value != null) return node;
		char c = key.charAt(d);
		return get(node.next[c], key, d + 1);
	}
	public void delete(String key){
		delete(root, key, 0);
	}
	private boolean delete(Node node, String key, int d){
		if(node == null) return false;
		if(d == key.length() && node.value != null) return true;
		char c = key.charAt(d);
		if(delete(node.next[c], key, d + 1) && node.next[c].value != null){
			int once = 0;
			for(int i = 0; i < R; i++)
				if(node.next[c].next[i] != null)
					once = 1;
			if(once == 0){
				node.next[c] = null;
				return true;
			}
		}
		return false;
	}
}
