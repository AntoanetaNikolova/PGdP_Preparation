public class TicTacToeProject {
    public class TicTacToe /*extends BasicBoard implements Game*/  {
        protected static int boardGroeße;
        //private BasicBoard board;
        protected static byte currentPlayer = 1;
        protected static String currentStatusGame = "RUNNING...";

        protected static int currentX, currrentY;
        protected static int[][] TicTacToeBoard;

        protected static boolean wrongInput;
        protected static boolean KITurn = false;

        protected int returnBoardGroeße(){
            return this.boardGroeße;
        }
        public void setBoardGroeße(int i){
            this.boardGroeße = i;
        }

        //Konstruktor;  KEIN VOID!!!! SONST FEHLER!!!!!!
        public TicTacToe(int groeße){
            boardGroeße = groeße;
            implementiereBoard();
        }
        public TicTacToe(){
            //for the childclass KI
        }

        public void implementiereBoard(){
            //neues Board anlegen
            TicTacToeBoard = new int[boardGroeße][boardGroeße];

            //das Board mit 0-en ausfüllen - default
            for(int i = 0; i <boardGroeße; i++){
                for(int j = 0; j < boardGroeße; j++){
                    TicTacToeBoard[i][j] = 0;
                }
            }
        }


        //ich muss die 2 schon in das Interface initialisierten Methoden
        //1. das Setzen eines bestimmten Spielers auf ein Feld realisiert
        public boolean makeMove(boolean playerOne, int x, int y) {
            currentX = x;
            currrentY = y;
            if(playerOne){
                currentPlayer = 1;
            }else{
                currentPlayer = 2;
            }

            boolean move = checkIfMoveValid(x,y);
            if(move){
                TicTacToeBoard[x][y] = currentPlayer;
                KITurn = true; //---------------------------------------------------------------------------------
                wrongInput = false;
            } else{
                wrongInput = true;
            }

            return move;
        }

        private boolean checkIfMoveValid(int x, int y){
            return x >= 0 && y>=0 && x<boardGroeße && y<boardGroeße && TicTacToeBoard[x][y] == 0;
        }




        //2. überprüft, ob es auf dem Spielfeld einen Gewinner gibt
        public GameStatus gameStatus(){
            if(checkIfWIn()){
                if(currentPlayer == 1){currentStatusGame = "PLAYER O WON!";return GameStatus.PLAYER_1_WON;}
                else if(currentPlayer == 2){currentStatusGame = "PLAYER X WON!";return GameStatus.PLAYER_2_WON;}
            }else if(checkIfAllAreaFull()){
                currentStatusGame = "DRAW!";
                return GameStatus.DRAW;
            }
            currentStatusGame = "RUNNING...";
            return GameStatus.RUNNING;
        }

        private boolean checkIfWIn(){
            boolean win = false;
            if(!wrongInput) {
                //a lot of redundancy
                if(!win){
                    //check if current row is a winning one
                    String row = "";
                    for (int i = 0; i < boardGroeße; i++) {
                        row += TicTacToeBoard[currentX][i];
                    }

                    if(row.contains("0") || (row.contains("1")&&row.contains("2"))){
                        win = false;
                    }else{
                        win = true; return true;
                    }
                }
                if(!win){
                    //check if current column is a winning one
                    String column = "";
                    for (int i = 0; i < boardGroeße; i++) {
                        column += TicTacToeBoard[i][currrentY];
                    }

                    if(column.contains("0") || (column.contains("1")&&column.contains("2"))){
                        win = false;
                    }else{
                        win = true; return true;
                    }
                }
                if(!win){
                    String diag1 = "";
                    for (int i = 0, j = 0; i < boardGroeße; i++, j++) {
                        diag1 += TicTacToeBoard[i][j];
                    }

                    if(diag1.contains("0") || (diag1.contains("1")&&diag1.contains("2"))){
                        win = false;
                    }else{
                        win = true; return true;
                    }
                }
                if(!win){
                    //check second diagonal
                    String diag2 = "";
                    for (int i = 0, j = boardGroeße-1; i < boardGroeße; i++, j--) {
                        diag2 += TicTacToeBoard[i][j];
                    }

                    if(diag2.contains("0") || (diag2.contains("1")&&diag2.contains("2"))){
                        win = false;
                    }else{
                        win = true; return true;
                    }
                }
            }
            return win;
        }
        private boolean checkIfAllAreaFull(){
            boolean full = true;

            A: for(int i = 0; i <boardGroeße; i++){
                for(int j = 0; j<boardGroeße; j++){
                    if(TicTacToeBoard[i][j] == 0){
                        full = false;
                        break A;
                    }
                }
            }
            return full;
        }

        //Überschreiben Sie die toString() Methode, die das int-Array Spielfeld
        // in sinnvoller Form als String zurückgibt,
        // sodass dieses auf der Konsole angezeigt werden kann.
        @Override
        public String toString(){
            System.out.println("TicTacToe board: ");
            String boardToDisplay = "";
            for(int i = 0; i < boardGroeße; i++){
                for(int j = 0; j < boardGroeße; j++){
                    boardToDisplay += TicTacToeBoard[i][j];
                    boardToDisplay += " ";
                }
                boardToDisplay += "\n";
            }
            return boardToDisplay;
        }

        public void gameMove(TicTacToe boardToPlay, boolean playerOne, int x, int y){
            System.out.println("A valid move? "+boardToPlay.makeMove(playerOne, x,y));
            System.out.println(boardToPlay.toString());
            System.out.println("Game status: "+ boardToPlay.gameStatus());
        }

    }

}
