package tictactoe;

import java.util.Scanner;

public class TicTacToe {
	private Player player1,player2;
	private Board board;
	private int numPlayers=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	public void startGame() {
		//take players input
		Scanner scan=new Scanner(System.in);
		Player p1=takePlayerInput(++numPlayers);
		Player p2=takePlayerInput(++numPlayers);
		while(p1.getSymbol()==p2.getSymbol()) {
			System.out.println("Symbol already taken!! Please enter the symbol again");
			p2.setSymbol(scan.next().charAt(0));
		}
		//create the board
		
		Board board=new Board(p1.getSymbol(),p2.getSymbol());
		//play the game
		boolean player1Turn=true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALIDMOVE) {
			if(player1Turn) {
				System.out.println("Player1 "+ p1.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x=scan.nextInt();
				System.out.println("Enter y: ");
				int y=scan.nextInt();
				status=board.move(p1.getSymbol(),x,y);
				if(status==Board.INVALIDMOVE) {
					System.out.println("Invalid move!! Please try again!! ");
					continue;
				}
				
				
			}else {
				System.out.println("Player2 "+ p2.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x=scan.nextInt();
				System.out.println("Enter y: ");
				int y=scan.nextInt();
				status=board.move(p2.getSymbol(),x,y);
				if(status==Board.INVALIDMOVE) {
					System.out.println("Invalid move!! Please try again!! ");
					continue;
				}
			}
			player1Turn=!player1Turn;
			board.print();
		}
		
		if(status==Board.PLAYER1WIN) {
			System.out.println("Hurray! "+p1.getName()+" Win the game");
		}
		else if(status==Board.PLAYER2WIN) {
			System.out.println("Hurray! "+p2.getName()+" Win the game");
		}
		else {
			System.out.println("Draw the match!!");
		}
		
	}
	public Player takePlayerInput(int num) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Player"+num+" Name");
		String pName=scan.next();
		System.out.println("Enter Player"+num+" Symbol");
		char pSymbol=scan.next().charAt(0);
		
		Player p=new Player(pName, pSymbol);
		return p;
	}
}
