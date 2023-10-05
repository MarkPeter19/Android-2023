package main

import main.Dictionary.Interfaces.IDictionary
import main.Dictionary.Models.DictionaryType
import main.Dictionary.Providers.DictionaryProvider

fun main(){
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}
