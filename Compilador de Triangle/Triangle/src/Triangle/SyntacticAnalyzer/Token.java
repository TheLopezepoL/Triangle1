/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {
    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind; // Match found
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER; // No match
          searching = false;
        } else {
          currentKind++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }


  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int 
    // Se agregaron nuevas palabras reservadas en orden alfabético 
    // y se actualizaron los numeros de indice.
    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	= 3,

    // reserved words - must be in alphabetical order...
    ARRAY		= 4,
    BEGIN		= 5,
    CONST		= 6,
    DO			= 7,
    DOWNTO              = 8, //agregado
    ELSE		= 9,
    END			= 10,
    FOR                 = 11, //agregado
    FROM                = 12, //agregado
    FUNC                = 13,
    GETCHAR             = 14,
    IF			= 15,
    IN			= 16,
    LET			= 17,
    MATCH               = 18,
    OF			= 19,
    PROC		= 20,
    RECORD		= 21,
    REPEAT              = 22, //agregado
    THEN		= 23,
    TO                  = 24, //agregado
    TYPE		= 25,
    UNTIL               = 26, //agregado
    VAR			= 27,
    WHILE		= 28,

    // punctuation...
    DOT			= 29,
    COLON		= 30,
    SEMICOLON	= 31,
    COMMA		= 32,
    BECOMES		= 33,
    IS			= 34,

    // brackets...
    LPAREN		= 35,
    RPAREN		= 36,
    LBRACKET	= 37,
    RBRACKET	= 38,
    LCURLY		= 39,
    RCURLY		= 40,

    // special tokens...
    EOT			= 41,
    ERROR		= 42;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "begin",
    "const",
    "do",
    "downto", //agregado
    "else",
    "end",
    "for", //agregado
    "from", //agregado
    "func",
    "getchar",
    "if",
    "in",
    "let",
    "match",
    "of",
    "proc",
    "record",
    "repeat", //agregado
    "then",
    "to", //agregado
    "type",
    "until", //agregado
    "var",
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>",
  };

  private final static int	firstReservedWord = Token.ARRAY,
                  lastReservedWord  = Token.WHILE;

}
