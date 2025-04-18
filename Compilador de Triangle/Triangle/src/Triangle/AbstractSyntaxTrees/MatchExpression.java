/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Triangle.AbstractSyntaxTrees;

import java.util.List;
import Triangle.SyntacticAnalyzer.SourcePosition;
/**
 *
 * @author thelo
 */
public class MatchExpression extends Expression {
    public static class Case {
    public final List<Expression> labels;
    public final Expression       branch;
    public Case(List<Expression> labels, Expression branch) {
      this.labels = labels;
      this.branch = branch;
    }
  }

  public final Expression            target;
  public final List<Case>            cases;
  public final Expression            otherwise;  // obligatorio

  public MatchExpression(Expression target,
                         List<Case> cases,
                         Expression otherwise,
                         SourcePosition thePosition) {
    super(thePosition);
    this.target    = target;
    this.cases     = cases;
    this.otherwise = otherwise;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitMatchExpression(this, o);
  }
}
