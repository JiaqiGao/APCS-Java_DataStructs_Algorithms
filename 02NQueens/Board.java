public class Board{
    int column = 0;
    int[][] board;
    int length;

    public Board(int n){
        length = n;
        board = new int[length][length];
    }
    
    public boolean solve(){
       return addQueen();
    }

    public void printBoard(){
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                System.out.print(board[i][j]);
                if(j<length-1){
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
        for(int row=0; row<length; row++){
            if(board[row][column] == 0){
                board[row][column] = 1;
                if(column != length-1){
                   
                    loseOptions(row,column,-1);
                   
                }
                
                return true;
            }
        }
        return false; 
    
    }

    public void loseOptions(int r, int c, int l){
        for(int i=c+1; i<length; i++){
                board[r][i]+=l;
        }
        
        int rcopy = r;
        for(int i=c+1; i<length; i++){
            if(rcopy>=0 && rcopy<length-r){
                rcopy++;
                board[rcopy][i]+=l;
            }
        }
        
        
        rcopy = r;
        for(int i=c+1; i<length; i++){
            if(rcopy<=length-r && rcopy>0){
                rcopy--;
                board[rcopy][i]+=l;
            }
        }
    }

    
    
    public boolean removeQueen(){
         for(int row=0; row<length; row++){
            if(board[row][column] == 1){
                board[row][column] = 0;
                if(column != 0){
                    
                    loseOptions(row,column,1);
                }
                
                return true;
            }
        }
        return false; 
    }
    
    public static void main(String[]arggs){
        Board b = new Board(7);
        System.out.println(b.solve());
        b.printBoard();
    }
}
