//Wesley Tam
//APCS Period 3
//August 29, 2019
//This class will call the code form the Calculate class (a.k.a client or runner code)

public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.average (2, 10, 10));
		System.out.println(Calculate.toDegrees(2));
		System.out.println(Calculate.discriminant(2, 2, 2));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "x"));
	}
}