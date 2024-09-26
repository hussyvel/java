

class Program {
	static int id = 15;

}

class Test {
	public static void main(String []args){
	 	Program program = new Program();

		System.out.println(program.id);
		System.out.println(Program.id);
	}
}

