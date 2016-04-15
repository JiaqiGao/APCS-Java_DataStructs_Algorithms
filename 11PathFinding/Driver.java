import java.util.*;
import java.io.*;
public class Driver{

    public static void main(String[] arg){
	BetterMaze b = new BetterMaze("data1.dat");
	//b.setAnimate(true);
	b.solveBFS();
	System.out.println(b);
	System.out.println(Arrays.toString(b.solutionCoordinates()));
    }

}
