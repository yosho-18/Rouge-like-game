public abstract class Character {
	private String name;
	private char suf;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	int maxHp;
	Character(String name, char suf, int hp, int atk, int def, int exp, int maxHp){
		this.name = name;
		this.suf = suf;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
		this.maxHp = hp;
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
	public int getHp(){
		return this.hp;
	}
	public void setHp(int hp){
		if(hp < 0){
			this.hp = 0;
		}
		else{
			this.hp = hp;
		}
	}
	public int getAtk(){
		return this.atk;
	}
	public void setAtk(int atk){
		this.atk = atk;
	}
	public int getDef(){
		return this.def;
	}
	public void setDef(int def){
		this.def = def;
	}
	public int getExp(){
		return this.exp;
	}
	public void setExp(int exp){
		this.exp = exp;
	}
	public void addHp(int diff){
		if(diff < 0){
			this.setHp(this.getHp() + diff);
		}
		else{
			this.setHp(this.getHp() - 1);
		}
	}
}
