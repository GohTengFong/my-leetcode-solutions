// 3rd Method improve

class Trie {

    class Node {
        boolean endOfWord = false;
        Node[] nodes;
    }
    
    Node[] prefixTree;
    
    /** Initialize your data structure here. */
    public Trie() {
        
        prefixTree = new Node[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        insert(prefixTree, word, 0);
    }
    
    private void insert(Node[] nodes, String word, int index) {
                
        int nodeIndex = word.charAt(index) - 'a';
        
        if (nodes[nodeIndex] == null)
        nodes[nodeIndex] = new Node();
        
        if (index == word.length()-1) {
            
            nodes[nodeIndex].endOfWord = true;
            return;
        }
        
        if (nodes[nodeIndex].nodes == null)
        nodes[nodeIndex].nodes = new Node[26];
        
        insert(nodes[nodeIndex].nodes, word, index+1);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return search(prefixTree, word, 0, false);
    }
    
    private boolean search(Node[] nodes, String word, int index, boolean partialSearch) {
                        
        int nodeIndex = word.charAt(index) - 'a';
        
        if (nodes[nodeIndex] == null) return false;
        
        if (index == word.length()-1) {
            
            return partialSearch || nodes[nodeIndex].endOfWord;
        }
        
        if (nodes[nodeIndex].nodes == null) return index > word.length()-1;
        
        return search(nodes[nodeIndex].nodes, word, index+1, partialSearch);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        return search(prefixTree, prefix, 0, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */