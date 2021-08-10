package data_structures.examples.trie;

public class Trie {
    private TrieNode root;

    // creating an object of Trie class creates a Trie
    public Trie() {
        root = new TrieNode();
        System.out.println("Trie has been created.");
    }

    // inserting a string
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            // if the node doesn't exist, then create one
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Word successfully inserted " + word + " to trie");
    }

    // Searching for string
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            // checks all the characters. if null, then the word doesn't exist
            if (node == null) {
                System.out.println(word + " doesn't exist in trie");
                return false;
            }
            currentNode = node;
        }
        if (currentNode.endOfString) {
            System.out.println(word + " exists in trie");
            return true;
        } else {
            System.out.println(word + " is a prefix of another word.");
        }
        return currentNode.endOfString;
    }

    // helper method for delete
    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canBeDeleted;

        // case 1: the prefix of current word is prefix of another word
        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index + 1);
            return false;
        }

        // case 2: we are at the last character of this word.
        // and this word is prefix of some other word.
        if (index == word.length() - 1) {
            if (currentNode.children.size() >= 1) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        // case 3: 
        if (currentNode.endOfString == true) {
            delete(currentNode, word, index + 1);
            return false;
        }
        canBeDeleted = delete(currentNode, word, index + 1);
        if (canBeDeleted) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }
    
    // callable delete mathod
    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
            System.out.println("deleted " + word);
        }
    }
}