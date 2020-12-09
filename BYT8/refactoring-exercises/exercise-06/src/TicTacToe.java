public class TicTacToe {
	public StringBuffer board;

	public TicTacToe(String s) {
		board = new StringBuffer(s);
	}

	public TicTacToe(String s, int position, char player) {
		board = new StringBuffer(s);
		board.setCharAt(position, player);
	}

	public int suggestMove(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				TicTacToe game = makeMove(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-')
				return i;
		}

		return -1;
	}

	public TicTacToe makeMove(int i, char player) {
		return new TicTacToe(board.toString(), i, player);
	}

	//Bad Smell: Long method - Comments
	//Refactoring Technique: Extract method
	//winner() method splitted into smaller methods

	public char winner() {

		Character horizontalWinner=checkHorizontalWinner();
		if (horizontalWinner != null) {
			return horizontalWinner;
		}

		Character verticalWinner=checkVerticalWinner();
		if (verticalWinner != null) {
			return verticalWinner;
		}

		Character diagonalWinner=checkDiagonalWinner();
		if (diagonalWinner != null) {
			return diagonalWinner;
		}
		// no winner yet
		return '-';
	}

	private Character checkDiagonalWinner() {
		if (board.charAt(0) != '-' && board.charAt(4) == board.charAt(0)
				&& board.charAt(8) == board.charAt(0)) {
			return board.charAt(0);
		}
		if (board.charAt(2) != '-' && board.charAt(4) == board.charAt(2)
				&& board.charAt(6) == board.charAt(2)) {
			return board.charAt(2);
		}
		return null;
	}

	private Character checkVerticalWinner() {
		for (int i = 0; i < 3; ++i) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 3) == board.charAt(i)
					&& board.charAt(i + 6) == board.charAt(i)) {
				return board.charAt(i);
			}
		}
		return null;
	}

	private Character checkHorizontalWinner() {
		for (int i = 0; i < 9; i += 3) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 1) == board.charAt(i)
					&& board.charAt(i + 2) == board.charAt(i)) {
				return board.charAt(i);
			}
		}
		return null;
	}
}
