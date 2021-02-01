import java.io.File

fun reader(path: String) : MutableList<String>{
    val terms = mutableListOf<String>()
    File(path).forEachLine { line -> line.split(' ').forEach{ term -> terms.add(term)}}
    return stringSpacesFilter(terms)
}

fun stringSpacesFilter(terms: MutableList<String>): MutableList<String> {
    var actual = 0
    while (actual < terms.size){
        if(terms[actual].isNotEmpty() && stringQuoteDetect(terms[actual]) == 1){
            val actualMerge = actual + 1
            while (!terms[actualMerge].contains('\"')) {
                terms[actual] = terms[actual] +" "+ terms[actualMerge]
                terms.removeAt(actualMerge)
            }
            if(terms[actualMerge].length == 1)
                terms[actual] = terms[actual] + "\""
            else
                terms[actual] = terms[actual] +" "+ terms[actualMerge]
            terms.removeAt(actualMerge)
        }
        actual++
    }
    return terms
}

fun stringQuoteDetect(term: String): Int {var res = 0; term.forEach { c -> if(c == '\"') res++ }; return res}