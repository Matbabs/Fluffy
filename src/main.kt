//kotlinc ./src/*.kt -include-runtime -d ./fluffy.jar

fun main (args: Array<String>){
    println("\n\uD83D\uDC31 fluffy 1.0 \n")
    if(args.isNotEmpty()){
        val inputFile = args[0]
        val compilationFile = inputFile.split('.')[0] + ".cpp"
        val terms = reader(inputFile)
        val lexicon = lexer(terms)
        val compilation = transpiler(compilationFile,lexicon)
        Runtime.getRuntime().exec("g++ $compilationFile")
        if(compilation.isNotEmpty()) println("\uD83D\uDC31 compilation done: a.out ... \n")
    } else {
        val terms = reader("./scripts/test.fy")
        val lexicon = lexer(terms)
        println(lexicon)
        val compilation = transpiler("./scripts/test.cpp",lexicon)
        println(compilation)
    }
}