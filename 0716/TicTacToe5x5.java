import java.util.Scanner;
public class TicTacToe5x5 {
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    
    static char[][] initializeBoard() {
        char[][] board = new char[5][5];
        
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                board[row][col] = EMPTY;
            }
        }
        
        return board;
    }
    
    /**
     * 列印棋盤，包含行列座標
     */
    static void printBoard(char[][] board) {
        System.out.println("\n  井字遊戲棋盤");
        System.out.println("  0 1 2 3 4");
        
        for (int row = 0; row < 5; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 5; col++) {
                System.out.print(board[row][col]);
                if (col < 4) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    /**
     * 放置棋子
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        // 檢查座標是否有效
        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        
        // 檢查該位置是否已被佔用
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }
    
    /**
     * 檢查是否有玩家獲勝
     */
    static char checkWinner(char[][] board) {
        // 檢查行
        for (int row = 0; row < 5; row++) {
            if (board[row][0] != EMPTY && 
                board[row][0] == board[row][1] && 
                board[row][1] == board[row][2] &&
                board[row][2] == board[row][3] && 
                board[row][3] == board[row][4]){
                return board[row][0];
            }
        }
        
        // 檢查列
        for (int col = 0; col < 5; col++) {
            if (board[0][col] != EMPTY && 
                board[0][col] == board[1][col] && 
                board[1][col] == board[2][col] &&
                board[2][col] == board[3][col] &&
                board[3][col] == board[4][col] ) {
                return board[0][col];
            }
        }
        
        // 檢查主對角線
        if (board[0][0] != EMPTY && 
            board[0][0] == board[1][1] && 
            board[1][1] == board[2][2] &&
            board[2][2] == board[3][3] &&
            board[3][3] == board[4][4]) {
            return board[0][0];
        }
        
        // 檢查反對角線
        if (board[0][4] != EMPTY && 
            board[0][4] == board[1][3] && 
            board[1][3] == board[2][2] &&
            board[2][2] == board[3][1] &&
            board[3][1] == board[4][0] ) {
            return board[0][4];
        }
        
        return EMPTY;
    }
    
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char[][] board = initializeBoard();
        
        System.out.println("=== 5x5 井字遊戲 ===");
        System.out.println("規則：在5x5棋盤上，率先連成5個的玩家獲勝");
        System.out.println("輸入格式：row col (例如：1 3)");
        
        printBoard(board);
        
        char currentPlayer = PLAYER_X;
        
        while (true) {
            System.out.printf("\n玩家 %c 的回合，請輸入座標 (row col)：", currentPlayer);
            
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                
                if (placePiece(board, row, col, currentPlayer)) {
                    printBoard(board);
                    
                    char winner = checkWinner(board);
                    if (winner != EMPTY) {
                        System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                        break;
                    } else if (isBoardFull(board)) {
                        System.out.println("\n🤝 平手！");
                        break;
                    }
                    
                    // 切換玩家
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                } else {
                    System.out.println("請重新輸入有效座標");
                }
            } catch (Exception e) {
                System.out.println("輸入格式錯誤，請輸入兩個數字");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}