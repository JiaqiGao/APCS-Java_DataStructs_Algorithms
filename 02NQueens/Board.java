public class Board{
    int n=5;
    int column = 0;
    int[][] board = new int[n][n];

    
    public boolean solve(){
       return addQueen();
    }

    public void printBoard(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j]);
                if(j<n-1){
                    if(board[i][j+1]<0){
                        System.out.print(" ");
                    }else{
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean addQueen(){
        for(int row=0; row<n; row++){
            if(board[row][column] == 0){
                board[row][column] = 1;
                if(column != n-1){
                    for(int i=column+1; i<n; i++){
                        board[row][i]--;
                    }
                    // loseOptions(row,column);
                }
                
                return true;
            }
        }
        return false; 
    
    }

    public void loseOptions(int r, int c){
        int rr=r;
        int cc=c;
        while(rr>0){
            board[rr-1][cc+1]--;
            rr--;
            cc++;
        }
        rr=r;
        cc=c;
        while(rr<n){
            board[rr+1][cc+1]--;
            rr++;
            cc++;
        }
        
        
    }

    
    
    public void removeQueen(){
    }
    public static void main(String[]arggs){
        Board b = new Board();
        System.out.println(b.solve());
        b.printBoard();
    }
}
