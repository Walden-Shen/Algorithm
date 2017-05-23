public class EdgeWeightedDigraph{
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<DirectedEdge>();
	}

	public int V(){
		return this.V;
	}
	public int E(){
		return this.E;
	}

	public void addEdge(DirectedEdge e){
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v){
		return this.adj[v];
	}
	public Iterable<DirectedEdge> edges(){
		Bag<DirectedEdge> bag = new Bag<>();
		for(int v = 0; v < this.V; v++)
			for(DirectedEdge e: adj[v])
				bag.add(e);
		return bag;
	}
}
