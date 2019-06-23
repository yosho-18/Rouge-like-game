public class BoardUg2F {
	int s = 11;
	int s1 = 7;
	int t = 1;
	int u = 1;
	int nei = 9;
	int nej = 3;
	int br1i = 2;
	int br1j = 2;
	int br2i = 2;
	int br2j = 4;
	int br3i = 4;
	int br3j = 2;
	int br4i = 4;
	int br4j = 4;
	int br5i = 6;
	int br5j = 2;
	int br6i = 6;
	int br6j = 4;
	int tr1i = 2;
	int tr1j = 1;
	int tr2i = 6;
	int tr2j = 3;
	int trai = 4;
	int traj = 3;
	int wa1i = 2;
	int wa1j = 3;
	int wa2i = 4;
	int wa2j = 5;
	int wa3i = 6;
	int wa3j = 1;
	int war1i = 1;
	int war1j = 1;
	int upi = s - 2;
	int upj = s1 - 2;
	private char[][] map = new char[s][s1];
	
	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}
	public BoardUg2F(Player p, Enemy note, Item i1, Item i2, Item i3, Item i4, Item i5) {
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
				else if(i == nei && j == nej){
					getMap()[i][j] = note.getSuf();
				}
				else if((i == br1i && j == br1j) || (i == br2i && j == br2j) || (i == br3i && j == br3j) || (i == br4i && j == br4j)|| (i == br5i && j == br5j) || (i == br6i && j == br6j)){
					getMap()[i][j] = '＊';
				}
				else if(i == upi && j == upj){
					getMap()[i][j] = '￥';
				}
				else{
					getMap()[i][j] = '〇';
				}
			}
		}
	}
	
	public void printBoard(Player p, Item i1, Item i2, Item i3, Item i4, Item i5){
		System.out.println("地下２階");
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
	
	int hit1 = 10;
	int co = 0;
	public void trap1(Player p){
		if(t == tr1i && u == tr1j && co == 0){
			p.setHp(p.getHp() - hit1);
			System.out.println(p.getName() + "はまきびしを踏んでしまった！");
			System.out.println(p.getName() + "は " + hit1 + " 体力が減った。");
			co++;
		}
	}
	
	int hit2 = 5;
	int co2 = 0;
	public void trap2(Player p){
		if(t == tr2i && u == tr2j && co2 == 0){
			System.out.println(p.getName() + "は まひの実 を食べてしまった！");
			if(p.getState().getIll() == 0){
				p.getState().setIll(2);
				System.out.println(p.getName() + "は " + " まひ になった。");
			}
			if(p.getState().getIll() == 1){
				p.getState().setIll(3);
				System.out.println(p.getName() + "は " + " どく、まひ になった。");
			}
			p.setHp(p.getHp() - hit2);
			System.out.println(p.getName() + "は " + hit2 + " 体力が減った。");
			co2++;
		}
	}
	
	int hit3 = 5;
	int coa = 0;
	public void trapa(Player p){
		if(t == trai && u == traj && coa == 0){
			System.out.println(p.getName() + "は どくの実 を食べてしまった！");
			if(p.getState().getIll() == 0){
				p.getState().setIll(1);
				System.out.println(p.getName() + "は " + " どく になった。");
			}
			if(p.getState().getIll() == 2){
				p.getState().setIll(3);
				System.out.println(p.getName() + "は " + " どく、まひ になった。");
			}
			p.setHp(p.getHp() - hit3);
			System.out.println(p.getName() + "は " + hit3 + " 体力が減った。");
			coa++;
		}
	}
	
	public void warp(Player p){
		if(((t == wa1i && u == wa1j) || (t == wa2i && u == wa2j) ||  (t == wa3i && u == wa3j)) && (getMap()[war1i][war1j] == '〇')){
			getMap()[t][u] = '〇';
			getMap()[war1i][war1j] = p.getSuf();
			t = war1i;
			u = war1j;
			System.out.println(p.getName() + "はワープマップを踏んで違う場所に飛ばされた！");
		}
	}
	
	int conote = 0;
	public void talk(Player p, Enemy note, Enemy e4, Item i1, Item i2, Item i3, Item i4, Item i5){
		if(((t == nei - 1 && u == nej) ||(t == nei && u == nej + 1) || (t == nei + 1 && u == nej) || (t == nei && u == nej- 1)) && conote == 0){
			this.printBoard(p, i1, i2, i3, i4, i5);
			System.out.println(note.getName() + "と遭遇した！");
			System.out.println(p.getName() + "さん 話す内容を数字で入力してください。");
			System.out.println("１ あなたは誰ですか？ ２ ここには敵はいないのですか？ ３ 無視");
			int i= new java.util.Scanner(System.in).nextInt();
			if(i == 1){
				System.out.println(note.getName() + "「名乗るほどの者ではない」");
			}
			else if(i == 2){
				System.out.println(note.getName() + "「ここにはいない」");
			}
			else{
				System.out.println(note.getName() + "「無視しないでくれよ" + p.getName() + " くん」");
			}
			System.out.println("「おっと、安心してくれ。僕は敵ではない。」");
			System.out.println("「しかし、よくぞここまでたどり着いた " + p.getName() + " くん！」");
			System.out.println("「この下にいるラスボスを倒せばゲームクリアだ！」");
			System.out.println("「僕は " + p.getName() + " くん" + "がこのゲームをクリアするための手助けをしようと思っている。");
			System.out.println("「ほしいアイテムの組み合わせを選んでくれ！」");
			System.out.println("１" + p.getBag2() + 3 + "  ２ " + p.getBag2() + 2 + " " +  p.getBag3() + 1 + "  ３ " + p.getBag2() + 2 + " " + p.getBag4() + 1 + "  ４ " + p.getBag2() + 1 + " " + p.getBag3() + 1 + " " +  p.getBag4() + 1 + "  ５ いらない");
			int j= new java.util.Scanner(System.in).nextInt();
			if(j == 1){
				System.out.println(p.getName() + "は" + i2.getName() + "を３個手に入れた");
				i2.setBi(i2.getBi() + 3);
			}
			if(j == 2){
				System.out.println(p.getName() + "は" + i2.getName() + "を２個手に入れた");
				System.out.println(i3.getName() + "を１個手に入れた");
				i2.setBi(i2.getBi() + 2);
				i3.setBi(i3.getBi() + 1);
			}
			if(j == 3){
				System.out.println(p.getName() + "は" + i2.getName() + "を２個手に入れた");
				System.out.println(i4.getName() + "を１個手に入れた");
				i2.setBi(i2.getBi() + 2);
				i4.setBi(i4.getBi() + 1);
			}
			if(j == 4){
				System.out.println(p.getName() + "は" + i2.getName() + "を１個手に入れた");
				System.out.println(i3.getName() + "を１個手に入れた");
				System.out.println(i4.getName() + "を１個手に入れた");
				i2.setBi(i2.getBi() + 1);
				i3.setBi(i3.getBi() + 1);
				i4.setBi(i4.getBi() + 1);
			}
			if(j == 5){
				System.out.println(note.getName() + "「そうか、いらないのか。」");
			}
			System.out.println(note.getName() + "「ではさらばだ！健闘を祈る！」");
			getMap()[nei][nej] = '〇';
			conote++;
		}
	}
	
	//public void downstairs(Player p, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg3F b3f){
		//if(p.getHp() > 0 && (getMap()[s - 2][s1 - 2] == p.getSuf() && this.conote == 1)){
			//b3f.printBoard(p, i1, i2, i3, i4, i5);
		//}
	//}
	
	
	
	
	
	
	public void move(int k, Player p, Enemy note, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg2F b2f){
		char c = '〇';
		char d = '私';
		char f = '￥';
		if(k == 1){
			if(u != s1 - 2){
				if(!(t == br1i && u == br1j - 1) && !(t == br2i && u == br2j - 1) && !(t == br3i && u == br3j - 1) && !(t == br4i && u == br4j - 1) && !(t == br5i && u == br5j - 1) && !(t == br6i && u == br6j - 1)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t][u + 1] = d;
					u = u + 1;
					this.trap1(p);
					this.trap2(p);
					this.trapa(p);
					this.warp(p);
					this.talk(p, note, note, i1, i2, i3, i4, i5);
				}
			}
		}
		if(k == 2){
			if(t != 1){
				if(!(t == br1i + 1 && u == br1j) && !(t == br2i + 1  && u == br2j ) && !(t == br3i + 1 && u == br3j ) && !(t == br4i + 1 && u == br4j) && !(t == br5i + 1 && u == br5j) && !(t == br6i + 1 && u == br6j)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t - 1][u] = d;
					t = t - 1;
					this.trap1(p);
					this.trap2(p);
					this.trapa(p);
					this.warp(p);
					this.talk(p, note, note, i1, i2, i3, i4, i5);
				}
			}
		}
		if(k == 3){
			if(u != 1){
				if(!(t == br1i && u == br1j + 1) && !(t == br2i && u == br2j + 1) && !(t == br3i && u == br3j + 1) && !(t == br4i && u == br4j + 1) && !(t == br5i && u == br5j + 1) && !(t == br6i && u == br6j + 1)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t][u - 1] = d;
					u = u - 1;
					this.trap1(p);
					this.trap2(p);
					this.trapa(p);
					this.warp(p);
					this.talk(p, note, note, i1, i2, i3, i4, i5);
				}
			}
		}
		if(k == 4){
			if(t != s - 2){
				if(!(t == br1i - 1 && u == br1j) && !(t == br2i - 1  && u == br2j ) && !(t == br3i - 1 && u == br3j ) && !(t == br4i - 1 && u == br4j) && !(t == br5i - 1 && u == br5j) && !(t == br6i - 1 && u == br6j)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t + 1][u] = d;
					t = t + 1;
					this.trap1(p);
					this.trap2(p);
					this.trapa(p);
					this.warp(p);
					this.talk(p, note, note, i1, i2, i3, i4, i5);
				}
			}
		}
		if(k == 5){
			p.refresh2(i1, i2, i3, i4);
			p.action2(b2f, note, p, i1, i2, i3, i4, i5);
			System.out.println(p.getName() +" 体力" + p.getHp() + " 最大体力" + p.maxHp + " 攻撃力" + p.getAtk() + " 防御力" + p.getDef() + " 取得経験値" + p.getExp());
			System.out.println("持ち物  " + p.getBag1() + i1.getBi() + " " + p.getBag2() + i2.getBi());
			System.out.println("状態異常  " + p.getState().condition());
		}
	}
}
