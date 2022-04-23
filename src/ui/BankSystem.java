package ui;
import model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BankSystem {
	
	private BufferedReader br; 
	private BankController bc;
	
	public BankSystem() {
		br= new BufferedReader(new InputStreamReader(System.in));
		bc = new BankController();
	}
	
	public static void main(String[] args) {
		BankSystem bs = new BankSystem();
		
		System.out.println("=========================");
		System.out.println("       Welcome :)       ");
		System.out.println("\n");
		
		int answer = 0;
		do {
			answer = bs.menuOption();
			bs.menu(answer);
		}while(answer!=5);
		
		
		
	}
	
	public void menu(int option) {
		switch(option) {
		case 1:
			registerTurnToList();
			System.out.println("");
			break;
		case 2:
			showCurrentTurn();
			System.out.println("");
			break;
		case 3:
			System.out.println("Hola 3");
			break;
		case 4:
			System.out.println("Hola 4");
			break;
		case 5:
			System.out.println("Successfull exit");
			break; 
		}
	}
	
	public int menuOption() {
		
		int option = 0; 
		boolean flag = false; 
		System.out.println("What do you want to do?\n"+
						"(1) Give turn\n"+
						"(2) Show turn\n"+
						"(3) Pass turn\n"+
						"(4) Delete current turn\n"+
						"(5) Exit \n");
			do {
				try {
					do {
						option=Integer.parseInt(br.readLine());
					}while(option<1||option>5);
					flag = true;
				} catch (Exception e) {
					System.out.println("Invalid data, try again");
					flag=false;
				}
			}while(!flag); 
			
			return option; 
	}
	
	public void registerTurnToList() {
		bc.addTurnToList();
	}
	
	public void showCurrentTurn() {
		System.out.println(bc.currentTurnMessage());
	}
	
}
