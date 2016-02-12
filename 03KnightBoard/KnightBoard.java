public class KnightBoard{
    private int[][]board;
    private int counter=0;

    public KnightBoard(int size){
	board = new int[size][size];
    }
 
    public boolean solve(){
	return check(0,0);
    }
    
    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public boolean solveH(int row, int col){
	if(board[row][col]==1){
	    return true; 
	}else 
    }

    public boolean check(int row, int col){
	int currentrow = row;
	int currentcol = col;
	if(board[row-2][col+1]==0){
	    currentrow = row-2;
	    currentcol = col-1;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	}else if(board[row-2][col-1]==0){
	    currentrow = row-2;
	    currentcol = col-1;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row-1][col-2]==0){
	    currentrow = row-1;
	    currentcol = col-2;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row+1][col-2]==0){
	    currentrow = row+1;
	    currentcol = col-2;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row+2][col-1]==0){
	    currentrow = row-2;
	    currentcol = col+1;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row+2][col+1]==0){
	    currentrow = row-2;
	    currentcol = col+1;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row+1][col+2]==0){
	    currentrow = row+1;
	    currentcol = col+2;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else if(board[row-1][col+2]==0){
	    currentrow = row-1;
	    currentcol = col+2;
	    addKnight(currentrow, currentcol);
	    if (solveH(currentrow, currentcol)){
		return true;
	    }else{
		removeKnight(col,row);
	    }
	
	}else{
	    return false;
	}
    }

    


    public boolean addKnight(int row, int col){
	counter++; 
	board[row][col] = counter;
    
	return true;
    
    }

    public boolean removeKnight(int row, int col){
	counter--;
	board[row][col] = 0;
	return true;
    }


public static void main(String[]args){
	KnightBoard b = new KnightBoard(8);
        System.out.println(b);
	System.out.println(b.solve());
        System.out.println(b);
	// b.printSolution();
    }

}

