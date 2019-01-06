package TicTacToe;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GameController")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<GameEntry> slots = new ArrayList<GameEntry>();
		
		slots.add(new GameEntry(1, "-", false));
		slots.add(new GameEntry(2, "-", false));
		slots.add(new GameEntry(3, "-", false));
		slots.add(new GameEntry(4, "-", false));
		slots.add(new GameEntry(5, "-", false));
		slots.add(new GameEntry(6, "-", false));
		slots.add(new GameEntry(7, "-", false));
		slots.add(new GameEntry(8, "-", false));
		slots.add(new GameEntry(9, "-", false));
		
		getServletContext().setAttribute("slots", slots);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/tictactoe/GameView.jsp" ).forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
