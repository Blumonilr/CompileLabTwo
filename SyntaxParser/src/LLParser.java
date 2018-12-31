import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LLParser {

    List<String> output;
    ParsingTable table;
    Stack<Character> identifier;

    public LLParser(){
        output=new ArrayList<>();
        identifier=new Stack<>();
        identifier.push('E');
        table=new ParsingTable();
    }

    public void analyze(String input){
        int i=0;
        while (input.charAt(i)!='$'){
            char x=input.charAt(i);
            char y=identifier.peek();
            if (x==y){
                identifier.pop();
                output.add("match: "+x);
                i++;
                continue;
            }
            else if (table.getExpression(getIndex(y),getIndex(x)).equals("null")){
                output.add("error");
                break;
            }else{
                String expr=table.getExpression(getIndex(y),getIndex(x));
                output.add(expr);
                String id=expr.substring(expr.indexOf(">")+1);
                identifier.pop();
                for (int j=id.length()-1;j>=0;j--){
                    if (id.charAt(j)!='#')
                        identifier.push(id.charAt(j));
                }
                continue;
            }
        }
    }

    private int getIndex(char c){
        switch (c){
            case 'E':return 0;
            case 'C':return 1;
            case 'A':return 2;
            case 'T':return 3;
            case 'D':return 4;
            case 'B':return 5;
            case 'F':return 6;
            case '+':return 0;
            case '-':return 1;
            case '*':return 2;
            case '/':return 3;
            case '(':return 4;
            case ')':return 5;
            case 'i':return 6;
            default: return -1;
        }
    }

    public List<String> getOutput() {
        return output;
    }
}
