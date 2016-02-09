public class Recursion{
    public String name(){
        return "Gao, JiaQi";
    }

    public double sqrthelper(double n, double guess){
        if (Math.abs(Math.pow(guess,2)-n) < 0.00000000001){
            // System.out.println(guess);
            return guess;
        }else{
            return sqrthelper(n, (n/guess+guess)/2.0);
        }
    }
        
    
    public double sqrt(double n){
        if (n==0){
            return 0;
        }
        if (n<0)
            throw new IllegalArgumentException("n must be positive");
        
        return sqrthelper(n, 1);
    }
    /*
    public static void main(String[]arggs){
        Recursion rec = new Recursion();
        System.out.println(rec.name());
        System.out.println(rec.sqrt(7));
        System.out.println(Math.sqrt(1.0E-7));
        System.out.println(rec.sqrt(1.0E-7));
        
    }
    */
    
}
