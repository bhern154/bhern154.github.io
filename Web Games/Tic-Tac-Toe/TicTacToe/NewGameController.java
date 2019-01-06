package TicTacToe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewGameController")
public class NewGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ArrayList = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			ArrayList<GameEntry> gameEntries = (ArrayList<GameEntry>) getServletContext().getAttribute("slots");
			GameBean player = new GameBean();
			player.setEntries(gameEntries);
			
			for (GameEntry entry : gameEntries) {
				entry.setPress(false);
				entry.setToken("-");
			}
			
			player.isGameOver(false);
		
		response.sendRedirect("GameController");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
