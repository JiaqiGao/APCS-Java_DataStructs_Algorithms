public class Driver{

    public static void main(String[] arg){
	BetterMaze b = new BetterMaze("data1.dat");
	//b.setAnimate(true);
	b.solveDFS();
	System.out.println(b);
    }

}
