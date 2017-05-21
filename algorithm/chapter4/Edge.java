public class Edge{
	private int v;
	private int w;
	private double weight;

	public Edge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	private double weight(){
		return this.weight;
	}
	private int either(){
		return this.v;
	}
	private int other(int v){
		if(v == this.v)
			return w;
		else if(v == this.w)
			return this.v;
		else
			throw new RuntimeException("inconsistent edge");
	}
	private int compareTo(Edge that){
		if(this.weight() > that.weight())
			return 1;
		else if(this.weight() < that.weight())
			return -1;
		else
			return 0;
	}
}
