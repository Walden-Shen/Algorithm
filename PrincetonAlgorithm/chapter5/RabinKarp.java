public class RabinKarp{
	private int R;
	private long patHash;
	private int M;//pattern length
	private long Q; //modulus
	private long RM;//R^(M-1) % Q
	private long hash(String key, int M){
		long h = 0; 
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % Q;
		return h;
	}
	public RabinKarp(String pat){
		M = pat.length();
		R = 256;
		Q = longRandomPrime();
		RM = 1;
		for(int i = 1; i <= M - 1; i++)
			RM = (R * RM) % Q;
		patHash = hash(pat, M);
	}
	public int search(String txt){
		int N = txt.length();
		int txtHash = hash(txt, M);
		if(patHash == txtHash) return 0;
		for(int i = M; i < N; i++){
			txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
			txtHash = (txtHash * R + txt.charAt(i)) % Q;
			if(patHash == txtHash) return i - M + 1;
		}
		return N;
	}
}
