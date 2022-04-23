package model;

public class BankController {
	private CircularList listTurn;
	private int nTurn;
	
	public BankController() {
		listTurn = new CircularList();
		nTurn = 0; 
	}
	
	public void addTurnToList() {
		nTurn++;
		listTurn.addTurn(nTurn);
	}
	
	public String currentTurnMessage() {
		return listTurn.turn();
	}
	
	
}
