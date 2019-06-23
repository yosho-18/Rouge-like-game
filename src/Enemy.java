public class Enemy extends Character{
	Enemy(String name, char suf, int hp, int atk, int def, int exp, int maxHp){
		super(name, suf, hp, atk, def, exp, maxHp);
	}
	
	public void attack(Player p){
		System.out.println(this.getName() + "の攻撃！");
		int r = new java.util.Random().nextInt(4) + 1;
		if(this.getAtk() + r - 2 - p.getDef()/2 - p.getArmour().getDefence()/2 > 0){
			if(p.getHp() - (this.getAtk() + r - 2 - p.getDef()/2 - p.getArmour().getDefence()/2) > 0){
				System.out.println(this.getAtk() + r - 2 - p.getDef()/2 - p.getArmour().getDefence()/2 + "ポイントのダメージを受けた！");
				p.addHp(-this.getAtk() - r + 2 + p.getDef()/2 + p.getArmour().getDefence()/2);
			}
			else{
				System.out.println(p.getHp() + "ポイントのダメージを受けた！");
				p.addHp(-p.getHp());
			}
		}
		else{
			System.out.println(1 + "ポイントのダメージを受けた！");
			p.addHp(- 1);
		}
		if(p.getState().getIll() == 1 || p.getState().getIll() == 3){
			int po = 3;
			p.addHp(-po);
			System.out.println(p.getName() + "はどくで" + po + "ポイントのダメージを受けた！");
		}
		System.out.println(p.getName() + "の体力 " + p.getHp() + " "  + "状態異常  " + p.getState().condition() + "  " + this.getName() + "の体力 " + this.getHp());
	}
	public void attackplus(Player p){
		System.out.println(this.getName() + "の攻撃！");
		int r = new java.util.Random().nextInt(6) + 1;
		if(this.getAtk() + r - 3 - p.getDef()/2 - p.getArmour().getDefence()/2 > 0){
			if(p.getHp() - (this.getAtk() + r - 3 - p.getDef()/2 - p.getArmour().getDefence()/2) > 0){
				System.out.println(this.getAtk() + r - 3 - p.getDef()/2 - p.getArmour().getDefence()/2 + "ポイントのダメージを受けた！");
				p.addHp(-this.getAtk() - r + 3 + p.getDef()/2 + p.getArmour().getDefence()/2);
			}
			else{
				System.out.println(p.getHp() + "ポイントのダメージを受けた！");
				p.addHp(-p.getHp());
			}
		}
		else{
			System.out.println(1 + "ポイントのダメージを受けた！");
			p.addHp(- 1);
		}
		if(p.getState().getIll() == 0){
			int para = new java.util.Random().nextInt(3) + 1;
			if(para == 1){
				p.getState().setIll(2);
				System.out.println(p.getName() + "は まひ になった！");
			}
		}
		if(p.getState().getIll() == 1){
			int para = new java.util.Random().nextInt(3) + 1;
			if(para == 1){
				p.getState().setIll(3);
				System.out.println(p.getName() + "は どく、まひ になった！");
			}
		}
		if(p.getState().getIll() == 1 || p.getState().getIll() == 3){
			int po = 3;
			p.addHp(-po);
			System.out.println(p.getName() + "はどくで" + po + "ポイントのダメージを受けた！");
		}
		System.out.println(p.getName() + "の体力 " + p.getHp() + "  "  + "状態異常  " + p.getState().condition() + "  " + this.getName() + "の体力 " + this.getHp());
	}
	public void finalattackplus(Player p, Item i1, Item i2, Item i3, Item i4){
		int skill = new java.util.Random().nextInt(4) + 1;
		if(skill == 1){
			System.out.println(this.getName() + "のギガインパクト！");
			int r = new java.util.Random().nextInt(10) + 1;
			if(this.getAtk() * 2 + r - p.getDef()/4 - p.getArmour().getDefence()/4 > 0){
				if(p.getHp() - (this.getAtk() * 2 + r - p.getDef()/4 - p.getArmour().getDefence()/4) > 0){
					System.out.println(this.getAtk() * 2 + r - p.getDef()/4 - p.getArmour().getDefence()/4 + "ポイントのダメージを受けた！");
					p.addHp(-(this.getAtk() * 2 + r - p.getDef()/4 - p.getArmour().getDefence()/4));
				}
				else{
					System.out.println(p.getHp() + "ポイントのダメージを受けた！");
					p.addHp(-p.getHp());
				}
			}
			else{
				System.out.println(1 + "ポイントのダメージを受けた！");
				p.addHp(- 1);
			}
			if(p.getState().getIll() == 1 || p.getState().getIll() == 3){
				int po = 3;
				p.addHp(-po);
				System.out.println(p.getName() + "はどくで" + po + "ポイントのダメージを受けた！");
			}
			System.out.println(p.getName() + "の体力 " + p.getHp() + "  "  + "状態異常  " + p.getState().condition() + "  " + this.getName() + "の体力 " + this.getHp());
			if(p.getHp() > 0 && this.getHp() > 0){
				p.attack(this, i1, i2, i3, i4);
				System.out.println(this.getName() + "はギガインパクトの反動で攻撃できない！");
			}
		}
		if(skill == 2){
			System.out.println(this.getName() + "のダストシュート！");
			int r = new java.util.Random().nextInt(5) + 1;
			if(this.getAtk() + r - p.getDef()/2 - p.getArmour().getDefence()/2 > 0){
				if(p.getHp() - (this.getAtk() + r - p.getDef()/2 - p.getArmour().getDefence()/2) > 0){
					System.out.println(this.getAtk() + r - p.getDef()/2 - p.getArmour().getDefence()/2 + "ポイントのダメージを受けた！");
					p.addHp(-this.getAtk() - r + p.getDef()/2 + p.getArmour().getDefence()/2);
				}
				else{
					System.out.println(p.getHp() + "ポイントのダメージを受けた！");
					p.addHp(-p.getHp());
				}
			}
			else{
				System.out.println(1 + "ポイントのダメージを受けた！");
				p.addHp(- 1);
			}
			if(p.getState().getIll() == 0){
				int pois = new java.util.Random().nextInt(3) + 1;
				if(pois == 1){
					p.getState().setIll(1);
					System.out.println(p.getName() + "は どく になった！");
				}
			}
			if(p.getState().getIll() == 2){
				int pois = new java.util.Random().nextInt(3) + 1;
				if(pois == 1){
					p.getState().setIll(3);
					System.out.println(p.getName() + "は どく、まひ になった！");
				}
			}
		}
		if(skill == 3){
			System.out.println(this.getName() + "のかみなり！");
			int prob = new java.util.Random().nextInt(4) + 1;
			if(prob == 1){
				System.out.println("しかし" + this.getName() + "の攻撃ははずれた！");
			}
			else{
				int r = new java.util.Random().nextInt(10) + 1;
				if((this.getAtk() * 3) / 2 + r  - p.getDef()/2 - p.getArmour().getDefence()/2 > 0){
					if(p.getHp() - ((this.getAtk() * 3) / 2 + r - p.getDef()/2 - p.getArmour().getDefence()/2) > 0){
						System.out.println((this.getAtk() * 3) / 2 + r - p.getDef()/2 - p.getArmour().getDefence()/2 + "ポイントのダメージを受けた！");
						p.addHp(- ((this.getAtk() * 3) / 2 + r - p.getDef()/2 - p.getArmour().getDefence()/2));
					}
					else{
						System.out.println(p.getHp() + "ポイントのダメージを受けた！");
						p.addHp(-p.getHp());
					}
				}
				else{
					System.out.println(1 + "ポイントのダメージを受けた！");
					p.addHp(- 1);
				}
				if(p.getState().getIll() == 0){
					int para = new java.util.Random().nextInt(3) + 1;
					if(para == 1){
						p.getState().setIll(2);
						System.out.println(p.getName() + "は まひ になった！");
					}
				}
				if(p.getState().getIll() == 1){
					int para = new java.util.Random().nextInt(3) + 1;
					if(para == 1){
						p.getState().setIll(3);
						System.out.println(p.getName() + "は どく、まひ になった！");
					}
				}
			}
		}
		if(skill == 4){
			System.out.println(this.getName() + "のじこさいせい！");
			if(this.maxHp / 5 + this.getHp() > this.maxHp){
				System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + "体力を回復した！");
				this.setHp(this.maxHp);
			}
			else{
				System.out.println(this.getName() + "は " + (this.maxHp / 5) + "体力を回復した！");
				this.setHp(this.maxHp / 5 + this.getHp());
			}
		}
		if(p.getState().getIll() == 1 || p.getState().getIll() == 3){
			int po = 3;
			p.addHp(-po);
			System.out.println(p.getName() + "はどくで" + po + "ポイントのダメージを受けた！");
		}
		System.out.println(p.getName() + "の体力 " + p.getHp() + "  "  + "状態異常  " + p.getState().condition() + "  " + this.getName() + "の体力 " + this.getHp());
	}
}
