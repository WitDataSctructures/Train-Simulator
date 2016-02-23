
public class Node<T> {
	
	private Node<T> nextNode;
	private Node<T> prevNode;
	private T data;
	
	//Constructors
	public Node(){
		nextNode = null;
		prevNode = null;
		data = null;
	}
	public Node(T info, Node<T> next, Node<T> prev){
		nextNode = next;
		prevNode = prev;
		data = info;
	}
	
	//Setters
	public void setNextNode(Node<T> next){
		this.nextNode = next;
	}
	public void setPrevNode(Node<T> prev){
		this.nextNode = prev;
	}
	public void setData(T info){
		this.data = info;
	}
	
	//Getters
	public Node<T> getNextNode(){
		return nextNode;
	}
	public Node<T> getPrevNode(){
		return prevNode;
	}
	public T getData(){
		return data;
	}
}
