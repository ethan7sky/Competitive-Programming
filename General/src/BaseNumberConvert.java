

public class BaseNumberConvert {
	
	
	public static void main(String[] args) {

		System.out.println(Integer.toHexString(10));
		System.out.println(Integer.toOctalString(10));
		System.out.println(Integer.toBinaryString(10));

		System.out.println(Integer.parseInt("1010", 2));
		System.out.println(Integer.parseInt("12", 8));
		System.out.println(Integer.parseInt("A", 16));
		
		System.out.println(Integer.toString(10, 3));
		
		String oct_hex = Integer.toString(Integer.parseInt("17", 8), 16);
		System.out.println(oct_hex);
		
	}
}
