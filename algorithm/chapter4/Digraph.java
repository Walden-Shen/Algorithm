public class Digraph{
	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
	}

	public int V(){
		return this.V;
	}
	public int E(){
		return this.E;
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public void addEdge(int v, int w){
		adj[v].add(w);
		this.E++;
	}

	public Digraph reverse(){
		Digraph digraph = new Digraph(this.V());
		for(int i = 0; i < this.V(); i++)
			for(int j : this.adj(i))
				digraph.addEdge(j, i);
		return digraph;
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
