package main.Dictionary.Models

import main.Dictionary.Interfaces.IDictionary
import java.io.File

object HashDictionary : IDictionary {

    private val words = hashSetOf<String>()

    //beolvasas
    init {
        //read from file

        try{
            File(IDictionary.DICTIONARY_FILE).forEachLine { line ->
                words.add(line)
            }
        } catch(e:Exception){
            println(e)
        }
    }
    override fun add(word: String): Boolean {
        if(words.contains(word)){
            return false
        }else {
            words.add(word)
            return true
        }
    }

    override fun find(word: String): Boolean {
        //find word
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }

}