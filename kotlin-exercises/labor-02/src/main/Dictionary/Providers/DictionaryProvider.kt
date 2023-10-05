package main.Dictionary.Providers

import main.Dictionary.Interfaces.IDictionary
import main.Dictionary.Models.DictionaryType
import main.Dictionary.Models.ListDictionary

class DictionaryProvider {
    companion object {
        fun createDictionary(type : DictionaryType) =
            when(type){
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.HASH_SET -> TODO()
                DictionaryType.TREE_SET -> TODO()
            }

    }
}