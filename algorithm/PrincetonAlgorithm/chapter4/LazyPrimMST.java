import java.util.*;
public class LazyPrimMST{
	private boolean[] isMarked;
	private LinkedList<Edge> mst;
	private MinPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G){
		isMarked = new boolean[G.V()];
		mst = new LinkedList<>();
		pq = new MinPQ<>();
		visit(G, 0);
		while(!pq.isEmpty()){
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(isMarked[v] && isMarked[w]) continue;
			mst.offer(e);
			if(isMarked[v]) visit(G, w);
			if(isMarked[w]) visit(G, v);
		}
	}

	private void visit(EdgeWeightedGraph G, int v){
		isMarked[v] = true;
		for(Edge e : G.adj(v))
			if(!isMarked[e.other(v)])
				pq.insert(e);
	}
	public Iterable<Edge> edges(){
		return mst;
	}
}
