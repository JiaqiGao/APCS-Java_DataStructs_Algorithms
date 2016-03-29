public class ParenDemo{
    
    public static boolean isMatching(String s){
	String[][] key = {{"{","}"},{"[","]"},{"(",")"},{"<",">"}};
	if(s.length()%2>0){
	    return false;
	}
	int starting = 0;
        String temp = s.substring(starting,starting+1);
	for(int i=0; i<s.length(); i++){
	    if(helper(temp)!=-1){
		starting++;
		temp=s.substring(starting,starting+1);
	    }else{
	        if(s.substring(starting+1,starting+2).equals(key[helper(temp)][1])){
		    
		}
	    }
	    
	}

	
    }
    public static int helper(String s){
	String[][] key = {{"{","}"},{"[","]"},{"(",")"},{"<",">"}};
	for(int i=0; i<key.length; i++){
	    if(s.equals(key[i][0])){
		return i;
	    }
	}
	return -1;
    }

    public static void main(String[]args){
	String input = "";
	if(args.length>0)
	    input = args[0];
  
	System.out.println(isMatching(input));

    }
}
