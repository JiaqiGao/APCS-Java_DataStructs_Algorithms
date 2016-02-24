import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Bronze{
    int[][] map;
    int[][] instrucs;
    int elevation;

    public Bronze(String filename){
        readFile(filename);
        // stomp();
    }
    
    public void readFile(String filename){
        File instructions = new File(filename);
        try{
            Scanner lines = new Scanner(instructions);
            
            Scanner lineOne = new Scanner(lines.nextLine());
            int rows = lineOne.nextInt();
            int cols = lineOne.nextInt();
            elevation = lineOne.nextInt();
            int numInstrucs = lineOne.nextInt();

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    map[i][j]=lines.nextInt();
                }
            }

            for(int i=0; i<numInstrucs; i++){
                for(int j=0; j<3; j++){
                    instrucs[i][j] = lines.nextInt();
                }
            }
            //System.out.println(col);
                
            //Scanner lineTwo = new Scanner(lines.nextLine());
            //Scanner lineThree = new Scanner(lines.nextLine());
            System.out.println(Arrays.deepToString(map));
            System.out.println(Arrays.deepToString(instrucs));
            System.out.println(elevation);
            
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    
    
    
    public int makelake(){
	return 0;
    }
    
    public static void main(String[]args){
	Bronze b = new Bronze("makelake.in");
    }


}
