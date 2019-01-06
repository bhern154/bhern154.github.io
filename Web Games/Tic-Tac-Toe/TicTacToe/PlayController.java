package TicTacToe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlayController")
public class PlayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ArrayList = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int position = Integer.parseInt(request.getParameter("position"));
			ArrayList<GameEntry> gameEntries = (ArrayList<GameEntry>) getServletContext().getAttribute("slots");
			GameBean player = new GameBean();
			player.setEntries(gameEntries);
			
			for (GameEntry entry : gameEntries) {
				if (entry.getPosition() == position) {
					if(player.PlayerTurn() == "playerX") {
						entry.setPress(true);
						entry.setToken("O");
					}
					else {
						entry.setPress(true);
						entry.setToken("X");
					}
					//gameEntries.remove( entry );
					break;
				}
			}
			
			//All Full (Draw)
			if(gameEntries.get(1-1).getPress() == true && gameEntries.get(2-1).getPress() == true && 
					gameEntries.get(3-1).getPress() == true && gameEntries.get(4-1).getPress() == true && 
					gameEntries.get(5-1).getPress() == true && gameEntries.get(6-1).getPress() == true &&
					gameEntries.get(7-1).getPress() == true && gameEntries.get(8-1).getPress() == true &&
					gameEntries.get(9-1).getPress() == true) {
				player.setWinner("draw");
				player.isGameOver(true);
			}
			
			//1, 2, 3
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "X") && 
					(gameEntries.get(2-1).getPress() == true && gameEntries.get(2-1).getToken() == "X") && 
					(gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "O") && 
					(gameEntries.get(2-1).getPress() == true && gameEntries.get(2-1).getToken() == "O") && 
					(gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//1, 4, 7
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "X") && 
					(gameEntries.get(4-1).getPress() == true && gameEntries.get(4-1).getToken() == "X") && 
					(gameEntries.get(7-1).getPress() == true && gameEntries.get(7-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "O") && 
					(gameEntries.get(4-1).getPress() == true && gameEntries.get(4-1).getToken() == "O") && 
					(gameEntries.get(7-1).getPress() == true && gameEntries.get(7-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//1, 5, 9
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "X") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "X") && 
					(gameEntries.get(9-1).getPress() == true && gameEntries.get(9-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(1-1).getPress() == true && gameEntries.get(1-1).getToken() == "O") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "O") && 
					(gameEntries.get(9-1).getPress() == true && gameEntries.get(9-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//2, 5, 8
			if((gameEntries.get(2-1).getPress() == true && gameEntries.get(2-1).getToken() == "X") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "X") && 
					(gameEntries.get(8-1).getPress() == true && gameEntries.get(8-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(2-1).getPress() == true && gameEntries.get(2-1).getToken() == "O") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "O") && 
					(gameEntries.get(8-1).getPress() == true && gameEntries.get(8-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//4, 5, 6
			if((gameEntries.get(4-1).getPress() == true && gameEntries.get(4-1).getToken() == "X") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "X") && 
					(gameEntries.get(6-1).getPress() == true && gameEntries.get(6-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(4-1).getPress() == true && gameEntries.get(4-1).getToken() == "O") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "O") && 
					(gameEntries.get(6-1).getPress() == true && gameEntries.get(6-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//3, 5, 7
			if((gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "X") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "X") && 
					(gameEntries.get(7-1).getPress() == true && gameEntries.get(7-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "O") && 
					(gameEntries.get(5-1).getPress() == true && gameEntries.get(5-1).getToken() == "O") && 
					(gameEntries.get(7-1).getPress() == true && gameEntries.get(7-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
			//3, 6, 9
			if((gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "X") && 
					(gameEntries.get(6-1).getPress() == true && gameEntries.get(6-1).getToken() == "X") && 
					(gameEntries.get(9-1).getPress() == true && gameEntries.get(9-1).getToken() == "X")) {
				player.setWinner("X");
				player.isGameOver(true);
			}
			
			if((gameEntries.get(3-1).getPress() == true && gameEntries.get(3-1).getToken() == "O") && 
					(gameEntries.get(6-1).getPress() == true && gameEntries.get(6-1).getToken() == "O") && 
					(gameEntries.get(9-1).getPress() == true && gameEntries.get(9-1).getToken() == "O")) {
				player.setWinner("O");
				player.isGameOver(true);
			}
			
		}catch(Exception e) {}
		
		response.sendRedirect("GameController");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
