public class UF{
	private int[] id;
	private int[] sz;
	private int count;

	public UF(int n){
		count = n;
		id = new int[n];
		sz = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int count(){
		return count;
	}

	public boolean connected(int p, int q){
		return quickFind(p) == quickFind(q);
	}

	public void slowUnion(int p, int q){
		int pID = quickFind(p);
		int qID = quickFind(q);
		if(pID != qID){
			for(int i = 0; i < id.length; i++){
				if (id[i] == pID) id[i] = qID;
			}
			count--;
		}
	}
	
	public int quickFind(int p){
		return id[p];
	}

	public int root(int p){
		while(p != id[p]){
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	public void quickUnion(int p, int q){
		int i = root(p);
		int j = root(q);
		if(i != j){
			if(sz[i] < sz[j]){id[i] = j; sz[j] += sz[i];}
			else {id[j] = i; sz[i] += sz[j]}
		}
		count--;
	}
