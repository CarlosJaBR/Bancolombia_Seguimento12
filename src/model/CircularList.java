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
			Node aux = head; 
			if(head==currentTurn&&last==currentTurn) {
				head = null;
				last = null;
				currentTurn = null; 
				return true;
			}else if(currentTurn==head) {
				head = aux.getNext();
				aux.getNext().setPrev(last);
				aux.getPrev().setPrev(aux.getNext());
				return true;
			}else if(currentTurn==last) {
				aux= last;
				last = aux.getPrev();
				aux.getPrev().setNext(head);
				aux.getNext().setPrev(last);
				return true;
			}else {
				aux=currentTurn;
				aux.getPrev().setNext(aux.getNext());
				aux.getNext().setPrev(aux.getPrev());
				currentTurn=aux.getNext();
				aux=null;
				return true;
			}
		}
	}
	
	
	public boolean passTurn() {
		
		if(head==null) {
			return false;
		}else { 
			return true;
				
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
