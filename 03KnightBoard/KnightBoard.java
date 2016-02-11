public class KnightBoard{
    private int[][]board;
    private int counter=0;
    private int currentrow;
    private int currentcol;

    public KnightBoard(int size){
	board = new int[size][size];
    }
 
    public boolean solve(){
	return solveH(0,0);
    }

    public boolean solveH(int row, int col){
	if(board[row][col]==1){
	    return true; 
	}else{
	    if(addKnight(row,col)){
		addKnight(row,col);
		if
	    }
	}
    }

    public boolean addKnight(int row, int col){
        for(int row=0; row<length; row++){
            if(board[row][col] == 0){
		counter++;
                board[row][col] = counter;
                if(column != length-1){
                   
                }
                
                return true;
            }
        }
        return false; 
    
    }
public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
        int len = board.length;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(board[i][j]>0)
                    System.out.print(board[i][j]);
                if(board[i][j]<=0)
                    System.out.print('_');
                
                System.out.print("       ");
            }
            System.out.println();
        }
    
    }


}

