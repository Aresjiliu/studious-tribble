import java.util.Scanner;

public class Main1 {
    public static String match(StringBuilder s){
        switch (s.toString()){
            case "if":
                return "If";
            case "else":
                return "Else";
            case "continue":
                return "Continue";
            case "return":
                return "Return";
            case "while":
                return "While";
            case "break":
                return "Break";
            default:
                return "Ident("+s.toString()+")";
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        char[] input;
        while(in.hasNextLine()){
            input = in.nextLine().trim().toCharArray();
            for(int i=0;i<input.length;i++){
                StringBuilder token = new StringBuilder("");
                if(Character.isLetter(input[i])||input[i]=='_'){
                    token.append(input[i]);
                    i++;
                    while((i<input.length)&&(Character.isLetter(input[i])||Character.isDigit(input[i])||input[i]=='_')){
                        token.append(input[i]);
                        i++;
                    }
                    System.out.println(match(token));
                    i--;
                }else if(Character.isDigit(input[i])){
                    token.append(input[i]);
                    i++;
                    while(Character.isDigit(input[i])){
                        token.append(input[i]);
                        i++;
                    }
                    System.out.println("Number("+token.toString()+")");
                    i--;
                }else if(input[i]=='='){
                    if(((i+1)<input.length)&&input[i+1]=='='){
                        System.out.println("Eq");
                        i++;
                    }else{
                        System.out.println("Assign");
                    }
                }else if(input[i]==' '||input[i]=='\n'){
                
                }else{
                    switch(input[i]){
                        case ';' :
                            System.out.println("Semicolon");
                            break;
                        case '(':
                            System.out.println("LPar");
                            break;
                        case ')':
                            System.out.println("RPar");
                            break;
                        case '{':
                            System.out.println("LBrace");
                            break;
                        case '}':
                            System.out.println("RBrace");
                            break;
                        case '+':
                            System.out.println("Plus");
                            break;
                        case '*':
                            System.out.println("Mult");
                            break;
                        case '/':
                            System.out.println("Div");
                            break;
                        case '<':
                            System.out.println("Lt");
                            break;
                        case '>':
                            System.out.println("Gt");
                            break;
                        default:
                            System.out.println("Err");
                            System.exit(0);;
                    }
                }
            }
        }
    }
}
