import java.util.ArrayList;
import java.util.Scanner;

public class Front {

	public static String equation(){
		Scanner equation = new Scanner(System.in);
		String express = equation.nextLine();
		return express;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter your expression" + " only use numbers and math symbols (*, +, -, /, (, ) ");
	String express = equation();
	System.out.println(express);
	
	ArrayList<Float> equ = new ArrayList<Float>();
	ArrayList<Character> sym = new ArrayList<Character>();
	while(express.contains("(")) {
		express = solve.para(express);
	}
	System.out.println(express);
	

	solve.Seperate(equ, sym, express);
	solve.Expo(equ, sym);
	
	System.out.println(equ);
	System.out.println(sym);
			
		
			
			if(!sym.isEmpty()) {
				solve.MA(equ, sym);
			System.out.println(equ);
			System.out.println(sym);
			}
			
	
	}
	

}
