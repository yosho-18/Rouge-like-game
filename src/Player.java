public class Player extends Character{
	private String bag1;
	private String bag2;
	private String bag3;
	private String bag4;
	private String bag5;
	private Sword sword;
	private Armour armour;
	private State state;
	Player(String name, char suf, int hp, int atk, int def, int exp, int maxHp, String bag1, String bag2, String bag3, String bag4, String bag5){
		super(name, suf, hp, atk, def, exp, maxHp);
		this.maxHp = hp;
		this.bag1 = bag1;
		this.bag2 = bag2;
		this.bag3 = bag3;
		this.bag4 = bag4;
		this.bag5 = bag5;
	}

	public String getBag1(){
		return this.bag1;
	}
	public void setBag1(){
		this.bag1 = bag1;
	}
	public String getBag2(){
		return this.bag2;
	}
	public void setBag2(){
		this.bag2 = bag2;
	}
	public String getBag3(){
		return this.bag3;
	}
	public void setBag3(){
		this.bag3 = bag3;
	}
	public String getBag4(){
		return this.bag4;
	}
	public void setBag4(){
		this.bag4 = bag4;
	}
	public String getBag5(){
		return this.bag5;
	}
	public void setBag5(){
		this.bag5 = bag5;
	}
	public void setSword(Sword sword){
		this.sword = sword;
	}
	public Sword getSword(){
		return this.sword;
	}
	public void setArmour(Armour armour){
		this.armour = armour;
	}
	public Armour getArmour(){
		return this.armour;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

	public void action(Board b, Enemy e, Player p, Enemy e1, Enemy e2, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg1F b1f){
		if(p.getHp() > 0 && ((e1.getHp() > 0) || (e2.getHp() > 0) ||  p.getSuf() != b.getMap()[b.s - 2][b.s - 2])){
			System.out.println(this.getName() + "さん 進む方向またはバッグを数字で入力してください。");
			System.out.println("１ → ２ ↑ ３ ← ４ ↓ ５ バッグ");
			int i= new java.util.Scanner(System.in).nextInt();
			b.move(i, e, p, e1, e2, i1, i2, i3, i4, i5, b1f);
		}
	}
	public void action1(BoardUg1F b1f, Enemy e, Player p, Enemy e3, Enemy e4, Item i1, Item i2, Item i3, Item i4, Item i5) {
		if(p.getHp() > 0 && ((e3.getHp() > 0) || (e4.getHp() > 0) ||  p.getSuf() != b1f.getMap()[b1f.s - 2][b1f.s - 2])){
			System.out.println(this.getName() + "さん 進む方向またはバッグを数字で入力してください。");
			System.out.println("１ → ２ ↑ ３ ← ４ ↓ ５ バッグ");
			int i= new java.util.Scanner(System.in).nextInt();
			b1f.move(i, e, p, e3, e4, i1, i2, i3, i4, i5, b1f);
		}
	}
	public void action2(BoardUg2F b2f, Enemy note ,Player p, Item i1, Item i2, Item i3, Item i4, Item i5) {
		if(p.getHp() > 0 && !(p.getSuf() == b2f.getMap()[b2f.s - 2][b2f.s1 - 2] && b2f.conote == 1)){
			System.out.println(this.getName() + "さん 進む方向またはバッグを数字で入力してください。");
			System.out.println("１ → ２ ↑ ３ ← ４ ↓ ５ バッグ");
			int i= new java.util.Scanner(System.in).nextInt();
			b2f.move(i, p, note, i1, i2, i3, i4, i5, b2f);
		}
	}
	public void action3(BoardUg3F b3f, Enemy ef ,Player p, Item i1, Item i2, Item i3, Item i4, Item i5) {
		if(p.getHp() > 0 && ef.getHp() > 0){
			System.out.println(this.getName() + "さん 進む方向またはバッグを数字で入力してください。");
			System.out.println("１ → ２ ↑ ３ ← ４ ↓ ５ バッグ");
			int i= new java.util.Scanner(System.in).nextInt();
			b3f.move(i, p, ef, i1, i2, i3, i4, i5, b3f);
		}
	}
	public void attack(Enemy e, Item i1, Item i2, Item i3, Item i4){
		System.out.println(this.getName() + "はどうする？");
		System.out.println("１ 戦う  ２ バッグ");
		int i= new java.util.Scanner(System.in).nextInt();
		int rdm = new java.util.Random().nextInt(4) + 1;
		if(i == 1){
			if((this.state.getIll() == 2 && rdm == 1)|| (this.state.getIll() == 3 && rdm == 1)){
				System.out.println(this.getName() + "はまひで攻撃できなかった！");
			}
			else{
				System.out.println(this.getName() + "の攻撃！");
				int r = new java.util.Random().nextInt(11);
				if(this.getAtk() + this.sword.getDamage()/2 - e.getDef()/2 + r - 5 > 0){
					if(e.getHp() - (this.getAtk() + this.sword.getDamage()/2 - e.getDef()/2 + r - 5) > 0){
						System.out.println(this.getAtk() + this.sword.getDamage()/2 - e.getDef()/2 + r - 5 + "ポイントのダメージを与えた！");
						e.addHp(-this.getAtk() - this.sword.getDamage()/2 +e.getDef()/2 - r + 5);
					}
					else{
						System.out.println(e.getHp() + "ポイントのダメージを与えた！");
						e.addHp(-e.getHp());
					}
				}
				else{
					System.out.println(1 + "ポイントのダメージを与えた！");
					e.addHp(- 1);
				}
			}
			System.out.println(this.getName() + "の体力 " + this.getHp() + " " + "状態異常  " + this.state.condition() + "  " + e.getName() + "の体力 " + e.getHp());
		}
		else if(i == 2){
			this.refresh3(e, i1, i2, i3, i4);
		}
		else{
			this.attack(e, i1, i2, i3, i4);
		}
	}

	public void experience(Enemy e){
		this.setExp(this.getExp() + e.getExp());
		System.out.println(this.getName() + "は経験値を" + e.getExp() + "手に入れた！");
	}

	public void levelup(Enemy e){
		int ah = 3;
		int aa = 2;
		int ad = 1;
		if(this.getExp() >= 10 && this.getExp() - e.getExp() < 10){
			this.maxHp = this.maxHp + ah;
			this.setHp(this.getHp() + ah);
			this.setAtk(this.getAtk() + aa);
			this.setDef(this.getDef() + ad);
			System.out.println("体力" + "+" + ah + " 攻撃力" + "+" + aa + " 防御力" + "+" + ad);
		}
		if(this.getExp() >= 40 && this.getExp() - e.getExp() < 40){
			this.maxHp = this.maxHp + ah + 2;
			this.setHp(this.getHp() + ah + 2);
			this.setAtk(this.getAtk() + aa + 2);
			this.setDef(this.getDef() + ad + 1);
			System.out.println("体力" + "+" + (ah + 2) + " 攻撃力" + "+" + (aa + 2) + " 防御力" + "+" + (ad + 1));
		}
		if(this.getExp() >= 90 && this.getExp() - e.getExp() < 90){
			this.maxHp = this.maxHp + ah + 2;
			this.setHp(this.getHp() + ah + 2);
			this.setAtk(this.getAtk() + aa + 2);
			this.setDef(this.getDef() + ad + 2);
			System.out.println("体力" + "+" + (ah + 2) + " 攻撃力" + "+" + (aa + 2) + " 防御力" + "+" + (ad + 2));
		}
		if(this.getExp() >= 160 && this.getExp() - e.getExp() < 160){
			this.maxHp = this.maxHp + ah + 3;
			this.setHp(this.getHp() + ah + 3);
			this.setAtk(this.getAtk() + aa + 2);
			this.setDef(this.getDef() + ad + 2);
			System.out.println("体力" + "+" + (ah + 3) + " 攻撃力" + "+" + (aa + 2) + " 防御力" + "+" + (ad + 2));
		}
		if(this.getExp() >= 220 && this.getExp() - e.getExp() < 220){
			this.maxHp = this.maxHp + ah + 3;
			this.setHp(this.getHp() + ah + 3);
			this.setAtk(this.getAtk() + aa + 3);
			this.setDef(this.getDef() + ad + 2);
			System.out.println("体力" + "+" + (ah + 3) + " 攻撃力" + "+" + (aa + 3) + " 防御力" + "+" + (ad + 2));
		}
		if(this.getExp() >= 300 && this.getExp() - e.getExp() < 300){
			this.maxHp = this.maxHp + ah + 3;
			this.setHp(this.getHp() + ah + 3);
			this.setAtk(this.getAtk() + aa + 3);
			this.setDef(this.getDef() + ad + 3);
			System.out.println("体力" + "+" + (ah + 3) + " 攻撃力" + "+" + (aa + 3) + " 防御力" + "+" + (ad + 3));
		}
	}

	public void refresh1(Enemy e, Item i1, Item i2, Item i3, Item i4, Item i5, Enemy e3, Enemy e4, BoardUg1F b1f){
		System.out.println("使う道具を数字で入力してください。");
		System.out.println("１ " + this.getBag1() + i1.getBi() + " ２ " + this.getBag2() + i2.getBi() + " ３ " + this.getBag3() + i3.getBi() + " ４ " + this.getBag4() + i4.getBi() + " ５ " + this.getBag5() + i5.getBi() + " ６  もどる");
		int i= new java.util.Scanner(System.in).nextInt();
		if(i == 1){
			if(i1.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i1.getName() + " は使えません。");
				}
				else if(this.getHp() + i1.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i1.setBi(i1.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " + (i1.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i1.getRec());
					i1.setBi(i1.getBi() - 1);
				}
			}
			else if(i1.getBi() == 0){
				System.out.println(i1.getName() + "はありません。");
			}
		}
		else if(i == 2){
			if(i2.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i2.getName() + " は使えません。");
				}
				else if(this.getHp() + i2.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i2.setBi(i2.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " + (i2.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i2.getRec());
					i2.setBi(i2.getBi() - 1);
				}
			}
			else if(i2.getBi() == 0){
				System.out.println(i2.getName() + "はありません。");
			}
		}
		else if(i == 3){
			if(i3.getBi() != 0){
				if(this.getState().getIll() == 1){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(0);
					i3.setBi(i3.getBi() - 1);
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(2);
					i3.setBi(i3.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " +  " どく状態ではありません。");
					System.out.println(this.getName() + "に " + i3.getName() + " は使えません。");
				}
			}
			else if(i3.getBi() == 0){
				System.out.println(i3.getName() + "はありません。");
			}
		}
		else if(i == 4){
			if(i4.getBi() != 0){
				if(this.getState().getIll() == 2){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(0);
					i4.setBi(i4.getBi() - 1);
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(1);
					i4.setBi(i4.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " +  " まひ状態ではありません。");
					System.out.println(this.getName() + "に " + i4.getName() + " は使えません。");
				}
			}
			else if(i4.getBi() == 0){
				System.out.println(i4.getName() + "はありません。");
			}
		}
		else if(i == 5){
			if(i5.getBi() != 0){
				System.out.println("レーザーを撃つ方向を数字で入力してください。");
				System.out.println("１ → ２ ↑ ３ ← ４ ↓");
				int j= new java.util.Scanner(System.in).nextInt();
				if(j == 1){
					if(b1f.t == b1f.v && b1f.u < b1f.w && e3.getHp() != 0){
						System.out.println(e3.getName() + "に" + e3.getHp()/3 + "ポイントのダメージを与えた！");
						e3.addHp(-e3.getHp()/3);
					}
					if(b1f.t == b1f.x && b1f.u < b1f.y && e4.getHp() != 0){
						System.out.println(e4.getName() + "に" + e4.getHp()/3 + "ポイントのダメージを与えた！");
						e4.addHp(-e4.getHp()/3);
					}
					if(!((b1f.t == b1f.v && b1f.u < b1f.w && e3.getHp() != 0)||(b1f.t == b1f.x && b1f.u < b1f.y && e4.getHp() != 0))){
						System.out.println("敵がいないのでダメージを与えられなかった！");
					}
				}
				else if(j == 2){
					if(b1f.t > b1f.v && b1f.u == b1f.w && e3.getHp() != 0){
						System.out.println(e3.getName() + "に" + e3.getHp()/3 + "ポイントのダメージを与えた！");
						e3.addHp(-e3.getHp()/3);
					}
					if(b1f.t > b1f.x && b1f.u == b1f.y && e4.getHp() != 0){
						System.out.println(e4.getName() + "に" + e4.getHp()/3 + "ポイントのダメージを与えた！");
						e4.addHp(-e4.getHp()/3);
					}
					if(!((b1f.t > b1f.v && b1f.u == b1f.w && e3.getHp() != 0)||(b1f.t > b1f.x && b1f.u == b1f.y && e4.getHp() != 0))){
						System.out.println("敵がいないのでダメージを与えられなかった！");
					}
				}
				else if(j == 3){
					if(b1f.t == b1f.v && b1f.u > b1f.w && e3.getHp() != 0){
						System.out.println(e3.getName() + "に" + e3.getHp()/3 + "ポイントのダメージを与えた！");
						e3.addHp(-e3.getHp()/3);
					}
					if(b1f.t == b1f.x && b1f.u > b1f.y && e4.getHp() != 0){
						System.out.println(e4.getName() + "に" + e4.getHp()/3 + "ポイントのダメージを与えた！");
						e4.addHp(-e4.getHp()/3);
					}
					if(!((b1f.t == b1f.v && b1f.u > b1f.w && e3.getHp() != 0)||(b1f.t == b1f.x && b1f.u > b1f.y && e4.getHp() != 0))){
						System.out.println("敵がいないのでダメージを与えられなかった！");
					}
				}
				else if(j == 4){
					if(b1f.t < b1f.v && b1f.u == b1f.w && e3.getHp() != 0){
						System.out.println(e3.getName() + "に" + e3.getHp()/3 + "ポイントのダメージを与えた！");
						e3.addHp(-e3.getHp()/3);
					}
					if(b1f.t < b1f.x && b1f.u == b1f.y && e4.getHp() != 0){
						System.out.println(e4.getName() + "に" + e4.getHp()/3 + "ポイントのダメージを与えた！");
						e4.addHp(-e4.getHp()/3);
					}
					if(!((b1f.t < b1f.v && b1f.u == b1f.w && e3.getHp() != 0)||(b1f.t < b1f.x && b1f.u == b1f.y && e4.getHp() != 0))){
						System.out.println("敵がいないのでダメージを与えられなかった！");
					}
				}
				else{
					System.out.println(this.getName() + "はあさっての方向にレーザーを撃ってしまった！");
					System.out.println("敵がいないのでダメージを与えられなかった！");
				}
				i5.setBi(i5.getBi() - 1);
			}
			else if(i5.getBi() == 0){
				System.out.println(i5.getName() + "はありません。");
			}
		}
		System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
		System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
		System.out.println("状態異常  " + this.getState().condition());
	}
	public void refresh2(Item i1, Item i2, Item i3, Item i4){
		System.out.println("使う道具を数字で入力してください。");
		System.out.println("１ " + this.getBag1() + i1.getBi() + " ２ " + this.getBag2() + i2.getBi() + " ３ " + this.getBag3() + i3.getBi() + " ４ " + this.getBag4() + i4.getBi() + " ５  もどる");
		int i= new java.util.Scanner(System.in).nextInt();
		if(i == 1){
			if(i1.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i1.getName() + " は使えません。");
				}
				else if(this.getHp() + i1.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i1.setBi(i1.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " + (i1.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i1.getRec());
					i1.setBi(i1.getBi() - 1);
				}
			}
			else if(i1.getBi() == 0){
				System.out.println(i1.getName() + "はありません。");
			}
		}
		else if(i == 2){
			if(i2.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i2.getName() + " は使えません。");
				}
				else if(this.getHp() + i2.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i2.setBi(i2.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " + (i2.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i2.getRec());
					i2.setBi(i2.getBi() - 1);
				}
			}
			else if(i2.getBi() == 0){
				System.out.println(i2.getName() + "はありません。");
			}
		}
		else if(i == 3){
			if(i3.getBi() != 0){
				if(this.getState().getIll() == 1){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(0);
					i3.setBi(i3.getBi() - 1);
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(2);
					i3.setBi(i3.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " +  " どく状態ではありません。");
					System.out.println(this.getName() + "に " + i3.getName() + " は使えません。");
				}
			}
			else if(i3.getBi() == 0){
				System.out.println(i3.getName() + "はありません。");
			}
		}
		else if(i == 4){
			if(i4.getBi() != 0){
				if(this.getState().getIll() == 2){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(0);
					i4.setBi(i4.getBi() - 1);
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(1);
					i4.setBi(i4.getBi() - 1);
				}
				else{
					System.out.println(this.getName() + "は " +  " まひ状態ではありません。");
					System.out.println(this.getName() + "に " + i4.getName() + " は使えません。");
				}
			}
			else if(i4.getBi() == 0){
				System.out.println(i4.getName() + "はありません。");
			}
		}
		System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
		System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
		System.out.println("状態異常  " + this.getState().condition());
	}
	public void refresh3(Enemy e, Item i1, Item i2, Item i3, Item i4){
		System.out.println("使う道具を数字で入力してください。");
		System.out.println("１ " + this.getBag1() + i1.getBi() + " ２ " + this.getBag2() + i2.getBi() + " ３ " + this.getBag3() + i3.getBi() + " ４ " + this.getBag4() + i4.getBi() + " ５  もどる");
		int i= new java.util.Scanner(System.in).nextInt();
		if(i == 1){
			if(i1.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i1.getName() + " は使えません。");
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
					this.attack(e, i1, i2, i3, i4);
				}
				if(this.getHp() + i1.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i1.setBi(i1.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else{
					System.out.println(this.getName() + "は " + (i1.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i1.getRec());
					i1.setBi(i1.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
			}
			else if(i1.getBi() == 0){
				System.out.println(i1.getName() + "はありません。");
				System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
				System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
				System.out.println("状態異常  " + this.getState().condition());
				this.attack(e, i1, i2, i3, i4);
			}
		}
		else if(i == 2){
			if(i2.getBi() != 0){
				if(this.getHp() == this.maxHp){
					System.out.println(this.getName() + " の体力は最大です。");
					System.out.println(this.getName() + "に " + i2.getName() + " は使えません。");
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
					this.attack(e, i1, i2, i3, i4);
				}
				else if(this.getHp() + i2.getRec() > this.maxHp){
					System.out.println(this.getName() + "は " + (this.maxHp - this.getHp()) + " 体力を回復した。");
					this.setHp(this.maxHp);
					i2.setBi(i2.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else{
					System.out.println(this.getName() + "は " + (i2.getRec()) + " 体力を回復した。");
					this.setHp(this.getHp() + i2.getRec());
					i2.setBi(i2.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
			}
			else if(i2.getBi() == 0){
				System.out.println(i2.getName() + "はありません。");
				System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
				System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
				System.out.println("状態異常  " + this.getState().condition());
				this.attack(e, i1, i2, i3, i4);
			}
		}
		else if(i == 3){
			if(i3.getBi() != 0){
				if(this.getState().getIll() == 1){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(0);
					i3.setBi(i3.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i3.getName() + " でどくを消した。");
					this.getState().setIll(2);
					i3.setBi(i3.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else{
					System.out.println(this.getName() + "は " +  " どく状態ではありません。");
					System.out.println(this.getName() + "に " + i3.getName() + " は使えません。");
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
					this.attack(e, i1, i2, i3, i4);
				}
			}
			else if(i3.getBi() == 0){
				System.out.println(i3.getName() + "はありません。");
				System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
				System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
				System.out.println("状態異常  " + this.getState().condition());
				this.attack(e, i1, i2, i3, i4);
			}
		}
		else if(i == 4){
			if(i4.getBi() != 0){
				if(this.getState().getIll() == 2){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(0);
					i4.setBi(i4.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else if(this.getState().getIll() == 3){
					System.out.println(this.getName() + "は " + i4.getName() + " でまひを消した。");
					this.getState().setIll(1);
					i4.setBi(i4.getBi() - 1);
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
				}
				else{
					System.out.println(this.getName() + "は " +  " まひ状態ではありません。");
					System.out.println(this.getName() + "に " + i4.getName() + " は使えません。");
					System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
					System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
					System.out.println("状態異常  " + this.getState().condition());
					this.attack(e, i1, i2, i3, i4);
				}
			}
			else if(i4.getBi() == 0){
				System.out.println(i4.getName() + "はありません。");
				System.out.println(this.getName() +" 体力" + this.getHp() + " 最大体力" + this.maxHp + " 攻撃力" + this.getAtk() + " 防御力" + this.getDef() + " 取得経験値" + this.getExp());
				System.out.println("持ち物  " + this.getBag1() + i1.getBi() + " " + this.getBag2() + i2.getBi()+ " " + this.getBag3() + i3.getBi() + " " + this.getBag4() + i4.getBi());
				System.out.println("状態異常  " + this.getState().condition());
				this.attack(e, i1, i2, i3, i4);
			}
		}
		else{
			this.attack(e, i1, i2, i3, i4);
		}
	}
}

