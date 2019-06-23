public class Armour {
	private String name;
	private int defence;
	Armour(String name, int defence){
		this.setName(name);
		this.setDefence(defence);
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setDefence(int defence){
		this.defence = defence;
	}
	public int getDefence(){
		return this.defence;
	}
}

