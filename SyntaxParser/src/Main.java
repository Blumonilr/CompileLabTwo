import java.util.List;

public class Main {

    public static void main(String args[]){
        LLParser parser=new LLParser();
        IOHandler handler=new IOHandler();
        String input=handler.readFile();
        parser.analyze(input);
        List<String> expr=parser.getOutput();
        if (expr.contains("error")){
            System.out.println("Input string dose not match to the rules");
        }
        else {
            handler.writeFile(expr);
        }
    }
}
