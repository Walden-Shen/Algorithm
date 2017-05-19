public class Graph{
	private final int V;
	private int E;
	private Bag<Integer> adj;

	public Graph(int V){
		this.V = V;
		this.E = 0;
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

	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		this.E++;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public static int degree(Graph G, int v){
		int degree = 0;
		for(int w : G.adj(v))
			degree++;
		return degree;
	}

	public static int maxDegree(Graph G){
		int max = 0;
		for(int v = 0; v < G.V(); v++)
			if(degree(G, V) > max)
				max = degree(G, V);
		return max;
	}
	
	public static double averageDegree(Graph G){
		return 2.0 * G.E() / G.V();
	}

	public static int numberOfSelfLoops(Graph G){
		int count = 0;
		for(int v = 0; v < G.V(); v++)
			for(int w: G.adj(v))
				if(v == w)
					count++;
		return count / 2;
	}
	public class depthFirstSearch{
		private boolean[] marked;
		private int[] edgeTo;
		private final int s;
		public depthFirstSearch(Graph G, int s){
			this.s = s;
			edgeTo = new int[G.V()];
			marked = new boolean[G.V()];
			dfs(G, s);
		}
		public dfs(Graph G, int s){
			marked[s] = True;
			for(int w: G.adj(s))
				if(!marked[w]){
					edgeTo[w] = s;
					dfs(G, w);
				}
		}
		public boolean hasPathTo(int v){
			return marked[v];
		}
		public Iterable<Integer> pathTo(int v){
			if(!hasPathTo(v)) return null;
			Stack<Integer> path = new Stack<Integer>();
			for(; v != this.s; v = pathTo[v])
				path.push(v);
			path.push(s);
			return path;
		}
}
