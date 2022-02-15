public class Automa1C {
    
    public static boolean scan(String s){
        int state = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(state){

                case 0:
                    if(ch == '0'){
                        state = 1;
                    }else if(ch == '1'){
                        state = 0;
                    }else{
                        state = -1;
                    }
                    break;

                case 1:
                    if(ch == '0'){
                        state = 2;
                    }else if(ch == '1'){
                        state = 0;
                    }else{
                        state = -1;
                    }
                    break;

                case 2:
                    if(ch == '0'){
                        state = 1;
                    }else if(ch == '1'){
                        state = 3;
                    }else{
                        state = -1;
                    }
                    break;

                case 3:
                    if(ch == '0'){
                        state = 3;
                    }else if(ch == '1'){
                        state = 3;
                    }else{
                        state = -1;
                    }
                    break;
            }
        }
        return state == 0 || state == 1 || state == 2;
    }

    public static void main(String [] args){
        System.out.println(scan(args[0]) ? "OK" : "NOPE");
    }
}
