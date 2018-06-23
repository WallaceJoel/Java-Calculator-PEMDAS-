
import java.util.ArrayList;

public class solve {

	

	
	public static void Seperate(ArrayList<Float> equ, ArrayList<Character> sym, String express){
		String digit = "";
		for(int i = 0; i!= express.length(); i++ ) {
			if(Character.isDigit(express.charAt(i)) ||express.charAt(i) == '.') {
				digit += express.charAt(i);
			}
			if(!Character.isDigit(express.charAt(i)) && express.charAt(i) != '.' ) {
				equ.add(Float.parseFloat(digit));
				sym.add(express.charAt(i));
				digit ="";
			}
		}
		if(Character.isDigit(express.charAt(express.length() -1))) {
			equ.add(Float.parseFloat(digit));
			
		}
	while(sym.contains('-') || sym.contains('/')){
			if(sym.indexOf('-')!= -1) {
				equ.set(sym.indexOf('-')+1, (float) (0-equ.get(sym.indexOf('-')+1)));
				sym.set(sym.indexOf('-'), '+');
			}
			if(sym.indexOf('/') != -1) {
				equ.set(sym.indexOf('/')+1, (float) (1/equ.get(sym.indexOf('/')+1)));
				sym.set(sym.indexOf('/'), '*');
			}
		} 
		
	}

	public static String para(String express) {
		int open = express.lastIndexOf('(');
		int closed = express.indexOf(')', open);
		ArrayList<Float> equ = new ArrayList<Float>(); 
		ArrayList<Character> sym = new ArrayList<Character>();
		Seperate(equ,sym,express.substring(open+1,closed));
		String newexpr = "";
		if(open == 0) {
		newexpr = Float.toString(MA(equ,sym)) + express.substring(closed +1) ;
		}else {
		newexpr = express.substring(0, open) + Float.toString(MA(equ,sym)) + express.substring(closed +1) ;
		}
		return newexpr;
	}
	

	public static void Expo(ArrayList<Float> equ, ArrayList<Character> sym) {
		for(int i = sym.size() -1; i >=0 ;  i--) {
			if(sym.get(i).equals('^')) {
			equ.set(i, (float) Math.pow(equ.get(i), equ.get(i+1)));
			equ.remove(i+1);
			sym.remove(i);
			}
		}
		
	}
	
	
	public static float MA(ArrayList<Float> equ, ArrayList<Character> sym){
		while(!sym.isEmpty()) {
			if(sym.contains('*')) {
			 equ.set(sym.indexOf('*'), (float) (equ.get(sym.indexOf('*')) * equ.get(sym.indexOf('*') +1)));
			 equ.remove(sym.indexOf('*') +1);
			 sym.remove(sym.indexOf('*'));
			}else if(sym.contains('+')) {
				equ.set(sym.indexOf('+'), (float) (equ.get(sym.indexOf('+')) + equ.get(sym.indexOf('+') +1)));
				 equ.remove(sym.indexOf('+') +1);
				sym.remove(sym.indexOf('+'));
			}
		}
		return equ.get(0);
		
	}
	
}
