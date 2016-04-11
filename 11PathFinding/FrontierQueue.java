public class FrontierQueue<T> implements Frontier<T>{
    T t;
    
    private class Node{
	private int x;
	private int y;
	private T parent;

	public T getPrev(){
	    return parent;
	}
	
	public int[] getLocation(){
	    int[] ret = new int[2];
	    ret[0] = x;
	    ret[1] = y;
	    return ret;
	}
    }
    
    public void add(T element){
    }
    public T next(){
        return t;
    }
    public boolean hasNext(){
        return false;
    }
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    public static void main(String[] arggs){
        System.out.println("ill do this tmrw for sure");
    }
    
}
