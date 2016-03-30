package ADT;

/**
* Comp 2071
* Lab 03: Queues
* Due: February 23rd, 2016
* Group #: 15
*
* Test class for queue
* 
* @author Jake Mathews
* @author Ford Polia
* @author Darrien Kennedy
*/

public class QueueTest<T> {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]){
		@SuppressWarnings("rawtypes")
		Queue test = new Queue();
	
		test.enqueue("first");
		test.enqueue("second");
		test.enqueue("third");
		
		System.out.println("The getFront method returns: " + test.getFront());
		
		test.dequeue();
		
		System.out.println("The getFront method returns: " + test.getFront());
		
		System.out.print("Is the queue empty?  ");
		if(test.isEmpty()){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
		System.out.println("clear the queue");
		test.clear();
		
		System.out.print("Is the queue empty?  ");
		if(test.isEmpty()){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
	}
}
