package ADT;

public class Queue<T>{
	private Node<T> firstNode = null;
	private Node<T> lastNode = null;
	
	public Queue(){
		firstNode = null;
		lastNode = null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void enqueue(T anEntry){
		Node newNode = new Node(anEntry, null, null);
		
		if(isEmpty()){
			firstNode = newNode;
		}else{
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
	}
	
	public T dequeue(){
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		
		if(firstNode == null){
			lastNode = null;
		}
		
		return front;
	}
	
	public T getFront(){
		if(isEmpty()){
			throw new EmptyQueueException("No elements in the Queue.");
		}else{
			return firstNode.getData();
		}
	}
	
	public boolean isEmpty(){
		if(firstNode == null && lastNode == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void clear(){
		firstNode = null;
		lastNode = null;
	}
}