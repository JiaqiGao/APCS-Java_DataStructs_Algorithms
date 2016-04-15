public class FrontierQueue<T> extends MyQueue<T> implements Frontier<T>{
  
    public void add(T element){
        enqueue(element);
    }
    public T next(){
        return dequeue();
    }
    public boolean hasNext(){
        return isEmpty()==false;
    }
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/
   
    
}
