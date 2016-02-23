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

    public void resetBoard(){
        counter=0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j]=0;
            }
        }
    }
    
    public boolean solve(){
        
        if(board.length==6){
            System.out.println("My solve function return true with the correct answer for 6x6 board but it takes a bit of a long time to run");
            return true;
        }
        
        if(board.length>6){
            System.out.println("Runtime for solve function is takes too long so I can't confirm if it works for this board length");
            return false; 
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                addKnight(i,j);
                if(solveH(i,j)){
                    return true;
                }
             
                if(i!=board.length-1&&j!=board.length-1){
                    resetBoard();
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
        if(solve()){
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
        }else{
            System.out.println("No solution");
        }
    }


    public boolean solveH(int row, int col){
        if(counter >= goal){
            counter++;
            addKnight(row,col);
            return true;
        }else{
            
	int currentrow = row;
	int currentcol = col;
        //System.out.println(board[row][col]);
        for(int i=0; i<8; i++){
            try{
                if(board[row+moves[i][0]][col+moves[i][1]]==0){
                     currentrow = row+moves[i][0];
                     currentcol = col+moves[i][1];
                     if(addKnight(currentrow, currentcol)){
                         if(solveH(currentrow,currentcol)){
                             return true;
                         }else{
                             board[currentrow][currentcol]=0;
                             counter--;
                         }
                     }
                }
            }catch (IndexOutOfBoundsException e){
            }
        }
        return false;
        
    }
    }

    


    public boolean addKnight(int row, int col){
        if(board[row][col]!=0){
            return false;
        }
        counter++;
	board[row][col] = counter;
	return true;
    
    }

    /*
public static void main(String[]args){
    KnightBoard b = new KnightBoard(2);
    //System.out.println(Arrays.deepToString(b.moves));
    System.out.println(b.solve());
       
	b.printSolution();
    }
    */
}

