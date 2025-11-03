grammar MiniLang;

//---------------------------
// Parser-Regeln
//---------------------------

program
    : statement+ EOF
    ;

statement
    : assignment NEWLINE
    | ifStatement
    | whileStatement
    | NEWLINE           // leere Zeile erlaubt
    ;

assignment
    : ID ':=' expr
    ;

//---------------------------
// Kontrollstrukturen
//---------------------------

ifStatement
    : 'if' expr (NEWLINE+ 'do' | 'do') NEWLINE
      statement+
      ('else' (NEWLINE+ 'do' | 'do') NEWLINE statement+)?
      'end' NEWLINE?
    ;

whileStatement
    : 'while' expr (NEWLINE+ 'do' | 'do') NEWLINE
      statement+
      'end' NEWLINE?
    ;


//---------------------------
// Ausdrücke
//---------------------------

expr
    : expr op=('*'|'/') expr          # MulDivExpr
    | expr op=('+'|'-') expr          # AddSubExpr
    | expr op=('=='|'!='|'>'|'<'|'>='|'<=') expr  # CompareExpr
    | '(' expr ')'                    # ParenExpr
    | INT                             # IntLiteral
    | STRING                          # StringLiteral
    | ID                              # VariableRef
    ;

//---------------------------
// Lexer-Regeln
//---------------------------

ID      : [a-zA-Z_][a-zA-Z0-9_]* ;
INT     : [0-9]+ ;
STRING  : '"' (~["\r\n])* '"' ;
COMMENT : '#' ~[\r\n]* -> skip ;
NEWLINE : '\r'? '\n' ;
NL      : NEWLINE+ ;
WS      : [ \t]+ -> skip ;
