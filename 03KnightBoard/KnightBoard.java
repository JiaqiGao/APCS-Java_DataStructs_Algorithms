import java.util.Arrays;

public class KnightBoard{
    private int[][]board;
    private int counter=0;
    public int[][] moves = new int[8][2];
    private int goal;

    public String name(){
	return "Gao, JiaQi";
    }
    
    public KnightBoard(int size){
        if(size<1){
	    throw new IllegalArgumentException();
	}
	board = new int[size][size];
        goal = size*size;
        moves[0][0] = -2;
        moves[0][1] = 1;
        moves[1][0] = -2;
        moves[1][1] = -1;
        moves[2][0] = -1;
        moves[2][1] = 2;
        moves[3][0] = -1;
        moves[3][1] = -2;
        moves[4][0] = 1;
        moves[4][1] = 2;
        moves[5][0] = 1;
        moves[5][1] = -2;
        moves[6][0] = 2;
        moves[6][1] = 1;
        moves[7][0] = 2;
        moves[7][1] = -1;
        
           
        // = {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{-1,2},{1,2},{2,1}};
    }
 
    public boolean solve(){
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(solveH(i,j)){
                    return true;
                }
            }
        }
        return false;
       
	//return check(0,0);
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
    
    public void printSolution(){
        solve();
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
                if(board.length >= 10){
                    if(c<10){
                        ans+= "_"+board[r][c]+"\t";
                    }else{
                        ans+= board[r][c]+"\t";
                    }
                }else{
                    ans+= board[r][c]+"\t";
                }
	    }
	    ans+="\n";
	}
	System.out.println(ans);
    }


    public boolean solveH(int row, int col){
        //System.out.println("pass");
        if(counter == goal){
            return true;
        }
	int currentrow = row;
	int currentcol = col;
        for(int i=0; i<8; i++){
            try{
                if(board[row+moves[i][0]][col+moves[i][1]]==0){
                     currentrow = row+moves[i][0];
                     currentcol = col+moves[i][1];
                     addKnight(currentrow, currentcol);
                     if (check(currentrow, currentcol)){        
                         return check(currentrow,currentcol);
                     }else{
                         //System.out.println("elsed");
                         removeKnight(currentrow,currentcol);
                         
                         
                     }
                }
            }catch (IndexOutOfBoundsException e){
            }
        }
        return false;
         
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
        System.out.println(Arrays.deepToString(b.moves));
	System.out.println(b.solve());
        System.out.println(b);
	// b.printSolution();
    }

}

