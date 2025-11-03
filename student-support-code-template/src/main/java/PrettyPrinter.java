public class PrettyPrinter extends MiniLangBaseVisitor<Void> {

  private int indent = 0; // Einrückungsebene

  private void printIndent() {
    System.out.print("    ".repeat(indent));
  }

  @Override
  public Void visitAssignment(MiniLangParser.AssignmentContext ctx) {
    printIndent();
    System.out.println(ctx.getText().replaceAll("\\s+", " "));
    return null;
  }

  @Override
  public Void visitIfStatement(MiniLangParser.IfStatementContext ctx) {
    printIndent();
    System.out.print("if " + ctx.expr().getText() + " do\n");
    indent++;
    visit(ctx.statement(0));
    indent--;
    if (ctx.statement().size() > 1) {
      printIndent();
      System.out.print("else do\n");
      indent++;
      visit(ctx.statement(1));
      indent--;
    }
    printIndent();
    System.out.println("end");
    return null;
  }

  @Override
  public Void visitWhileStatement(MiniLangParser.WhileStatementContext ctx) {
    printIndent();
    System.out.print("while " + ctx.expr().getText() + " do\n");
    indent++;
    for (var s : ctx.statement()) visit(s);

    indent--;
    printIndent();
    System.out.println("end");
    return null;
  }
}
