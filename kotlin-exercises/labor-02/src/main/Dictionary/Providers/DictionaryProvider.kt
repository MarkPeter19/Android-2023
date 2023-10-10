package main.Dictionary.Providers

import main.Dictionary.Interfaces.IDictionary
import main.Dictionary.Models.DictionaryType
import main.Dictionary.Models.HashDictionary
import main.Dictionary.Models.ListDictionary
import main.Dictionary.Models.TreeDictionary

class DictionaryProvider {
    companion object {
        fun createDictionary(type : DictionaryType) =
            when(type){
                DictionaryType.ARRAY_LIST -> ListDictionary
                DictionaryType.HASH_SET -> HashDictionary
                DictionaryType.TREE_SET -> TreeDictionary
            }

    }
}