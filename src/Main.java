public class Main {
	public static void main(String[] args){
		System.out.println("このゲームでは、指示に従って主人公を操作してもらいます");
		System.out.println("その階の敵をすべて倒し、￥のマークのところに進むと下の階へ降りることができます");
		System.out.println("＠のところにはアイテムがあります");
		System.out.println("ブロックは＊で表され、ここは通れません");
		System.out.println("何もないところにも仕掛けが隠されている場合があるので注意してください");
		System.out.println("きずぐすりは体力を10回復、いいきずぐすりは体力を20回復します");
		System.out.println("どくけしはどく状態をなおし、まひなおしはまひ状態をなおします");
		System.out.println("レーザー銃は遠くにいる敵を攻撃します");
		System.out.println("レーザー銃はブロックを貫通します");
		System.out.println("主人公の体力が0になったらGame Overです");
		System.out.println("Game Clearの条件はゲームを進めるとわかります");
		System.out.println("敵を倒してどんどん下の階へ進んでいってください");
		System.out.println("それではゲームスタートです");
		System.out.println("");
		
		System.out.println("名前を入力してください。");
		String nm = new java.util.Scanner(System.in).nextLine();
		
		Enemy e1 = new Enemy("炎の鳥", '鳥', 20, 5, 2, 10, 20);
		Enemy e2 = new Enemy("ウォーターウルフ", '狼', 40, 8, 4, 30, 40);
		Enemy e3 = new Enemy("雷獅子", '獅', 40, 10, 5, 50, 40);
		Enemy e4 = new Enemy("エレクトリックドラゴン", '龍', 100, 12, 7, 70, 50);
		Enemy note = new Enemy("謎の男", '男', 0, 0, 0, 0, 0);
		Enemy ef = new Enemy("魔王", '魔', 150, 20, 10, 100, 100);
		Item i1 = new Item("きずぐすり", '＠', 10, 0);
		Item i2 = new Item("いいきずぐすり", '＠', 20, 0);
		Item i3 = new Item("どくけし", '＠', 0, 0);
		Item i4 = new Item("まひなおし", '＠', 0, 0);
		Item i5 = new Item("レーザー銃", '＠', 0, 0);
		Sword s = new Sword("炎の剣", 5);
		Armour a = new Armour("くさりかたびら", 5);
		State st = new State(0);
		Player p = new Player(nm, '私', 100, 20, 5, 0, 100, i1.getName() + " ✖", i2.getName() + " ✖", i3.getName() + " ✖", i4.getName() + " ✖", i5.getName() + " ✖");//name suf hp atk def exp maxHp
		p.setState(st);
		p.setArmour(a);
		p.setSword(s);
		Board b = new Board(p, e1, e2, i1, i2);
		BoardUg1F b1f = new BoardUg1F(p, e3, e4, i1, i2, i3, i4, i5);
		BoardUg2F b2f = new BoardUg2F(p, note, i1, i2, i3, i4, i5);
		BoardUg3F b3f = new BoardUg3F(p, ef, i1, i2, i3, i4, i5);
		
		while(p.getHp() > 0 && ((e1.getHp() > 0) || (e2.getHp() > 0) ||  p.getSuf() != b.getMap()[b.s - 2][b.s - 2])){
			b.printBoard(p, i1, i2, i3, i4, i5);
			p.action(b, e1, p, e1, e2, i1, i2, i3, i4, i5, b1f);
			b.appear(e1, e2);
			//b.downstairs(p, e1, e2, i1, i2, i3, i4, i5, b1f);
		}
		while(p.getHp() > 0 && ((e3.getHp() > 0) || (e4.getHp() > 0) ||  p.getSuf() != b1f.getMap()[b1f.s - 2][b1f.s - 2])){
			b1f.printBoard(p, i1, i2, i3, i4, i5);
			p.action1(b1f, e3, p, e3, e4, i1, i2, i3, i4, i5);
			b1f.appear(e3, e4);
			//b1f.downstairs(p, e1, e2, i1, i2, i3, i4, i5, b2f);
		}
		while(p.getHp() > 0  && !(p.getSuf() == b2f.getMap()[b2f.s - 2][b2f.s1 - 2] && b2f.conote == 1)){
			b2f.printBoard(p, i1, i2, i3, i4, i5);
			p.action2(b2f, note, p, i1, i2, i3, i4, i5);
			//b2f.downstairs(p, i1, i2, i3, i4, i5, b3f);
		}
		while(p.getHp() > 0 && (ef.getHp() > 0)){
			b3f.printBoard(p, i1, i2, i3, i4, i5);
			p.action3(b3f, ef, p, i1, i2, i3, i4, i5);
		}
		if(p.getHp() == 0){
			System.out.println(p.getName() + "は倒れた！");
			System.out.println(p.getName() + "は目の前が真っ暗になった！");
			System.out.println("Game Over!");
		}
		if((p.getHp() > 0) && (ef.getHp() == 0)){
			System.out.println("すべての敵を倒した！");
			System.out.println("Game Clear!");
		}
	}
}
