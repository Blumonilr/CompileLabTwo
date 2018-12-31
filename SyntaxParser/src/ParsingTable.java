import java.util.List;

public class ParsingTable {

    static String[][] table= {{"null", "null", "null","null","E->TC","null","E->TC"},
                              {"C->AC","C->AC","null","null","null","C->#","null"},
                              {"A->+T","A->-T","null","null","null","null","null"},
                              {"null","null","null","null","T->FD","null","T->FD"},
                              {"D->#","D->#","D->BD","D->BD","null","D->#","null"},
                              {"null","null","B->*F","B->/F","null","null","null"},
                              {"null","null","null","null","F->(E)","null","F->i"}};

    public ParsingTable(){
    }

    public String getExpression(int i,int j){
        return table[i][j];
    }
}
