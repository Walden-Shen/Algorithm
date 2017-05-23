public class PrimMST{
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] isMarked;
	private IndexMinPQ<Double> pq;
	public PrimMST(EdgeWeightedGraph G){
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		isMarked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<>(G.V());
		distTo[0] = 0.0;
		pq.insert(0, 0.0);
		while(!pq.isEmpty())
			visit(G, pq.delMin());
	}
	private void visit(EdgeWeightedGraph G, int v){
		isMarked[v] = true;
		for(Edge e: G.adj(v)){
			int w = e.other(v);
			if(!isMarked[w]){
				if(e.weight() < distTo[w]){
					edgeTo[w] = e;
					distTo[w] = e.weight();
					if(pq.contains(w)) pq.change(w, distTo[w]);
					else				pq.insert(w, distTo[w]);
				}
			}
		}
	}
}

