public class JavaString{
	private char[] value;
	private int offset;
	private int length;
	private int hash;

	public int length(){
		return length;
	}

	public char charAt(int i){
		return value[i + offset];
	}

	public JavaString(int offset, int length, int value){
		this.offset = offset;
		this.length = length;
		this.value = value;
	}

	public JavaString substring(int from, int to){
		return new JavaString(this.offset + from, to - from, value);
	}
}
