import java.io.File

fun transpiler(compilationFilePath: String, lexicon: List<Term>): String{
    val compilationFile = File(compilationFilePath)
    val functionList = mutableListOf<String>()
    var actual = 0
    var transpilation = MAIN_START().value
    while (actual < lexicon.size){
        val term = lexicon[actual]
        transpilation += when(term){
            is IF -> {actual++; COND_START(lexicon[actual].value).value}
            is THEN -> COND_VAL().value
            is ELSE -> COND_ELSE().value
            is ELSIF -> {actual++; COND_ELSIF(lexicon[actual].value).value}
            is FOR -> {actual++; val conds = lexicon[actual].value.split(','); COND_FOR(conds[0],conds[1],conds[2]).value}
            is WHILE -> {actual++; COND_WHILE(lexicon[actual].value).value}
            is DO -> COND_DO().value
            is END -> COND_END().value
            is FUN -> {val func = manageFunctionDeclaration(actual, lexicon, functionList); if(func.p != "") actual+=2 else actual++; func.value}
            is RETURN -> {actual++; DEC_RETURN(lexicon[actual].value).value}
            is EQ -> {actual++; val affect = manageAffectation(actual, lexicon, functionList); actual += if(affect is COND_FUN) 1 else 0; affect.value}
            is VARIABLE -> {val variable = manageVariableDeclaration(term, actual, lexicon, functionList); actual += if(variable is COND_FUN) 1 else 0; variable.value }
            is PRINT -> {actual++; STREAM(lexicon[actual].value).value}
            else -> term.value
        }
        actual++
    }
    transpilation += MAIN_END().value
    compilationFile.writeText(transpilation)
    return transpilation
}

//manage function declaration
fun manageFunctionDeclaration(actual: Int, lexicon: List<Term>, functionList: MutableList<String>): DEC_FUN{
    val functionName = lexicon[actual+1].value
    functionList.add(functionName)
    return DEC_FUN(functionName, paramsFunCreator(actual+2, lexicon, false))
}

//manage variable declaration
fun manageVariableDeclaration(term: VARIABLE, actual: Int, lexicon: List<Term>, functionList: List<String>): Term {
    if(functionList.contains(term.value))
        return COND_FUN("\n\t"+term.value, paramsFunCreator(actual+1, lexicon, true))
    if(!term.isInit && actual+2 < lexicon.size){
        val typeTerm = when(val type = lexicon[actual+2]){
            is STRING -> type
            is TRUE -> BOOL(term.value)
            is FALSE -> BOOL(term.value)
            is INT -> type
            else -> AUTO()
        }
        lexicon.filter{ tm -> tm.value == term.value }.forEach{ tm -> (tm as VARIABLE).isInit = true}
        return  DECLARE(term.value, typeTerm.javaClass.simpleName.toLowerCase() + " ")
    }
    return DECLARE(term.value)
}

//manage diff between variables & functions affectation
fun manageAffectation(actual: Int, lexicon: List<Term>, functionList: MutableList<String>): Term {
    if(functionList.contains(lexicon[actual].value))
        return COND_FUN(" = "+lexicon[actual].value, paramsFunCreator(actual+1, lexicon, true))
    return AFFECT(lexicon[actual].value)
}

//declare param for DECLARATION and AFFECTATION
fun paramsFunCreator(actual: Int, lexicon: List<Term>, affectation: Boolean): String{
    var params = ""
    if(lexicon[actual] !is DO){
        val allParams = lexicon[actual].value.split(",")
        for(p in allParams.indices){
            val param = allParams[p]
            params += if(affectation)
                if(p!=allParams.size-1) "$param, " else param
            else
                if(p!=allParams.size-1) "auto $param, " else "auto $param"
        }
    }
    return params
}