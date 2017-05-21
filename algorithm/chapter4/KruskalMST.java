public class KruscalMST{
	private LinkedList<Edge> mst;
	public KruscalMST(EdgeWeightedGraph G){
		mst = new LinkedList<Edge>();
		MinPQ<Edge> pq = new MinPQ<>();
		UF uf = new UF(G.V());
		for(Edge e : G.edges())
			pq.insert(e);
		while(!pq.isEmpty() && mst.size() < G.V() - 1){
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(!uf.isConnected(v, w)){
				uf.union(v, w);
				mst.offer(e);
			}
		}
	}
	public Iterable<Edge> edges(){
		return mst;
	}
	public double weight()
}


