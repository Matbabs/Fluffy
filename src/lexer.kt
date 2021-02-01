fun lexer(terms: MutableList<String>): List<Term> = when(terms.size){
    0 -> listOf()
    else -> listOf(stringToTerm(terms.removeFirst(), terms)) + lexer(terms)
}

fun stringToTerm(term: String, terms: MutableList<String>): Term = when(term){
    "if" -> IF()
    "then" -> THEN()
    "else" -> ELSE()
    "elsif" -> ELSIF()
    "for" -> FOR()
    "while" -> WHILE()
    "do" -> DO()
    "end" -> END()
    "fun" -> FUN()
    "return" -> RETURN()
    "=" -> EQ()
    "print" -> PRINT()
    "true" -> TRUE()
    "false" -> FALSE()
    "" -> stringToTerm(terms.removeFirst(),terms)
    else -> when {
        term[0] == '\"' -> STRING(term)
        term.any{c->c.isDigit()} -> INT(term)
        else -> VARIABLE(term)
    }
}