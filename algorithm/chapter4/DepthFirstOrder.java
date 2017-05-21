import java.util.*;
public class DepthFirstOrder{
	Stack<Integer> reversePost;
	LinkedList<Integer> pre;
	LinkedList<Integer> post;
	boolean[] isMarked;

	public DepthFirstOrder(Digraph G){
		reversePost = new Stack<Integer>();
		pre = new LinkedList<Integer>();
		post = new LinkedList<Integer>();
		isMarked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			if(!isMarked[v])
				dfs(G, v);
	}

	public void dfs(Digraph G, int v){
		isMarked[v] = true;
		pre.offer(v);
		for(int i : G.adj(v))
			if(!isMarked[i])
				dfs(G, i);
		post.offer(v);
		reversePost.push(v);
	}

	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}
}

