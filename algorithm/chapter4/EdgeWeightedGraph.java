public class EdgeWeightedGraph{
	private final int V;
	private int E;
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[V];
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Edge>();
		}
	}

	public int V(){
		return this.V;
	}
	public int E(){
		return this.E;
	}
	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public Iterable<Edge> edges(){
		Bag<Edge> b = new Bag<>();
		for(int i = 0; i < this.V; i++)
			for(Edge e : adj[i])
				if (e.other(v) > v) b.add(e);
		return b;
	}
}
