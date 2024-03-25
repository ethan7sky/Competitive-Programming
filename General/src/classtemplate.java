import java.util.*;
import java.io.*;

public class classtemplate {
	
	static class template implements Comparable<template> {

		int p, m, t;
		template(int a, int b, int c){
			p = a;
			m = b;
			t = c;
		}
		
		public String toString() {
			return p+" "+m+" "+t;
		}


		@Override
		public int compareTo(classtemplate.template o) {
			// TODO Auto-generated method stub
			if(this.t == o.t) {
				return this.m-o.m;
			}
			return this.t-o.t;
		}
	}
}
