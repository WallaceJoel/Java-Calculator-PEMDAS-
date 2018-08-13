
public class Cards {
	
     int value; // , -2 is a pick 2, 0 is a skip
	 int color;
	
	public Cards(int color, int value) {
		if(color < 0 || color > 4) {
		throw new IllegalArgumentException("Error on color, red is 1, blue is 2, green is 3, yellow is 4, black is 0");
		
		}
	    this.color = color;
	    if(value <-3 || value > 10) {
	    	 throw new IllegalArgumentException("Error on value, use 1-9, 0 for skip, -2 for pick 2, -1 for reverse");
	    }
	    this.value = value;
	}
	
	public int getCardValue() {
		if(value == -3) {
			System.out.print("A skip card:  ");
		}
		if(value == -1) {
			System.out.print("A reverse card:  ");
		}
		if(value == -2) {
			System.out.print("A pick 2 card:  ");
		}
		
		return this.value;
	}
	public String getCardColor() {
		
			if(color == 1) {
				return "red";
			}
			if(color == 2) {
				return "blue";
			}
			if(color == 3) {
				return "green";
			}
			if(color == 4) {
				return "yellow";
			}
			if(color == 0) {
				return "black";
			}
			return "UNO";
	}
		
		
	
	
	
	
	

}

