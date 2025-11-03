import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import my.pkg.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
  static void main(String... args) throws IOException, URISyntaxException {
    System.out.println("Hello World!");
    System.out.print("expr?> ");
    java.util.Scanner sc = new java.util.Scanner(System.in);
    String input = sc.nextLine();

    MiniLangLexer lexer = new MiniLangLexer(CharStreams.fromString(input));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MiniLangParser parser = new MiniLangParser(tokens);
    ParseTree tree = parser.program(); // Start-Regel
    System.out.print(tree.toStringTree(parser));

    PrettyPrinter printer = new PrettyPrinter();
    printer.visit(tree);

    // Einlesen über den Classpath
    // IO.readln("enter?> ");
    try (InputStream in = Main.class.getResourceAsStream("/cpp/vars.cpp")) {
      String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
      System.out.print("\n\n/cpp/vars.cpp");
      System.out.print(text);
    }
    // Einlesen über Dateisystem
    // IO.readln("enter?> ");
    URL url = Main.class.getResource("/cpp/expr.cpp");
    String txt = Files.readString(Path.of(url.toURI()), StandardCharsets.UTF_8);
    System.out.print("\n\n/cpp/expr.cpp");
    System.out.print(txt);
  }
}
