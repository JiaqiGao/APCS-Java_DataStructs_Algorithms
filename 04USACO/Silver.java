import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Silver{
    char[][] map;
    int[][] startend;
    int time;
    int startx;
    int starty;
    int endx;
    int endy;

    public Silver(String filename){
	readFile(filename);
    }
    
    public void readFile(String filename){
        File instructions = new File(filename);
        try{
            Scanner lines = new Scanner(instructions);
            
       
            int rows = lines.nextInt();
            int cols = lines.nextInt();
            map = new char[rows][cols];
 
            time = lines.nextInt();
            //System.out.println(lines.next().charAt(0));
            //int numInstrucs = lineOne.nextInt();
            // instrucs = new int[numInstrucs][3];
            
            for(int i=0; i<rows; i++){
                String line = lines.next();
                for(int j=0; j<cols; j++){
                  
                    map[i][j]=line.charAt(j);
                    
                    //System.out.println(map[i][j]);
      
                }
            }
            System.out.println(Arrays.deepToString(map));
            
            startx = Integer.parseInt(lines.next());
            starty = Integer.parseInt(lines.next());
            endx = Integer.parseInt(lines.next());
            endy = Integer.parseInt(lines.next());
    
            
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
        
        public static void main(String[]args){
            Silver s = new Silver("test1.in");
            //System.out.println(b.makelake()+", 6, Gao, JiaQi");
        }
        
    

}
