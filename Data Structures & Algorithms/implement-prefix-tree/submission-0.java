class PrefixTree 
{
   
    private class TrieNode
    {
        Boolean endOfWord;
        Map<Character, TrieNode> children;
        public TrieNode()
        {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    TrieNode root;

    public PrefixTree() 
    {
        root = new TrieNode();
    }

    public void insert(String word) // dog
    {
        TrieNode current = root;

        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null)
            {
                node = new TrieNode();
                current.children.put(c, node);
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
        
        TrieNode node = current.children.get(c);//dog
        if(node == null)
            return false;

        return searchRecursive(word, node, index+1);
    } 

    public boolean startsWith(String prefix) 
    {
        TrieNode current = root;

        for(int i=0;i<prefix.length();i++)  // do 
        {
            char c = prefix.charAt(i);//d 0
            TrieNode node = current.children.get(c);//
            
            if(node == null)
                return false;
            
            current = node;//0
        }
        return true;
    }
}
