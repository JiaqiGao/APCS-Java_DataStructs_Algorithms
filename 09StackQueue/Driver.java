import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
	MyQueue<String> testq = new MyQueue<String>();
	Queue<String> origq = new LinkedList<String>();

	MyStack<String> tests = new MyStack<String>();
	Stack<String> origs = new Stack<String>();

	for(int i = 0; i < 10; i++){
            testq.enqueue(""+i);
            origq.add(""+i);
        }

	for(int i = 0; i < 10; i++){
            tests.push(""+i);
            origs.add(""+i);
        }
	
	System.out.println("testing MyQueue");
	System.out.println(testq.toString(true));
        System.out.println(origq);

	System.out.println("testing MyStack");
	System.out.println(tests.toString(true));
        System.out.println(origs);

    }
    
}
