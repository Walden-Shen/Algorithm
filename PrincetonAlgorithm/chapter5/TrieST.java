import java.util.*;
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
	public Iterable<String> keys(){
		LinkedList<String> queue = new LinkedList<>();
		collect(root, "", queue);
		return queue;
	}
	private void collect(Node node, String prefix, LinkedList<String> queue){
		if(node == null) return;
		if(node.value != null) queue.offer(prefix);
		for(char c = 0; c < R; c++)
			collect(node.next[c], prefix + c, queue);
	}
	public Iterable<String> keyWithPrefix(String prefix){
		LinkedList<String> queue = new LinkedList<>();
		Node x = get(root, prefix, 0);
		collect(x, prefix, queue);
		return queue;
	}
	public String longestPrefixOf(String query){
		int length = search(root, query, 0, 0);
		return query.substring(0, length);
	}
	private int search(Node x, String query, int d, int length){
		if(x == null) return length;
		if(x.value != null) length = d;
		if(d == query.length()) return length;
		char c = query.charAt(d);
		return search(x.next[c], query, d + 1, length);
	}
}

