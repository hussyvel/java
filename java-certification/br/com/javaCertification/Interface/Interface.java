package br.com.javaCertification.Interface;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		interface Authenticable {
			final int PASSWORD_LENGTH = 8;
			
			void authenticable(String login, String password);
			
		}
		
	}

}
