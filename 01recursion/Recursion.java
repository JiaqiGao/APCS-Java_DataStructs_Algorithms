public class Recursion{
    public String name(){
        return "Gao, Jia Qi";
    }

    public double sqrthelper(double n, double guess){
        if (Math.pow(guess, 2)-n < 0.0000001){
            return guess;
        }else{
            return sqrthelper(n, (n/guess+guess)/2);
        }
    }
        
    
    public double sqrt(double n){
        if (n<0)
            throw new IllegalArgumentException("n must be positive");
        
        return sqrthelper(n, n/2);
    }
    /*
    public static void main(String[]arggs){
        Recursion rec = new Recursion();
        System.out.println(rec.name());
        System.out.println(rec.sqrt(-6));
        System.out.println(rec.sqrt(26));
    }
    */
    
}
