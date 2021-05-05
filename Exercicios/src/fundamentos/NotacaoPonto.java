package fundamentos;

public class NotacaoPonto {
	
	public static void main(String[] args) {
		String s ="Bom dia X";
		
		s = s.replace("X"," Hussyvel");
		s = s.concat(" Tudo bem???");
	
		s = s.toUpperCase();
		
		System.out.println(s);
	
		s = s.toLowerCase();
		
		System.out.println(s);
	}
}
