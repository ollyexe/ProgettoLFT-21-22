public class Automa9 {
    public static boolean scan(String s){
        int state = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // System.out.println(state);
            switch(state){
                case 0:
                    if(ch == '/'){
                        state = 1;
                    }else{
                        state = -1;
                    }
                    break;

                case 1:
                    if(ch == '*'){
                        state = 2;
                    }else{
                        state = -1;
                    }
                    break;

                case 2:
                    if(ch == '*'){
                        state = 3;
                    }else if(ch == 'a' || ch == '/'){
                        state = 2;
                    }else{
                        state = -1;
                    }
                    break;

                case 3:
                    if(ch == '*'){
                        state = 3;
                    }else if(ch == 'a'){
                        state = 2;
                    }else if(ch == '/'){
                        state = 4;
                    }else{
                        state = -1;
                    }
                    break;

                case 4:
                    state = -1;
                    break;
            }
        }
        return state == 4;
    }
    public static void main(String [] args){
        //System.out.println(scan(args[0]) ? "OK" : "NOPE");
        
        String s0 = "/****/";
        System.out.println(scan(s0) ? "ACCETTATA" : "RIFIUTATA");

        String s1 = "/*a*a*/";
        System.out.println(scan(s1) ? "ACCETTATA" : "RIFIUTATA");

        String s2 = "/*a/**/";
        System.out.println(scan(s2) ? "ACCETTATA" : "RIFIUTATA");

        String s3 = "/**a///a/a**/";
        System.out.println(scan(s3) ? "ACCETTATA" : "RIFIUTATA");

        String s4 = "/**/";
        System.out.println(scan(s4) ? "ACCETTATA" : "RIFIUTATA");

        String s5 = "/*/*/";
        System.out.println(scan(s5) ? "ACCETTATA" : "RIFIUTATA");

        String s6 = "/*/";
        System.out.println(scan(s6) ? "ACCETTATA" : "RIFIUTATA");

        String s7 = "/**/***/";
        System.out.println(scan(s7) ? "ACCETTATA" : "RIFIUTATA");
    }
}
