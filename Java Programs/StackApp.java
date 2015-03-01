// stack.java
// demonstrates stacks
// to run this program: C>java StackApp

class StackX
{
	private int maxSize; // size of stack array
	private long[] stackArray;
	private int top; // top of stack
//--------------------------------------------------------------
public StackX(int s) // constructor
{
	maxSize = s; // set array size
	stackArray = new long[maxSize]; // create array
	top = -1; // no items yet
}
//--------------------------------------------------------------
public void push(long j) // put item on top of stack
{
	if( !isFull() )
	stackArray[++top] = j; // increment top, insert item
	else
	System.out.print("Cannot insert, stack is full\n");
}

//--------------------------------------------------------------
public void pop() // take item from top of stack
{
	if( !isEmpty() )
		System.out.print("" + stackArray[top--] + "\t"); // access item, decrement top
	else
	System.out.println("Cannot delete, stack is empty\n");
}
//--------------------------------------------------------------
public long peek() // peek at top of stack
{
	return stackArray[top];
}
//--------------------------------------------------------------
public void displayStack(){
	int count=0;
	while(count <= top) System.out.print("" + stackArray[count++] + "\t");
}
//--------------------------------------------------------------
public boolean isEmpty() // true if stack is empty
{
return (top == -1);
}

public boolean isFull() // true if stack is full
{
	return (top == maxSize-1);
}

} // end class StackX

class StackApp
{
	public static void main(String[] args)
	{
		StackX theStack = new StackX(10); // make new stack
		theStack.push(20); // push items onto stack
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		theStack.push(10);
		theStack.push(30);
		theStack.push(70);
		theStack.push(90);
		theStack.push(50); 
		theStack.push(44);
		theStack.push(66);
		theStack.push(81);

		System.out.println("\n Displaying the stack :- \n ");
		theStack.displayStack();
		System.out.println("\n Now stack will be emptied :- \n ");
		while( !theStack.isEmpty() ) // until it’s empty,
		{ 	// delete item from stack
			//long value = theStack.pop();
			//System.out.print(value); // display it
			theStack.pop();
			System.out.print(" ");
		} // end while
		System.out.println("\n Stack emptied! ");
		System.out.println("\n Checking if stack is empty ");
		theStack.displayStack();
	} // end main()
} // end class StackApp
