import java.util.*;
import java.io.*;

public class static_testing {
	
	static int fibonacci(int n) {
		if(n==0||n==1) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static int sum(int start, int end) {
		if(end > start) {
			return end + sum(start, end-1);
		}
		else {
			return end;
		}
	}
	
	public static int infiniteRecursion() {
		return infiniteRecursion();
	}
	
	public static int sum(int k) {
		if (k>0) {
			return k+ sum(k-1);
		}
		else {
			return 0;
		}
	}
	
	static {
		System.out.println("will run main now!");
	}
	
//	class Main {
//		public static void main(String[] args) {
//			System.out.println("nopes");
//			Test.increment();
//		}
//	}
	
	static int variable;
	
	public static void main(String[] args) {
		System.out.println("main");
		
		Test t1 = new Test();
		Test t2 = new Test();
		
		t1.increment();
		
		variable = 5;
		static_testing.variable = 6;
		System.out.println(variable);
		
	}
	
	static class Test{
		
		static int counter;
		nested wow;
		
		Test() {
			counter++;
			System.out.println(counter);
			wow = new nested(counter);
			
			increment();
		}

		void increment() {
			counter++;
			System.out.println("counter is "+counter);
		}
		
		class Main {
			public static void main(String[] args) { 
				
				System.out.println("test");
			}
		}
		static { //static block
			counter=100000;
		}
		
	}
	static class nested {
		
		int a;
		nested(int x){
			a = x;
			System.out.println("WOAH"+a);
		}
	}
}
