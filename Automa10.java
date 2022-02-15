public class Automa10 {
    public static boolean scan(String s){
        int state = 0; 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(state){
                case 0:
                    if(ch == 'a' || ch == '*'){
                        state = 1;
                    }else if(ch == '/'){
                        state = 2;
                    }else{
                        state = -1;
                    }
                    break;

                case 1:
                    if(ch == 'a' || ch == '*'){
                        state = 1;
                    }else if(ch == '/'){
                        state = 2;
                    }else{
                        state = -1;
                    }
                    break;

                case 2:
                    if(ch == 'a'){
                        state = 1;
                    }else if(ch == '*'){
                        state = 3;
                    }else if(ch == '/'){
                        state = 2;
                    }else{
                        state = -1;
                    }
                    break;

                case 3:
                    if(ch == 'a' || ch == '/'){
                        state = 3;
                    }else if(ch == '*'){
                        state = 4;
                    }else{
                        state = -1;
                    }
                    break;

                case 4:
                    if(ch == 'a'){
                        state = 3;
                    }else if(ch == '/'){
                        state = 5;
                    }else if(ch == '*'){
                        state = 4;
                    }else{
                        state = -1;
                    }
                    break;

                case 5:
                    if(ch == 'a' || ch == '*'){
                        state = 5;
                    }else if(ch == '/'){
                        state = 6;
                    }else{
                        state = -1;
                    }
                    break;

                case 6:
                    if(ch == 'a'){
                        state = 5;
                    }else if(ch == '*'){
                        state = 3;
                    }else if(ch == '/'){
                        state = 6;
                    }else{
                        state = 1;
                    }
                    break;
            }
        }
        return state == 1 || state == 2 || state == 5 || state == 6;
    }
    public static void main(String [] args){
        String s0 = "aaa/****/aa";
        System.out.println(scan(s0) ? "ACCETTATO" : "RIFIUTATO");

        String s1 = "aa/*a*a*/";
        System.out.println(scan(s1) ? "ACCETTATO" : "RIFIUTATO");

        String s2 = "aaaa";
        System.out.println(scan(s2) ? "ACCETTATO" : "RIFIUTATO");

        String s3 = "/****/";
        System.out.println(scan(s3) ? "ACCETTATO" : "RIFIUTATO");

        String s4 = "/*aa*/";
        System.out.println(scan(s4) ? "ACCETTATO" : "RIFIUTATO");

        String s5 = "*/a";
        System.out.println(scan(s5) ? "ACCETTATO" : "RIFIUTATO");

        String s6 = "a/**/***a";
        System.out.println(scan(s6) ? "ACCETTATO" : "RIFIUTATO");

        String s7 = "a/**/***/a";
        System.out.println(scan(s7) ? "ACCETTATO" : "RIFIUTATO");

        String s8 = "a/**/aa/***/a";
        System.out.println(scan(s8) ? "ACCETTATO" : "RIFIUTATO");

        String s9 = "aaa/*/aa";
        System.out.println(scan(s9) ? "ACCETTATO" : "RIFIUTATO");

        String s10 = "a/**//***a";
        System.out.println(scan(s10) ? "ACCETTATO" : "RIFIUTATO");

        String s11 = "aa/*aa";
        System.out.println(scan(s11) ? "ACCETTATO" : "RIFIUTATO");
    }
}
