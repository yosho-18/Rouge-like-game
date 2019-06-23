public class BoardUg1F{
	int s = 14;
	int t = 1;
	int u = 1;
	int v = 5;
	int w = 10;
	int x = 11;
	int y = 5;
	int i1i = 7;
	int i1j = 2;
	int i2i = 6;
	int i2j = 7;
	int i3i = 3;
	int i3j = 11;
	int i4i = 11;
	int i4j = 9;
	int i5i = 2;
	int i5j = 5;
	int br1i = 4;
	int br1j = 3;
	int br2i = 2;
	int br2j = 7;
	int br3i = 7;
	int br3j = 8;
	int br4i = 11;
	int br4j = 11;
	int tr1i = 2;
	int tr1j = 3;
	int trai = 6;
	int traj = 6;
	int trzi = 10;
	int trzj = 8;
	int wa1i = 12;
	int wa1j = 11;
	int war1i = 4;
	int war1j = 5;
	int upi = s - 2;
	int upj = s - 2;
	private char[][] map = new char[s][s];
	
	public char[][] getMap() {
		return map;
	}

	public void setMap(char[][] map) {
		this.map = map;
	}
	public BoardUg1F(Player p, Enemy e3, Enemy e4, Item i1, Item i2, Item i3, Item i4, Item i5) {
		for(int i = 0; i < getMap().length; i++){
			for(int j = 0; j < getMap()[0].length; j++){
				if((i == 0 && j == 0) || (i == 0 && j == s - 1) || (i == s - 1 && j == 0) || (i == s - 1 && j == s - 1)){
					getMap()[i][j] = '+';
				}
				else if((i == 0 && j != 0 && j != s - 1) || (i == s - 1 && j != 0 && j != s - 1)){
					getMap()[i][j] = '－';
				}
				else if((i != 0 && i != s - 1 && j == 0) || (i != 0 && i != s - 1 && j == s - 1)){
					getMap()[i][j] = '|';
				}
				else if(i == t && j == u){
					getMap()[i][j] = p.getSuf();
				}
				else if(i == v && j == w){
					getMap()[i][j] = e3.getSuf();
				}
				else if(i == x && j == y){
					getMap()[i][j] = e4.getSuf();
				}
				else if(i == i1i && j == i1j){
					getMap()[i][j] = i1.getSuf();
				}
				else if(i == i2i && j == i2j){
					getMap()[i][j] = i2.getSuf();
				}
				else if(i == i3i && j == i3j){
					getMap()[i][j] = i3.getSuf();
				}
				else if(i == i4i && j == i4j){
					getMap()[i][j] = i4.getSuf();
				}
				else if(i == i5i && j == i5j){
					getMap()[i][j] = i5.getSuf();
				}
				else if((i == br1i && j == br1j) || (i == br2i && j == br2j) || (i == br3i && j == br3j) || (i == br4i && j == br4j)){
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
		System.out.println("地下１階");
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
	
	public int abs(int a){
		if(a >= 0){
			return a;
		}
		else{
			return -a;
		}
	}
	
	public void fight(Player p, Enemy e, Item i1, Item i2, Item i3, Item i4, Item i5){
		this.printBoard(p, i1, i2, i3, i4, i5);
		System.out.println("あ！やせいの" + e.getName() + "が出てきた！");
		System.out.println(e.getName() +" 体力" + e.getHp() + " 最大体力" + e.maxHp  + " 攻撃力" + e.getAtk() + " 防御力" + e.getDef() + " 取得経験値" + e.getExp());
		while(e.getHp() > 0 && p.getHp() > 0){
			p.attack(e, i1, i2, i3, i4);
			if(e.getHp() > 0){
				e.attackplus(p);
			}
		}
		if(e.getHp() <= 0){
			System.out.println(e.getName() + "は倒れた！");
			p.experience(e);
			p.levelup(e);
		}
	}
	
	public void appear(Enemy e3, Enemy e4){
		if(e3.getHp() > 0 || e4.getHp() > 0){
			if(e3.getHp() == 0){
				int r1 = new java.util.Random().nextInt(5) + 1;
				if(r1 % 5 == 0){
					int vi = new java.util.Random().nextInt(s - 2) + 1;
					int wj = new java.util.Random().nextInt(s - 2) + 1;
					v = vi;
					w = wj;
					if(getMap()[v][w] == '〇' && !(u == w - 1 && t == v) && !(u == w && t == v + 1) && !(u == w + 1 && t == v) && !(u == w && t == v - 1)){
						getMap()[v][w] = e3.getSuf();
						e3.setHp(e3.maxHp);
						System.out.println(e3.getName() + "がフィールドに出現した！");
					}
				}
			}
			if(e4.getHp() == 0){
				int r2 = new java.util.Random().nextInt(5) + 1;
				if(r2 % 5 == 0){
					int xi = new java.util.Random().nextInt(10) + 1;
					int yj = new java.util.Random().nextInt(10) + 1;
					x = xi;
					y = yj;
					if(getMap()[x][y] == '〇' && !(u == y - 1 && t == x) && !(u == y && t == x + 1) && !(u == y + 1 && t == x) && !(u == y && t == x - 1)){
						getMap()[x][y] = e4.getSuf();
						e4.setHp(e4.maxHp);
						System.out.println(e4.getName() + "がフィールドに出現した！");
					}
				}
			}
		}
	}
	
	int hit1 = 15;
	int co = 0;
	public void trap1(Player p){
		if(t == tr1i && u == tr1j && co == 0){
			p.setHp(p.getHp() - hit1);
			System.out.println(p.getName() + "はまきびしを踏んでしまった！");
			System.out.println(p.getName() + "は " + hit1 + " 体力が減った。");
			co++;
		}
	}
	
	int coa = 0;
	int hit2 = 5;
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
			System.out.println(p.getName() + "は " + hit2 + " 体力が減った。");
			coa++;
		}
	}
	
	int coz = 0;
	int hit3 = 5;
	public void trapz(Player p){
		if(t == trzi && u == trzj && coz == 0){
			p.setHp(p.getHp() + hit3);
			System.out.println(p.getName() + "は 回復の実 を食べた！");
			System.out.println(p.getName() + "は " + hit3 + " 体力を回復した。");
			coz++;
		}
	}
	
	public void warp(Player p){
		if(t == wa1i && u == wa1j && getMap()[war1i][war1j] == '〇'){
			getMap()[t][u] = '〇';
			getMap()[war1i][war1j] = p.getSuf();
			t = war1i;
			u = war1j;
			System.out.println(p.getName() + "はワープマップを踏んで違う場所に飛ばされた！");
		}
	}
	
	//public void downstairs(Player p, Enemy e3, Enemy e4, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg2F b2f){
		//if(p.getHp() > 0 && (e3.getHp() == 0) && (e4.getHp() == 0) && getMap()[s - 2][s - 2] == p.getSuf()){
			//b2f.printBoard(p, i1, i2, i3, i4, i5);
		//}
	//}
	
	
	
	
	
	
	int co1 = 0;
	int co2 = 0;
	int co3 = 0;
	int co4 = 0;
	int co5 = 0;
	public void move(int k, Enemy ea, Player p, Enemy e3, Enemy e4, Item i1, Item i2, Item i3, Item i4, Item i5, BoardUg1F b1f){
		char c = '〇';
		char d = '私';
		char e = '＠';
		char f = '￥';
		if(k == 1){
			if(u != s - 2){
				if(!(t == br1i && u == br1j - 1) && !(t == br2i && u == br2j - 1) && !(t == br3i && u == br3j - 1) && !(t == br4i && u == br4j - 1)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t][u + 1] = d;
					u = u + 1;
					this.trap1(p);
					this.trapa(p);
					this.trapz(p);
					this.warp(p);
					if(t == i1i && u == i1j && co1 == 0){
						System.out.println(i1.getName() + " を手に入れた！");
						i1.setBi(i1.getBi() + 1);
						co1++;
					}
					if(t == i2i && u == i2j && co2 == 0){
						i2.setBi(i2.getBi() + 1);
						System.out.println(i2.getName() + " を手に入れた！");
						co2++;
					}
					if(t == i3i && u == i3j && co3 == 0){
						System.out.println(i3.getName() + " を手に入れた！");
						i3.setBi(i3.getBi() + 1);
						co3++;
					}
					if(t == i4i && u == i4j && co4 == 0){
						i4.setBi(i4.getBi() + 1);
						System.out.println(i4.getName() + " を手に入れた！");
						co4++;
					}
					if(t == i5i && u == i5j && co5 == 0){
						System.out.println(i5.getName() + " を手に入れた！");
						i5.setBi(i5.getBi() + 1);
						co5++;
					}
					if(e3.getHp() > 0){
						if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
							this.fight(p, e3, i1, i2, i3, i4, i5);
							if(e3.getHp() <= 0){
								getMap()[v][w] = c;
							}
						}
					}
					if(e4.getHp() > 0){
						if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
							this.fight(p, e4, i1, i2, i3, i4, i5);
							if(e4.getHp() <= 0){
								getMap()[x][y] = c;
							}
						}
					}
					if(p.getHp() > 0){
						if(e3.getHp() > 0){
							if((abs(v - t) <= abs(w - u)) && ((v - t) > (w - u)) && !(v == br1i && w == br1j - 1) && !(v == br2i && w == br2j - 1) && !(v == br3i && w == br3j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w + 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w + 1] = g;
									w = w + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) >= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) < 0) && !(v == br1i + 1 && w == br1j) && !(v == br2i + 1 && w == br2j) && !(v == br3i + 1&& w == br3j) && !(v == br4i + 1 && w == br4j)){
								if(!(v - 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v - 1][w] = g;
									v = v - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) <= abs(w - u)) && ((v - t) < (w - u)) && !(v == br1i && w == br1j + 1) && !(v == br2i && w == br2j + 1) && !(v == br3i && w == br3j + 1) && !(v == br4i && w == br4j + 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w - 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w - 1] = g;
									w = w - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1 ,i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) <= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) > 0) && !(v == br1i - 1 && w == br1j) && !(v == br2i - 1 && w == br2j) && !(v == br3i - 1&& w == br3j) && !(v == br4i - 1 && w == br4j)){
								if(!(v + 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v + 1][w] = g;
									v = v + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
						}
						if(e4.getHp() > 0){
							if((abs(x - t) <= abs(y - u)) && ((x - t) > (y - u)) && !(x == br1i && y == br1j - 1) && !(x == br2i && y == br2j - 1) && !(x == br3i && y == br3j - 1) && !(x == br4i && y == br4j - 1)){
								if(!(v == x && w - 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y + 1] = g;
									y = y + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y- u)) && ((x - t) >= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) < 0) && !(x == br1i + 1 && y == br1j) && !(x == br2i + 1&& y == br2j) && !(x == br3i + 1 && y == br3j) && !(x == br4i + 1 && y == br4j)){
								if(!(v + 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x - 1][y] = g;
									x = x - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) <= abs(y - u)) && ((x - t) < (y - u))&& !(x == br1i && y == br1j + 1) && !(x == br2i && y == br2j + 1) && !(x == br3i && y == br3j + 1) && !(x == br4i && y == br4j + 1)){
								if(!(v == x && w + 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y - 1] = g;
									y = y - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y - u)) && ((x - t) <= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) > 0)&& !(x == br1i - 1 && y == br1j) && !(x == br2i - 1 && y == br2j) && !(x == br3i - 1 && y == br3j) && !(x == br4i - 1 && y == br4j)){
								if(!(v - 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x + 1][y] = g;
									x = x + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(k == 2){
			if(t != 1){
				if(!(t == br1i + 1 && u == br1j) && !(t == br2i + 1  && u == br2j ) && !(t == br3i + 1 && u == br3j ) && !(t == br4i + 1 && u == br4j )){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t - 1][u] = d;
					t = t - 1;
					this.trap1(p);
					this.trapa(p);
					this.trapz(p);
					this.warp(p);
					if(t == i1i && u == i1j && co1 == 0){
						System.out.println(i1.getName() + " を手に入れた！");
						i1.setBi(i1.getBi() + 1);
						co1++;
					}
					if(t == i2i && u == i2j && co2 == 0){
						i2.setBi(i2.getBi() + 1);
						System.out.println(i2.getName() + " を手に入れた！");
						co2++;
					}
					if(t == i3i && u == i3j && co3 == 0){
						System.out.println(i3.getName() + " を手に入れた！");
						i3.setBi(i3.getBi() + 1);
						co3++;
					}
					if(t == i4i && u == i4j && co4 == 0){
						i4.setBi(i4.getBi() + 1);
						System.out.println(i4.getName() + " を手に入れた！");
						co4++;
					}
					if(t == i5i && u == i5j && co5 == 0){
						System.out.println(i5.getName() + " を手に入れた！");
						i5.setBi(i5.getBi() + 1);
						co5++;
					}
					if(e3.getHp() > 0){
						if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
							this.fight(p, e3, i1, i2, i3, i4, i5);
							if(e3.getHp() == 0){
								getMap()[v][w] = c;
							}
						}
					}
					if(e4.getHp() > 0){
						if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
							this.fight(p, e4, i1, i2, i3, i4, i5);
							if(e4.getHp() == 0){
								getMap()[x][y] = c;
							}
						}
					}
					if(p.getHp() > 0){
						if(e3.getHp() > 0){
							if((abs(v - t) <= abs(w - u)) && ((v - t) > (w - u)) && !(v == br1i && w == br1j - 1) && !(v == br2i && w == br2j - 1) && !(v == br3i && w == br3j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w + 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w + 1] = g;
									w = w + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) >= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) < 0) && !(v == br1i + 1 && w == br1j) && !(v == br2i + 1 && w == br2j) && !(v == br3i + 1&& w == br3j) && !(v == br4i + 1 && w == br4j)){
								if(!(v - 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v - 1][w] = g;
									v = v - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) <= abs(w - u)) && ((v - t) < (w - u)) && !(v == br1i && w == br1j + 1) && !(v == br2i && w == br2j + 1) && !(v == br3i && w == br3j + 1) && !(v == br4i && w == br4j + 1) && !(v == br4i && w == br4j + 1)){
								if(!(v == x && w - 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w - 1] = g;
									w = w - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) <= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) > 0) && !(v == br1i - 1 && w == br1j) && !(v == br2i - 1 && w == br2j) && !(v == br3i - 1&& w == br3j) && !(v == br4i - 1 && w == br4j)){
								if(!(v + 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v + 1][w] = g;
									v = v + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
						}
						if(e4.getHp() > 0){
							if((abs(x - t) <= abs(y - u)) && ((x - t) > (y - u))&& !(x == br1i && y == br1j - 1) && !(x == br2i && y == br2j - 1) && !(x == br3i && y == br3j - 1) && !(x == br4i && y == br4j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w - 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y + 1] = g;
									y = y + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y- u)) && ((x - t) >= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) < 0) && !(x == br1i + 1 && y == br1j) && !(x == br2i + 1 && y == br2j ) && !(x == br3i + 1 && y == br3j) && !(x == br4i + 1 && y == br4j)){
								if(!(v + 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x - 1][y] = g;
									x = x - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) <= abs(y - u)) && ((x - t) < (y - u))&& !(x == br1i && y == br1j + 1) && !(x == br2i && y == br2j + 1) && !(x == br3i && y == br3j + 1) && !(x == br4i && y == br4j + 1)){
								if(!(v == x && w + 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y - 1] = g;
									y = y - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y - u)) && ((x - t) <= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) > 0)&& !(x == br1i - 1 && y == br1j) && !(x == br2i - 1 && y == br2j) && !(x == br3i - 1 && y == br3j) && !(x == br4i - 1 && y == br4j)){
								if(!(v - 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x + 1][y] = g;
									x = x + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(k == 3){
			if(u != 1){
				if(!(t == br1i && u == br1j + 1) && !(t == br2i && u == br2j + 1) && !(t == br3i && u == br3j + 1) && !(t == br4i && u == br4j + 1)){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t][u - 1] = d;
					u = u - 1;
					this.trap1(p);
					this.trapa(p);
					this.trapz(p);
					this.warp(p);
					if(t == i1i && u == i1j && co1 == 0){
						System.out.println(i1.getName() + " を手に入れた！");
						i1.setBi(i1.getBi() + 1);
						co1++;
					}
					if(t == i2i && u == i2j && co2 == 0){
						System.out.println(i2.getName() + " を手に入れた！");
						i2.setBi(i2.getBi() + 1);
						co2++;
					}
					if(t == i3i && u == i3j && co3 == 0){
						System.out.println(i3.getName() + " を手に入れた！");
						i3.setBi(i3.getBi() + 1);
						co3++;
					}
					if(t == i4i && u == i4j && co4 == 0){
						i4.setBi(i4.getBi() + 1);
						System.out.println(i4.getName() + " を手に入れた！");
						co4++;
					}
					if(t == i5i && u == i5j && co5 == 0){
						System.out.println(i5.getName() + " を手に入れた！");
						i5.setBi(i5.getBi() + 1);
						co5++;
					}
					if(e3.getHp() > 0){
						if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
							this.fight(p, e3, i1, i2, i3, i4, i5);
							if(e3.getHp() <= 0){
								getMap()[v][w] = c;
							}
						}
					}
					if(e4.getHp() > 0){
						if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
							this.fight(p, e4, i1, i2, i3, i4, i5);
							if(e4.getHp() <= 0){
								getMap()[x][y] = c;
							}
						}
					}
					if(p.getHp() > 0){
						if(e3.getHp() > 0){
							if((abs(v - t) <= abs(w - u)) && ((v - t) > (w - u)) && !(v == br1i && w == br1j - 1) && !(v == br2i && w == br2j - 1) && !(v == br3i && w == br3j - 1) && !(v == br4i && w == br4j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w + 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w + 1] = g;
									w = w + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) >= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) < 0) && !(v == br1i + 1 && w == br1j) && !(v == br2i + 1 && w == br2j) && !(v == br3i + 1 && w == br3j) && !(v == br4i + 1 && w == br4j)){
								if(!(v - 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v - 1][w] = g;
									v = v - 1;
									if((u == w - 1 && t == v) || (u == w && t == v + 1) || (u == w + 1 && t == v) || (u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) <= abs(w - u)) && ((v - t) < (w - u)) && !(v == br1i && w == br1j + 1) && !(v == br2i && w == br2j + 1) && !(v == br3i && w == br3j + 1) && !(v == br4i && w == br4j + 1) && !(v == br4i && w == br4j + 1)){
								if(!(v == x && w - 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w - 1] = g;
									w = w - 1;
									if((u == w - 1 && t == v) || (u == w && t == v + 1) || (u == w + 1 && t == v) || (u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) <= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) > 0) && !(v == br1i - 1 && w == br1j) && !(v == br2i - 1 && w == br2j) && !(v == br3i - 1 && w == br3j) && !(v == br4i - 1 && w == br4j)){
								if(!(v + 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v + 1][w] = g;
									v = v + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
						}
						if(e4.getHp() > 0){
							if((abs(x - t) <= abs(y - u)) && ((x - t) > (y - u))&& !(x == br1i && y == br1j - 1) && !(x == br2i && y == br2j - 1) && !(x == br3i && y == br3j - 1) && !(x == br4i && y == br4j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w - 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y + 1] = g;
									y = y + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y- u)) && ((x - t) >= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) < 0)&& !(x == br1i + 1 && y == br1j) && !(x == br2i + 1 && y == br2j) && !(x == br3i + 1 && y == br3j) && !(x == br4i + 1 && y == br4j)){
								if(!(v + 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x - 1][y] = g;
									x = x - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) <= abs(y - u)) && ((x - t) < (y - u))&& !(x == br1i && y == br1j + 1) && !(x == br2i && y == br2j + 1) && !(x == br3i && y == br3j + 1) && !(x == br4i && y == br4j + 1) && !(v == br4i && w == br4j + 1)){
								if(!(v == x && w + 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y - 1] = g;
									y = y - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y - u)) && ((x - t) <= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) > 0)&& !(x == br1i - 1 && y == br1j) && !(x == br2i - 1 && y == br2j) && !(x == br3i - 1 && y == br3j) && !(x == br4i - 1 && y == br4j)){
								if(!(v - 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x + 1][y] = g;
									x = x + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(k == 4){
			if(t != s - 2){
				if(!(t == br1i - 1 && u == br1j) && !(t == br2i - 1  && u == br2j ) && !(t == br3i - 1 && u == br3j ) && !(t == br4i - 1 && u == br4j )){
					if(t == upi && u == upj){
						getMap()[t][u] = f;
					}
					else{
						getMap()[t][u] = c;
					}
					getMap()[t + 1][u] = d;
					t = t + 1;
					this.trap1(p);
					this.trapa(p);
					this.trapz(p);
					this.warp(p);
					if(t == i1i && u == i1j && co1 == 0){
						System.out.println(i1.getName() + " を手に入れた！");
						i1.setBi(i1.getBi() + 1);
						co1++;
					}
					if(t == i2i && u == i2j && co2 == 0){
						System.out.println(i2.getName() + " を手に入れた！");
						i2.setBi(i2.getBi() + 1);
						co2++;
					}
					if(t == i3i && u == i3j && co3 == 0){
						System.out.println(i3.getName() + " を手に入れた！");
						i3.setBi(i3.getBi() + 1);
						co3++;
					}
					if(t == i4i && u == i4j && co4 == 0){
						i4.setBi(i4.getBi() + 1);
						System.out.println(i4.getName() + " を手に入れた！");
						co4++;
					}
					if(t == i5i && u == i5j && co5 == 0){
						System.out.println(i5.getName() + " を手に入れた！");
						i5.setBi(i5.getBi() + 1);
						co5++;
					}
					if(e3.getHp() > 0){
						if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
							this.fight(p, e3, i1, i2, i3, i4, i5);
							if(e3.getHp() <= 0){
								getMap()[v][w] = c;
							}
						}
					}
					if(e4.getHp() > 0){
						if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
							this.fight(p, e4, i1, i2, i3, i4, i5);
							if(e4.getHp() <= 0){
								getMap()[x][y] = c;
							}
						}
					}
					if(p.getHp() > 0){
						if(e3.getHp() > 0){
							if((abs(v - t) <= abs(w - u)) && ((v - t) > (w - u)) && !(v == br1i && w == br1j - 1) && !(v == br2i && w == br2j - 1) && !(v == br3i && w == br3j - 1) && !(v == br4i && w == br4j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w + 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w + 1] = g;
									w = w + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) >= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) < 0) && !(v == br1i + 1 && w == br1j) && !(v == br2i + 1 && w == br2j) && !(v == br3i + 1 && w == br3j) && !(v == br4i + 1 && w == br4j)){
								if(!(v - 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v - 1][w] = g;
									v = v - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) <= abs(w - u)) && ((v - t) < (w - u)) && !(v == br1i && w == br1j + 1) && !(v == br2i && w == br2j + 1) && !(v == br3i && w == br3j + 1) && !(v == br4i && w == br4j + 1) && !(v == br4i && w == br4j + 1)){
								if(!(v == x && w - 1 == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v][w - 1] = g;
									w = w - 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
							else if((abs(v - t) >= abs(w - u)) && ((v - t) <= (w - u)) && ((v - t) != -(w - u)) && !(((v - t) == (w - u)) && (v - t) > 0) && !(v == br1i - 1 && w == br1j) && !(v == br2i - 1 && w == br2j) && !(v == br3i - 1 && w == br3j) && !(v == br4i - 1 && w == br4j)){
								if(!(v + 1 == x && w == y && e4.getHp() > 0)){
									char g = getMap()[v][w];
									if((v == i1i && w == i1j && co1 == 0) || (v == i2i && w == i2j && co2 == 0) || (v == i3i && w == i3j && co3 == 0) || (v == i4i && w == i4j && co4 == 0) || (v == i5i && w == i5j && co5 == 0)){
										getMap()[v][w] = e;
									}
									else if(v == upi && w == upj){
										getMap()[v][w] = f;
									}
									else{
										getMap()[v][w] = c;
									}
									getMap()[v + 1][w] = g;
									v = v + 1;
									if((u == w - 1 && t == v) ||(u == w && t == v + 1) || (u == w + 1 && t == v) ||(u == w && t == v - 1)){
										this.fight(p, e3, i1, i2, i3, i4, i5);
										if(e3.getHp() <= 0){
											getMap()[v][w] = c;
										}
									}
								}
							}
						}
						if(e4.getHp() > 0){
							if((abs(x - t) <= abs(y - u)) && ((x - t) > (y - u)) && !(x == br1i && y == br1j - 1) && !(x == br2i && y == br2j - 1) && !(x == br3i && y == br3j - 1) && !(x == br4i && y == br4j - 1) && !(v == br4i && w == br4j - 1)){
								if(!(v == x && w - 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y + 1] = g;
									y = y + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y- u)) && ((x - t) >= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) < 0) && !(x == br1i + 1 && y == br1j) && !(x == br2i + 1 && y == br2j) && !(x == br3i + 1 && y == br3j) && !(x == br4i + 1 && y == br4j)){
								if(!(v + 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x - 1][y] = g;
									x = x - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) <= abs(y - u)) && ((x - t) < (y - u)) && !(x == br1i && y == br1j + 1) && !(x == br2i && y == br2j + 1) && !(x == br3i && y == br3j + 1) && !(x == br4i && y == br4j + 1) && !(v == br4i && w == br4j + 1)){
								if(!(v == x && w + 1 == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x][y - 1] = g;
									y = y - 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
							else if((abs(x - t) >= abs(y - u)) && ((x - t) <= (y - u)) && ((x - t) != -(y - u)) && !(((x - t) == (y - u)) && (x - t) > 0) && !(x == br1i - 1 && y == br1j) && !(x == br2i - 1 && y == br2j) && !(x == br3i - 1 && y == br3j) && !(x == br4i - 1 && y == br4j)){
								if(!(v - 1 == x && w == y && e3.getHp() > 0)){
									char g = getMap()[x][y];
									if((x == i1i && y == i1j && co1 == 0) || (x == i2i && y == i2j && co2 == 0) || (x == i3i && y == i3j && co3 == 0) || (x == i4i && y == i4j && co4 == 0) || (x == i5i && y == i5j && co5 == 0)){
										getMap()[x][y] = e;
									}
									else if(x == upi && y == upj){
										getMap()[x][y] = f;
									}
									else{
										getMap()[x][y] = c;
									}
									getMap()[x + 1][y] = g;
									x = x + 1;
									if((u == y - 1 && t == x) ||(u == y && t == x + 1) || (u == y + 1 && t == x) ||(u == y && t == x - 1)){
										this.fight(p, e4, i1, i2, i3, i4, i5);
										if(e4.getHp() <= 0){
											getMap()[x][y] = c;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(k == 5){
			p.refresh1(ea, i1, i2, i3, i4, i5, e3, e4, b1f);
			p.action1(this, ea, p, e3, e4, i1, i2, i3, i4, i5);
			System.out.println(p.getName() +" 体力" + p.getHp() + " 最大体力" + p.maxHp + " 攻撃力" + p.getAtk() + " 防御力" + p.getDef() + " 取得経験値" + p.getExp());
			System.out.println("持ち物  " + p.getBag1() + i1.getBi() + " " + p.getBag2() + i2.getBi());
			System.out.println("状態異常  " + p.getState().condition());
		}
	}
}
