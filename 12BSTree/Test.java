public class Test{

    public static void main(String[] args){
        BSTree<Integer> b = new BSTree<Integer>();
        b.add(10);
        b.add(4);
        b.add(12);
        System.out.println(b);
        
        System.out.println(b.contains(4));
        System.out.println(b.contains(2323));
    }


}
