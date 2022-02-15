
import java.io.*;
public class Parser {
    // analizzatore sintattico che controlla se la successione di token, 
    // generata dal lexer, rispetta la grammatica implementata.
    private Lexer lex;
    private BufferedReader pbr;
    private Token look;
    public static String s;

    public Parser(Lexer l, BufferedReader br) {
        lex = l;
        pbr = br;
        move();
    }

    void move() {   // legge prossimo token
        look = lex.lexical_scan(pbr);
        System.out.println("token = " + look);
    }

    void error(String s) {// genera, se presenti, degli errori
        throw new Error("near line " + lex.line + ": " + s);
    }

    void match(int t) {// verifica se il tag corrisponde al simbolo corrente
        if (look.tag == t) {
            if (look.tag != Tag.EOF) move();
        } else error("syntax error");
    }
   
    public void prog(){ // produzione di partenza
        statlist();
        match(Tag.EOF);
    }

    private void statlist(){
        stat();
        statlistp();
    }


    private void statlistp(){
        switch (look.tag) { 
            case ';':
                match(';');
                stat();
                statlist();
                break;

            default:
                //caso eps
                break;
        }
    }
    //caso degli identificatori della sintassi simil-java
    private void stat(){//testa della produzione
        switch (look.tag){  // ogni case (tag) ci suggerisce come implementare la produzione
                            // per ogni tag richiamiamo una procedura adatta, dettata dalla produzione
            case Tag.ASSIGN:
                match(Tag.ASSIGN);
                expr();
                match(Tag.TO);
                idlist();
                break;

            case Tag.PRINT:
                match(Tag.PRINT);
                match('(');
                exprlist();
                match(')');
                break;

            case Tag.READ:
                match(Tag.READ);
                match('(');
                idlist();
                match(')');
                break;

            case Tag.WHILE:
                match(Tag.WHILE);
                match('(');
                bexpr();
                match(')');
                stat();
                break;

            case Tag.IF:
                match(Tag.IF);
                match('(');
                bexpr();
                match(')');
                stat();
                statif();
                break;

            case '{':
                match('{');
                statlist(); 
                match('}');
            break; 
        } 
    }

    private void statif(){  // metodo aggiuntivo per rimozione fattorizzazione 
        switch(look.tag){
            case Tag.END:
                match(Tag.END);    
                break;        
            case Tag.ELSE:
                match(Tag.ELSE);
                stat();
                match(Tag.END);
                break;
        }
    }

    private void idlist(){
        match(Tag.ID);
        idlistp();
    }

    private void idlistp(){
        switch(look.tag){
            case ',': 
                match(',');
                match(Tag.ID);
                idlistp();
                break;

            default://caso eps
                break;
           }
    }

    private void bexpr(){
        match(Tag.RELOP);
        expr();
        expr();
    }

    private void expr(){
        switch (look.tag) { 
            case '+':
                match('+');
                match('(');
                exprlist();
                match(')');
                break;

             case '-':
                match('-');
                expr();
                expr();
                break;

             case '/':
                match('/');
                expr();
                expr();
                break;

             case '*':
                match('*');
                match('(');
                exprlist();
                match(')');
                break;
            
             case Tag.NUM:     //caso numero
                match(Tag.NUM);
                break;
            
             case Tag.ID:      //caso identificaore
                match(Tag.ID);
                break;
        }
    }

    private void exprlist(){
        expr();
        exprlistp();
    }

    public void exprlistp(){
        switch (look.tag) {
            case ',':
                match(',');
                expr();
                exprlist();
                break;
        
            default://caso eps
                break;
        }
    }
    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = "Input.lft"; // il percorso del file da leggere
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Parser parser = new Parser(lex, br);
            parser.prog();
            System.out.println("Input OK");
            br.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}
    
