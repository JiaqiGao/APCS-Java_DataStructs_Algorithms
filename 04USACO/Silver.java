public class Silver{
    int[][] map;
    int[][] startend;

    public Silver(String filename){
	readFile(filename);
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

}
