/*
Se generó para representar la estructura del ciclo repeat-until.
Parámetros: C cuerpo del ciclo y E condición de finalización.
El nodo es generado en el parser y procesado por el checker, encoder y layoutVisitor.

*/
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class RepeatCommand extends Command {

  public RepeatCommand (Command cAST, Expression eAST, 
                       SourcePosition thePosition) {
    super(thePosition);
    C = cAST;    
    E = eAST;    
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRepeatCommand(this, o);
  }

  public Command C;  
  public Expression E;  
}