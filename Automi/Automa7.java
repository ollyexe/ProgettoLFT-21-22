
public class Automa7 {/* DFA che riconosca il linguaggio di stringhe che
    contengono il mio nome e tutte le stringhe ottenute dopo la sostituzione di un carattere del nome
    con un altro qualsiasi */
    public static boolean scan(String s)
    {
	int state = 0;
	int i = 0;

	while (state >= 0 && i < s.length()) {
	    final char ch = s.charAt(i++);
	    switch (state) {
	    case 0:
		if(ch=='O'||ch=='o')
            state = 1;

        else if(ch!='O'&&ch!='o'){
            state =7;



        }
		else
		    state = -1;
		break;

	    case 1:
        if(ch=='l')
            state = 2;
		else if(ch!='l'){
            {
                state=8;
            }



        }
		else
		    state = -1;
		break;



	    case 2:
		if(ch=='i')
            state = 3;

        else if(ch!='i')
            {
                state=9;
            }
		else
		    state = -1;
		break;

        
        
        case 3:
        if(ch=='v')
            state = 4;
        else if(ch!='v')
            {
                state=10;
            }
        else    
          state=-1;
          break;




        case 4:
        if(ch=='i')
            state = 5;

        else if(ch!='i')
            {
                state=11;
            }
        else    
            state=-1;
        break;



        case 5:
        if(ch=='u'){state = 6;}
            
        else if(ch!='u')
            {
                state=6;
            }
        else 
            state = -1;

        break;

        case 6:
        state=6;

        break;




	    case 7:
        if(ch=='l')
            state = 8;
		
		else
		    state = -1;
		break;



	    case 8:
		if(ch=='i')
            state = 9;
		else
		    state = -1;
		break;

        
        
        case 9:
        if(ch=='v')
            state = 10;
        else    
          state=-1;
          break;




        case 10:
        if(ch=='i')
            state = 11;
        else    
            state=-1;
        break;
        
        case 11:
        if(ch=='u')
            state = 6;
        else    
            state=-1;
        break;

	    }
	} 
	return state == 6;
    }

    public static void main(String[] args)
    {
	System.out.println(scan(args[0]) ? "OK" : "NOPE");
    }
}
