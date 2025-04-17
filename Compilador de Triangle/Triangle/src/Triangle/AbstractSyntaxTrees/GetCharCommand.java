package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class GetCharCommand extends Command {
    
    public GetCharCommand(Vname vAST, SourcePosition thePosition) {
        super(thePosition);
        V = vAST;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitGetCharCommand(this, o);
    }

    public Vname V; 
}