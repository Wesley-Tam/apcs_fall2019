//Wesley Tam
//APCS Period 3
//August 29, 2019
//This class will call the code form the Calculate class (a.k.a client or runner code)

public class DoMath {
	public static void main(String[] args) {
		System.out.println(Calculate.square(2));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average (2, 10, 10));
		System.out.println(Calculate.toDegrees(2));
		System.out.println(Calculate.discriminant(2, 2, 2));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "x"));
		System.out.println(Calculate.isDivisibleBy(0, 2));
		System.out.println(Calculate.absValue(-5));
		System.out.println(Calculate.max(-1, -5, 1000));
		System.out.println(Calculate.min(4, -1));
		System.out.println(Calculate.round2(5.1));
		System.out.println(Calculate.exponent(0, 0));
		System.out.println(Calculate.factorial(3));
		System.out.println(Calculate.isPrime(19));
		System.out.println(Calculate.gcf(45, 6));
		System.out.println(Calculate.sqrt(121));
		System.out.println(Calculate.quadForm(1, -6, 9));
	}
}