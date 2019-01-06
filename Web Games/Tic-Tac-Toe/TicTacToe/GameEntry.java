package TicTacToe;

public class GameEntry {
		
		static int count = 0;
		
		int position;
		String token;
		boolean press;

		
		public GameEntry(int position, String token, boolean press) {
			super();
			this.position = position;
			this.token = token;
			this.press = press;
		}
		
		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public int getPosition() {
			return position;
		}
		
		public boolean getPress() {
			return press;
		}
		
		public void setPress(Boolean press) {
			this.press = press;
		}

	}