/*
Se generó una clase para repesentar la estructura del ciclo FOR.
Los parámetros: V variable de control, E1 expresión inicial, E2 expresión final,
C cuerpo del ciclo, y isDownto indicia si el ciclo es descedente o no.

El nodo se genera en el parser y es procesado por el checker, encoder y layoutVisitor.
*/package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForCommand extends Command {

  public ForCommand (Vname vAST, Expression e1AST, Expression e2AST,
                     Command cAST, boolean isDownto, SourcePosition thePosition) {
    super (thePosition);
    V = vAST;
    E1 = e1AST;
    E2 = e2AST;
    C = cAST;
    this.isDownto = isDownto;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForCommand(this, o);
  }

  public Vname V;
  public Expression E1;
  public Expression E2;
  public Command C;
  public boolean isDownto;
}
