package model;

public class CircularList {
	
	private Node head; 
	private Node currentTurn; 
	private Node last; 
	
	public CircularList() {
		
	}
	/*
	 * Método add.
	 * Agrega elemento a la cabeza si está vacío. En caso contrario reajusta todas las configuraciones.
	 */
	public void addTurn(int value) {
		Node auxNode = new Node(value);
		
		if(head==null) {
			head = auxNode; 
			currentTurn = auxNode; 
			last = head;
			head.setNext(last);
			head.setPrev(last);
			last.setNext(head);
			last.setPrev(head);
			
		} else {
			auxNode.setPrev(last);
			last.setNext(auxNode);
			last = auxNode;
			last.setNext(head);
			head.setPrev(last);
		}
	}
	
	
	public boolean dTurn() { 
		
		if(head == null) {
			return false;
		}else {
			Node aux = currentTurn; 
			//Node aux = head;
			if(aux==head&&last==aux) {
				head = null;
				last = null;
				currentTurn = null; 
				return true;
			}else if(aux==head) {
				aux = head;
				head = aux.getNext();
				aux.getNext().setPrev(last);
				aux.getPrev().setNext(aux.getNext());
				currentTurn = head;
				return true;
			}else if(aux==last) {
				aux= last;
				last = aux.getPrev();
				aux.getPrev().setNext(head);
				aux.getNext().setPrev(last);
				currentTurn = head; 
				return true;
			}else {
				aux=currentTurn;
				aux.getPrev().setNext(aux.getNext());
				aux.getNext().setPrev(aux.getPrev());
				currentTurn=currentTurn.getNext();
				return true;
			}
		}
	}
	
	
	public void passTurn() {
		
		if(head!=null) {
			
			
			Node aux = currentTurn;
			aux.setNext(currentTurn.getNext());
			aux.setPrev(currentTurn.getPrev());
			currentTurn=currentTurn.getNext();
			
		}

	}
	
	public String turn() { 
		if(head==null) {
			return "No turns added";
		}else {
			return "["+currentTurn.turnNode()+"]";
		}
	}
	
	public String toString() {
		
		String ans = "[]";

		if (head != null) {
			ans = "[";
			Node temp = head;
			while (temp.getNext() != head) {
				ans += temp.getValue() + ", ";
				temp = temp.getNext();
			}
			ans += temp.getValue() + "]";

		}

		return ans;
	}
	
	public String recursivo() {
		if(head==null) {
			return "[]";
		}else {
			return "["+head.recursive(head)+"]";
		}
	}
}
