package data_structures.examples.trie;

public class Main {
    public static void main(String[] args) {
        Trie newTrie = new Trie();
        newTrie.insert("APP");
        newTrie.insert("APPS");
        newTrie.insert("BANKS");

        newTrie.search("APPS");
        newTrie.search("APP");
        newTrie.search("BA");
        newTrie.search("APS");

        newTrie.delete("NOPE");
    }
}
