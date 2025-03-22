
public class funny {
	
	public static void main(String[] args) {
		
		Jail jail = new Jail();
		Diddy diddy = new Diddy();
		jail.free(diddy);
		
	}
	
	static class Jail {
		public void free(Person name) {
			
		}
	}
	static class Diddy extends Person {
		
	}
	static class Person {
		
	}

}
