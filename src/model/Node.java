package model;

public class Node {
	private int value; 
	private Node prev;
	private Node next; 
	private int counter; 
	
	public Node(int value) {
		this.value = value;
		this.counter = 0; 
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public String turnNode() {
		return ""+value; 
	}
	
	public String toString() {
		String ans = value + ""; 
		
		if(next != null) {
			
			ans+= ", " + next;
		}
		return ans;
	}
	
	public String recursive(Node head) { 
		
		String ans = value + ""; 
		
		if(next != head) {
			ans+= ", " + next.recursive(head);
			
		}
		return ans;
	}
}
