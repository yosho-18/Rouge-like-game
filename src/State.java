public class State {
	private int ill;
	State(int ill){
		this.setIll(ill);
	}
	
	public void setIll(int ill){
		this.ill = ill;
	}
	public int getIll(){
		return this.ill;
	}
	public String condition(){
		if(getIll() == 1){
			return "どく";
		}
		if(getIll() == 2){
			return "まひ";
		}
		if(getIll() == 3){
			return "どく、まひ";
		}
		return "なし";
	}
}

