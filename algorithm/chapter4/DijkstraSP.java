public class DijkstraSP{
	private double[] distTo;
	private int[] edgeTo;
	private IndexMinPQ<Double> pq;
	public DijkstraSP(EdgeWeightedDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new int[G.V()];
		pq = new IndexMinPQ<>();
		pq.insert(s, 0.0);
		for(int i = 0; i < G.V(); i++)
			distTo[i] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		while(!pq.isEmpty())
			relax(G, pq.delMin());
	}
	private void relax(EdgeWeightedDigraph G, int v){
		for(DirectedEdge e: G.adj(v)){
			int w = e.to();
			if(distTo[w] > e.weight() + distTo[v]){
				distTo[w] = e.weight() + distTo[v];
				edgeTo[w] = v;
				if(pq.contains(w)) pq.change(w, distTo[w]);
				else				pq.insert(w, distTo[w]);
			}
		}
	}
}
