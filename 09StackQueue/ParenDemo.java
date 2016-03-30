public class ParenDemo{
    
    public static boolean isMatching(String s){
	char[][] key = {{'{','}'},{'[',']'},{'(',')'},{'<','>'}};
        MyStack<Character> pancekes = new MyStack<Character>();
        for(int i=0; i<s.length(); i++){   
                if(helper(s.charAt(i))==-1){
                    pancekes.push(s.charAt(i));
                }else if(key[helper(s.charAt(i))][0] == pancekes.peek()){
                    pancekes.pop();  
                }
        }
        return pancekes.isEmpty();
    }
    
    public static int helper(char s){
	char[][] key = {{'{','}'},{'[',']'},{'(',')'},{'<','>'}};
	for(int i=0; i<key.length; i++){
            if(key[i][0]==s){
                return -1;
            }  
            if(key[i][1]==s){
                return i;
            }
        }
        return -2;
    }

    public static void main(String[]args){
        
	String input = "";
	if(args.length>0)
	    input = args[0];

	System.out.println(isMatching(input));
       
        /*
       
	System.out.println(isMatching("{}{}{}"));
        System.out.println(isMatching("{}}{}"));
        System.out.println(isMatching("{}{[]}{}"));
        */

    }
}
