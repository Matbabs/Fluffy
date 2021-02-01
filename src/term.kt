//TERM

open class Term(val value: String)

//Fluffy TERMS

data class IF(val v: String = "if"): Term(v)
data class THEN(val v: String = "then"): Term(v)
data class ELSE(val v: String = "else"): Term(v)
data class ELSIF(val v: String = "elsif"): Term(v)
data class FOR(val v: String = "for"): Term(v)
data class WHILE(val v: String = "while"): Term(v)
data class DO(val v: String = "do"): Term(v)
data class END(val v: String = "end"): Term(v)
data class FUN(val v: String = "fun"): Term(v)
data class RETURN(val v: String = "return"): Term(v)

data class EQ(val v: String = "="): Term(v)

data class VARIABLE(val v: String, var isInit: Boolean=false): Term(v)
data class INT(val v: String): Term(v)
data class STRING(val v: String): Term(v)
data class BOOL(val v: String): Term(v)
data class TRUE(val v: String="true"): Term(v)
data class FALSE(val v: String="false"): Term(v)

data class PRINT(val v: String = "print"): Term(v)

//Transpilation TERMS

data class MAIN_START(val v: String = "#include <iostream>\n#include <string>\nusing namespace std;\n\nint main() {"): Term(v)
data class MAIN_END(val v: String = "\n\treturn 0;\n}"): Term(v)

data class COND_START(val v: String): Term("\n\tif($v")
data class COND_VAL(val v: String="){"): Term(v)
data class COND_ELSE(val v: String="\n\t} else {"): Term(v)
data class COND_ELSIF(val v: String): Term("\n\t} else if($v")
data class COND_FOR(val v: String, val s: String, val e: String): Term("\n\tfor(int $v=$s; $v<$e; $v++")
data class COND_WHILE(val v: String): Term("\n\twhile($v")
data class COND_DO(val v: String="){"): Term(v)
data class COND_END(val v: String="\n\t};"): Term(v)
data class COND_FUN(val v: String, val p: String=""): Term("$v($p);")

data class DECLARE(val v: String, val t: String= ""): Term("\n\t"+t+v)
data class AFFECT(val v: String): Term(" = $v;")

data class AUTO(val v: String="auto"): Term(v)

data class DEC_FUN(val v: String, val p: String=""): Term("\n\tauto $v = []($p")
data class DEC_RETURN(val v: String): Term("\n\treturn $v;")
data class STREAM(val v: String): Term("\n\tcout<<$v<<endl;")