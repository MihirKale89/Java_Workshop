class Parent{
Parent(){System.out.println(" I am Parent ");}
}
class Child extends Parent{
	Child(){System.out.println(" I am Child ");}
	
}
public class ParentChildTest{
	public static void main(String args[]){
		Parent parent1 = new Child();
		Parent parent2 = new Parent();
		Child child = new Parent(); // Generates error as Child object is having Parent reference		
		
	}
}