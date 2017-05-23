public class AcyclicSP{
	private DirectedEdge[] edgeTo;
	private double[] distTo;

	public AcyclicSP(EdgeWeightedGraph G, int s){
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		TopologicalSort top = new TopologicalSort(G);
		for(int v: top.order())
			relax(G, v);
	}

	private void relax(EdgeWeightedGraph G, int v){
		for(DirectedEdge e: G.adj(v)){
			int w = e.to();
			if(distTo[w] > e.weight() + distTo[v]){
				distTo[w] = e.weight() + distTo[v];
				edgeTo[w] = e;
			}
		}
	}
}
