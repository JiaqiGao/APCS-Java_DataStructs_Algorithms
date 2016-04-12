public class FrontierStack<T> extends MyStack<T> implements Frontier<T>{
   
    public void add(T element){
        push(element);
    }
    public T next(){
        return pop();
    }
    public boolean hasNext(){
        return isEmpty();
    }
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
    public static void main(String[] arggs){
      
    }
    
}
