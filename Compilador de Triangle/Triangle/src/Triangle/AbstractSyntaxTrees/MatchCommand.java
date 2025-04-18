package Triangle.AbstractSyntaxTrees;

import java.util.List;
import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author thelo
 */

public class MatchCommand extends Command {
    public static class Case {
        public final List<Expression> labels;
        public final Command   branch;
        public Case(List<Expression> labels, Command branch) {
          this.labels = labels;
          this.branch = branch;
        }
    }

  public final Expression            target;
  public final List<Case>            cases;
  public final Command               otherwise;  // puede ser null

  public MatchCommand(Expression target,
                      List<Case> cases,
                      Command otherwise,
                      SourcePosition thePosition) {
    super(thePosition);
    this.target    = target;
    this.cases     = cases;
    this.otherwise = otherwise;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitMatchCommand(this, o);
  }
}
