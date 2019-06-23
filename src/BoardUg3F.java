public class BoardUg3F {
	int s = 10;
	int s1 = 5;
	int t = 1;
	int u = 1;
	int efi = 8;
	int efj = 2;
	private char[][] map = new char[s][s1];
	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}
	
	public BoardUg3F(Player p, Enemy ef, Item i1, Item i2, Item i3, Item i4, Item i5) {
		for(int i = 0; i < getMap().length; i++){
			for(int j = 0; j < getMap()[0].length; j++){
				if((i == 0 && j == 0) || (i == 0 && j == s1 - 1) || (i == s - 1 && j == 0) || (i == s - 1 && j == s1 - 1)){
					getMap()[i][j] = '+';
				}
				else if((i == 0 && j != 0 && j != s1 - 1) || (i == s - 1 && j != 0 && j != s1 - 1)){
					getMap()[i][j] = '－';
				}
				else if((i != 0 && i != s - 1 && j == 0) || (i != 0 && i != s - 1 && j == s1 - 1)){
					getMap()[i][j] = '|';
				}
				else if(i == t && j == u){
					getMap()[i][j] = p.getSuf();
				}
				else if(i == efi && j == efj){
					getMap()[i][j] = ef.getSuf();
				}
				else{
					getMap()[i][j] = '〇';
				}
			}
		}
	}
	
	public void printBoard(Player p, Item i1, Item i2, Item i3, Item i4, Item i5){
		System.out.println("地下３階");
		for(int i = 0; i < getMap().length; i++){
			for(int j = 0; j < getMap()[0].length; j++){
				System.out.print(getMap()[i][j]);
			}
			System.out.println();
		}
		System.out.println(p.getName() +" 体力" + p.getHp() + " 最大体力" + p.maxHp + " 攻撃力" + p.getAtk() + " 防御力" + p.getDef() + " 取得経験値" + p.getExp());
		System.out.println("装備 " + p.getSword().getName() + "攻撃力  " + p.getSword().getDamage() + " " +  p.getArmour().getName() + " 防御力 " +  p.getArmour().getDefence());
		System.out.println("持ち物  " + p.getBag1() + i1.getBi() + " " + p.getBag2() + i2.getBi() + " " + p.getBag3() + i3.getBi() + " " + p.getBag4() + i4.getBi() + " " +  p.getBag5() + i5.getBi());
		System.out.println("状態異常  " + p.getState().condition());
	}
	
	int coef = 0;
	public void finalbattle(Player p, Enemy ef, Item i1, Item i2, Item i3, Item i4, Item i5){
		if(((t == efi - 1 && u == efj) ||(t == efi && u == efj + 1) || (t == efi + 1 && u == efj) || (t == efi && u == efj- 1)) && coef == 0){
			this.printBoard(p, i1, i2, i3, i4, i5);
			System.out.println(ef.getName() + "「ギャッヴォー！」");
			System.out.println(ef.getName() + "が現れた！");
			System.out.println(ef.getName() +" 体力" + ef.getHp() + " 最大体力" + ef.maxHp  + " 攻撃力" + ef.getAtk() + " 防御力" + ef.getDef() + " 取得経験値" + ef.getExp());
			while(ef.getHp() > 0 && p.getHp() > 0){
				p.attack(ef, i1, i2, i3, i4);
				if(ef.getHp() > 0){
				ef.finalattackplus(p, i1, i2, i3, i4);
				}
			}
			if(ef.getHp() <= 0){
				System.out.println(ef.getName() + "は倒れた！");
				p.experience(ef);
				p.levelup(ef);
			}
		}
	}
	
	
	
	
	
	
	public void move(int k, Player p, Enemy ef, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg3F b3f){
		char c = '〇';
		char d = '私';
		if(k == 1){
			if(u != s1 - 2){
				getMap()[t][u] = c;
				getMap()[t][u + 1] = d;
				u = u + 1;
				this.finalbattle(p, ef, i1, i2, i3, i4, i5);
			}
		}
		if(k == 2){
			if(t != 1){
				getMap()[t][u] = c;
				getMap()[t - 1][u] = d;
				t = t - 1;
				this.finalbattle(p, ef, i1, i2, i3, i4, i5);
			}
		}
		if(k == 3){
			if(u != 1){
				getMap()[t][u] = c;
				getMap()[t][u - 1] = d;
				u = u - 1;
				this.finalbattle(p, ef, i1, i2, i3, i4, i5);
			}
		}
		if(k == 4){
			if(t != s - 2){
				getMap()[t][u] = c;
				getMap()[t + 1][u] = d;
				t = t + 1;
				this.finalbattle(p, ef, i1, i2, i3, i4, i5);
			}
		}
		if(k == 5){
			p.refresh2(i1, i2, i3, i4);
			p.action3(b3f, ef, p, i1, i2, i3, i4, i5);
			System.out.println(p.getName() +" 体力" + p.getHp() + " 最大体力" + p.maxHp + " 攻撃力" + p.getAtk() + " 防御力" + p.getDef() + " 取得経験値" + p.getExp());
			System.out.println("持ち物  " + p.getBag1() + i1.getBi() + " " + p.getBag2() + i2.getBi());
			System.out.println("状態異常  " + p.getState().condition());
		}
	}
}
