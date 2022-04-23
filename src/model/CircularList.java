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
	
	public boolean deleteTurn() {
		if(head==null) {
			return false;  //check
		}else {
		
			Node temp = currentTurn;
			boolean check = false; 
			while(!check) {
				if(temp==currentTurn) {			
					if(temp==head&&temp==last) {
						head=null;
						last=null;
					}else if(temp==head){
						head=head.getNext();
						head.setNext(null);
					}else if(temp==last) {
						last=last.getPrev(); 
						last.setNext(null);
					}else {
						temp.getPrev().setNext(temp.getNext());
						temp.getNext().setPrev(temp.getPrev());
					}
					check=true;
				}else {
					temp=temp.getNext();
				}
			}
			
			
			
			
			return true;
		}
		
	}
	
	public String turn() { 
		if(head==null) {
			return "No hay turnos agregados";
		}else {
			return "["+currentTurn.turnNode()+"]";
		}
	}
}
