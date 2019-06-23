public class Sword {
	private String name;
	private int damage;
	Sword(String name, int damage){
		this.setName(name);
		this.setDamage(damage);
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public int getDamage(){
		return this.damage;
	}
}
