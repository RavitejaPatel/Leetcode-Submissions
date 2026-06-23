class PrefixTree 
{
    class TrieNode
    {
        Map<Character,TrieNode> children;
        boolean endOfTheWord;

        public TrieNode()
        {
            children = new HashMap<>();
            endOfTheWord = false;
        }
    }

    TrieNode root;

    public PrefixTree() 
    {
        root = new TrieNode();
    }

    public void insert(String word) 
    {
        TrieNode currentNode = root;

        for(int i=0;i<word.length();i++)
        {
            char curr = word.charAt(i);
            TrieNode node = currentNode.children.get(curr);

            if(node == null)
            {
                node = new TrieNode();
                currentNode.children.put(curr, node);
            }
           // currentNode.children.put(curr,node);
            currentNode = node;
        }
        currentNode.endOfTheWord = true;
    }

    public boolean search(String word) 
    {
        return searchRecursive(word,0,root);
    }

    private boolean searchRecursive(String word, int idx, TrieNode currNode)
    {
        if(idx == word.length())
        {
            return currNode.endOfTheWord == true;
        }

        char curr = word.charAt(idx);
        TrieNode node = currNode.children.get(curr);

        if(node == null)
            return false;

        return searchRecursive(word,idx+1,node);
    }

    public boolean startsWith(String prefix) 
    {
        TrieNode currNode = root;

        for(int i=0;i<prefix.length();i++)
        {
            char curr = prefix.charAt(i);
            TrieNode node = currNode.children.get(curr);

            if(node == null)
                return false;

            currNode = node;
        }

        return true;
    }
}
