package model;

public class BankController {
	private CircularList listTurn;
	private int nTurn;
	private int valueTurn;
	
	public BankController() {
		listTurn = new CircularList();
		nTurn = 0; 
		valueTurn = 0; 
	}
	
	public void addTurnToList() {
		nTurn++;
		valueTurn++;
		listTurn.addTurn(valueTurn);
	}
	
	public String currentTurnMessage() {
		return listTurn.turn();
	}
	
	public String listTurnsMessage() {
		return listTurn.toString();
	}
	
	public String listRecursiva() {
		return listTurn.recursivo();
	}
	
	public boolean deleteCurrentTurns() {
		if(listTurn.dTurn()==true) {
			nTurn--;
		}
		return listTurn.dTurn();
	}
	
	public boolean verifyNTurn() {
		return (nTurn<50)?true:false;
	}
	
	public boolean passCurrentTurn() {
		return listTurn.passTurn();
	}
	
	
}
