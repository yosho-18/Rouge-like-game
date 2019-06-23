public class Item {
	private String name;
	private char suf;
	private int rec;
	private int bi;
	Item(String name, char suf, int rec, int bi){
		this.name = name;
		this.suf = suf;
		this.rec = rec;
		this.bi = bi;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(){
		this.name = name;
	}
	public char getSuf(){
		return this.suf;
	}
	public void setSuf(){
		this.suf = suf;
	}
	public int getRec(){
		return this.rec;
	}
	public void setRec(){
		this.rec = rec;
	}
	public int getBi(){
		return this.bi;
	}
	public void setBi(int bi){
		this.bi = bi;
	}
}
