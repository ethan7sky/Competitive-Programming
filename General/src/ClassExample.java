
public class ClassExample {
	
	public static void main(String[] args) {
		
		Car ferrari = new Car();
		Car lambo = new Car();
		System.out.println(ferrari.numberOfSeats);
		System.out.println(lambo.numberOfSeats);
	}
	
	static class Car {
		int numberOfSeats = 10;
	}
}
