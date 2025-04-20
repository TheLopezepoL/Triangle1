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
    CASE                = 6,    //agregado
    CONST		= 7,
    DO			= 8,
    DOWNTO              = 9,    //agregado
    ELSE		= 10,
    END			= 11,
    FOR                 = 12,   //agregado
    FROM                = 13,   //agregado
    FUNC                = 14,
    GETCHAR             = 15,
    IF			= 16,
    IN			= 17,
    LET			= 18,
    MATCH               = 19,
    OF			= 20,
    OTHERWISE           = 21,   //agregado
    PROC		= 22,
    RECORD		= 23,
    REPEAT              = 24,   //agregado
    THEN		= 25,
    TO                  = 26,   //agregado
    TYPE		= 27,
    UNTIL               = 28,   //agregado
    VAR			= 29,
    WHILE		= 30,

    // punctuation...
    DOT			= 31,
    COLON		= 32,
    SEMICOLON           = 33,
    COMMA		= 34,
    BECOMES		= 35,
    IS			= 36,

    // brackets...
    LPAREN		= 37,
    RPAREN		= 38,
    LBRACKET            = 39,
    RBRACKET            = 40,
    LCURLY		= 41,
    RCURLY		= 42,

    // special tokens...
    EOT			= 43,
    ERROR		= 44;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "begin",
    "case",     //agregado
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
    "otherwise",    //agregado
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
