class WordDictionary 
{
    private class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean endOfTheWord;

        public TrieNode()
        {
            children = new HashMap<>();
            endOfTheWord = false;
        }
    }

    TrieNode root;
    public WordDictionary() 
    {
        root = new TrieNode();
    }

    public void addWord(String word) 
    {
        TrieNode currNode = root;

        for(int i=0;i<word.length();i++)
        {
            char curr = word.charAt(i);
            TrieNode node = currNode.children.get(curr);

            if(node == null)
            {
                node = new TrieNode();
                currNode.children.put(curr,node);
            }
            currNode = node;
        }
        currNode.endOfTheWord = true;
    }

    public boolean search(String word) 
    {
        return searchRecursive(word,0,root);
    }

    private boolean searchRecursive(String word, int idx, TrieNode currNode)
    {
        if(idx == word.length())
        {
            return currNode.endOfTheWord;
        }
        
        char currChar = word.charAt(idx);
        //if(currChar == '.')

        if(currChar != '.' )
        {
            TrieNode node = currNode.children.get(currChar);

            if(node == null)
                return false;

            return searchRecursive(word,idx+1,node);
        }
        else
        {
            for(TrieNode child : currNode.children.values())
            {
                // if(searchRecursive(word,idx+1,child))
                //     return true;
                return searchRecursive(word,idx+1,child);
            }
            // return false;
        }
        return false;
        
    }
}
