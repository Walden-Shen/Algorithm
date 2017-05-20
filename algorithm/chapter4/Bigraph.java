public class Bigraph extends Graph{
	public void addEdge(int v, int w){
		adj(v).add(w);
		this.E++;
	}

	public Bigraph reverse(){
		Bigraph bigraph = new Bigraph(this.V());
		for(int i = 0; i < this.V(); i++)
			for(int j : this.adj(i).iterator())
				bigraph.addEdge(this.adj(i)[j], i);
		return bigraph;
	}
	
	public class KosarajuSharirSCC{
		private boolean marked[];
		private int[] id;
		private int count;
		public KosarajuSharirSCC(Digraph G){
			marked = new boolean[G.V()];
			id = new int[G.V()];
			DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
			for(int v: dfs.reversePost()){
				if(!marked[v]){
					dfs(G, v);
					count++;
				}
			}
		}
		private void dfs(Digraph G, int v){
			marked[v] = true;
			id[v] = count;
			for(int w: G.adj(v))
				if(!marked[w])
					dfs(G, w);
		}
		public boolean stronglyConnected(int v, int w){
			return id[v] == id[w];
		}
	}
}
