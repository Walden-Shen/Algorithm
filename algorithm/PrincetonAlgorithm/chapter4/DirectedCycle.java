import java.util.*;
public class DirectedCycle{
	private boolean[] inStack;
	private int[] edgeTo;
	private boolean[] isMarked;
	private Stack<Integer> stack;

	public DirectedCycle(Digraph G){
		inStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int i = 0; i < G.V(); i++)
			if(!isMarked[i]){
				edgeTo[i] = i;
				dfs(G, i);
			}
	}

	private void dfs(Digraph G, int v){
		isMarked[v] = true;
		inStack[v] = true;
		for(int i : G.adj(v)){
			if(this.hasCycle()){
				return;
			}
			else if(!isMarked[i]){
				edgeTo[i] = v;
				dfs(G, i);
			}else if(inStack[i]){
				stack = new Stack<Integer>();
				for(int j = v ; j != i; j = edgeTo[j])
					stack.push(j);
				stack.push(i);
				stack.push(v);
			}
		}
		inStack[v] = false;
	}

	public boolean hasCycle(){
		return this.stack != null;
	}

	public Iterable<Integer> cycle(){
		return stack;
	}
}
