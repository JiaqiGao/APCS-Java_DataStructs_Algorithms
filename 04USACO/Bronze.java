import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Bronze{
    int[][] map;
    int[][] instrucs;
    int elevation;

    public Bronze(String filename){
        readFile(filename);
        stomp(instrucs[0][0], instrucs[0][1], instrucs[0][2]);
        stomp(instrucs[1][0], instrucs[1][1], instrucs[1][2]);
        
    }
    
    public void readFile(String filename){
        File instructions = new File(filename);
        try{
            Scanner lines = new Scanner(instructions);
            
            Scanner lineOne = new Scanner(lines.nextLine());
            int rows = lineOne.nextInt();
            int cols = lineOne.nextInt();
            map = new int[rows][cols];
            
            elevation = lineOne.nextInt();
            int numInstrucs = lineOne.nextInt();
            instrucs = new int[numInstrucs][3];
            
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
            
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
    }
    
    public void stomp(int row, int col, int depth){
        row--;
        col--;
        int highest = map[row][col];

        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                if(highest<map[i][j]){
                    
                    highest = map[i][j];
                }
            }
        }
        int newHighest=0;
        for(int d=0; d<depth; d++){
            for(int i=row; i<row+3; i++){
                for(int j=col; j<col+3; j++){
                    if(map[i][j]==highest){
                        map[i][j]--;
                    }
                }
            }
            highest--;
        }
        /*
        I realized I interpretted the problem wrong:
        3.if any spot is higher than the now-lowered highest, subtract there
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                if(map[i][j]>newHighest){
                    map[i][j]=newHighest;
                }
            }
        }
        */
    }

    
    
    public int makelake(){
	int sum = 0;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] < elevation)
                    sum += elevation - map[i][j];
            }
        }
        return 6*12*6*12*sum;
    }
    
    public static void main(String[]args){
	Bronze b = new Bronze("makelake.in");
        System.out.println(b.makelake()+", 6, Gao, JiaQi");
    }


}
