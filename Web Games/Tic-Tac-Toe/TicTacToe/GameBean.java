package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class GameBean {

    List<GameEntry> slots;
    public static int player = 0;
    public static String currentPlayer = "Player X's turn";
    public static Boolean isGameOver = false;
    public static Boolean isValidMove;
    public static String gameWinner;

    public GameBean(){
        slots = new ArrayList<GameEntry>();
    }
    
    public List<GameEntry> getSlots(){
        return slots;
    }
    
    public String PlayerTurn(){
    	if(player == 1) {
    		player=0;
    		currentPlayer = "Player X's turn";
    		return "playerX";
    	}
    	else {
    		player=1;
    		currentPlayer = "Player O's turn";
    		return "playerO";
    	}
    }
    
    public void setEntries( List<GameEntry> slots){
        this.slots = slots;
    }
    
    public String getPlayer() {
    	return currentPlayer;
    }
    
    public void isGameOver(boolean game){
    	isGameOver = game;
    }
    
    public boolean isGameOver() {
    	return isGameOver;
    }
    
    public GameEntry getLastEntry(){
        return slots.get( slots.size() - 1 );
    }

    public void isValidMove(Boolean valid){
    		isValidMove = valid;
    	}

    public void setWinner(String winner) {
    	gameWinner = winner;
    }
    
    public String getWinner(){
    	
    	if (gameWinner == "X") {
    		return "Player X has won the game!";
    	}
    	else if(gameWinner == "draw") {
    		return "It's  a draw!";
    	}
    	else{
    		return "Player O has won the game!";
    	}
    }

}