package data_structures.examples.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    // trie data structure is generally in the form of 
    // hash table rather than a tree data structure.
    Map<Character, TrieNode> children;
    boolean endOfString;

    public TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}
