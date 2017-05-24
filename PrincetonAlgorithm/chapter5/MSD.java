public class MSD{
	private static String[] aux;
	private static final int R = 256;
	public static void main(String[] args){
		String[] a = new String[3];
		a[0] = "asfa";
		a[1] = "zzsd";
		a[2] = "yr";
		sort(a);
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
	}

	public static int charAt(String s, int i){
		if(i < s.length()) return s.charAt(i);
		return -1;
	}

	public static void sort(String[] a){
		aux = new String[a.length];
		sort(a, aux, 0, a.length, 0);
	}

	public static void sort(String[] a, String[] aux, int lo, int hi, int d){
		if(lo >= hi) return;
		int[] count = new int[R + 2];
		for(int i = lo; i <= hi; i++)
			count[charAt(a[i], d) + 2]++;
		for(int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];
		for(int i = lo; i <= hi; i++)
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		for(int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];
		
		for(int r = 0; r < R; r++)
			sort(a, aux, lo + count[r], lo + count[r + 1] - 1, d + 1);
	}
}



