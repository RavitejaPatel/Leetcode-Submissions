class WordDictionary 
{   
    class TrieNode
    {
        private boolean endOfWord;
        private Map<Character, TrieNode> children;

        public TrieNode()
        {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;

    public WordDictionary() 
    {
        root = new TrieNode();
    }

    public void addWord(String word) 
    {
        TrieNode current = root;

        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);

            TrieNode node = current.children.get(c);

            if(node == null)
            {
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

      public boolean search(String word) 
    {
        return searchRecursive(word, root, 0);
    }

    private boolean searchRecursive(String word,TrieNode current, int index)
    {
        if(index == word.length())
        {
            return current.endOfWord;
        }
        char c = word.charAt(index);
        
        // Case 1: regular character
        if (c != '.') 
        {
            TrieNode node = current.children.get(c);
            if (node == null) 
                return false;
            return searchRecursive(word, node, index + 1);
        } 

        else
        {
            for (TrieNode child : current.children.values()) 
            {
                if (searchRecursive(word, child, index + 1)) 
                    return true;
            }
            
            return false;
        }
      
    }
}
