public class TopologicalSort{
	private Iterable<Integer> order;
	public TopologicalSort(Digraph G){
		DirectedCycle dc = new DirectedCycle(G);
		if(!dc.hasCycle()){
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
		}
	}
	public Iterable<Integer> order(){
		return order;
	}
	public boolean isDAG(){
		return order != null;
	}
}
