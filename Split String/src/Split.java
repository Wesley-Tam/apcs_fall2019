//Wesley Tam
//October 21, 2019
//This code splits a string to return the elements between two specific elements

import java.util.*;

public class Split {
	public static void main(String[] args) {
		// Your task Part 0
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" ");
		// it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples!".split("really")
		// it will split at the word "really" and return an array of ["I "," like ","red apples!"]
		//play around with String.split!
		//What happens if you "I reallyreally likeapples".split("really") ?
		String[] example1 = "I like apples".split(" ");
		System.out.println(Arrays.toString(example1));
		String[] example2 = "I really like really red apples!".split("really");
		System.out.println(Arrays.toString(example2));
		String[] example3 = "I reallyreally likeapples".split("really");
		System.out.println(Arrays.toString(example3));
		System.out.println(sandwich1("applespineapplesbreadlettucetomatobreadbaconmayohambreadcheese"));
		//sandwich1("applespineapplesbreadlettucetomatobaconmayohambreadcheese");
		System.out.println(sandwich2("apples pineapples bread lettuce tomato bacon mayo ham bread cheese"));
	}

	public static String sandwich1(String contents) {
		//Your task Part 1:
		//Write a method that take in a string like
		//"applespineapplesbreadlettucetomatobaconmayohambreadcheese"
		//describing a sandwich.
		//Use String.split to split up the sandwich by the word "bread" and return what's in the middle
		//of the sandwich and ignores what's on the outside
		//What if it's a fancy sandwich with multiple pieces of bread?
		int firstBread = -2;
		int lastBread = -2;
		String ingredients = "";
		for (int i = 0; i < contents.length() - 4; i++) {
			if ((contents.substring(i, i + 5)).equals("bread")) {
				lastBread = i;
			}
		}
		for (int i = contents.length(); i >= 5; i--) {
			if ((contents.substring(i - 5, i).contentEquals("bread"))) {
				firstBread = i;
			}
		}
		if ((firstBread - 5) == lastBread) {
			ingredients = "Not a sandwich";
		} else {
			ingredients = contents.substring(firstBread, lastBread);
		}
		System.out.println(firstBread); //l of lettuce
		System.out.println(lastBread);  //b of bread
		return ingredients;
	}

	public static String sandwich2(String contents) {
		//Your task pt 2:
		//Write a method that take in a string like
		//"apples pineapples bread lettuce tomato bacon mayo ham bread cheese"
		//describing a sandwich
		//use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of
		//the sandwich and ignores what's on the outside.
		//Again, what if it's a fancy sandwich with multiple pieces of bread?
		String[] sandwich2 = contents.split(" ");
		int firstBread = -2;
		int lastBread = -2;
		String answer = "";
		for (int i = 0; i < sandwich2.length; i++) {
			if (sandwich2[i].equals("bread")) {
				lastBread = i;
			}
		}
		for (int i = sandwich2.length - 1; i >= 0; i--) {
			if (sandwich2[i].contentEquals("bread")) {
				firstBread = i;
			}
		}
		for (int i = firstBread + 1; i < lastBread; i++) {
			answer += sandwich2[i] + "  ";
		}
		if (firstBread == lastBread) {
			answer = "Not a sandwich";
		}
		return answer;
	}
}