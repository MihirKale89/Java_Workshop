class StringTester{
	public static void main(String args[]){
		String s1 = "Hello";
		String s2 = "World";
		System.out.println(" Checking equality 1 "+(s1 == s2));
		String str1 = new String("Hello");
		String str2 = new String("World");
		boolean b = str1.equals(str2);
		System.out.println(" Checking equality 2 "+b);
		b = (str1 == str2);
		System.out.println(" Checking equality 3 "+b);
		int num1 = 5;
		int num2 = 10;
		int num3 = num1 + num2--;
		System.out.println(" Checking num 3 : "+num3); // displays 14 
		System.out.println(" Checking num 2 : "+num2); // displays 9
	}
}