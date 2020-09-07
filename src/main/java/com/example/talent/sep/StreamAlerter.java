package com.example.talent.sep;

public class StreamAlerter {
    private Trie trie;
    private Trie currentNode;

    public StreamAlerter(String[] strings) {
        this.trie = new Trie();
        for(String s : strings){
            Trie pointer = this.trie;
            for(int i = 0;i < s.length();i++){
                Trie node = pointer.getValue().get(s.charAt(i));
                if(node == null){
                    node = new Trie();
                    pointer.getValue().put(s.charAt(i),node);
                }
                pointer = node;
            }
            pointer.setLeaf(true);
        }
        this.currentNode = this.trie;
    }

    public boolean query(char ch) {
        Trie node = this.currentNode.getValue().get(ch);
        if(node != null){
            return moveNode(node);
        } else {
            //如果找不到的话，去根节点找
            Trie rootNode = this.trie.getValue().get(ch);
            if(rootNode != null){
                return moveNode(rootNode);
            }else{
                this.currentNode = this.trie;
            }
        }
        return false;
    }

    private boolean moveNode(Trie rootNode) {
        if(rootNode.getLeaf()){
            this.currentNode = this.trie;
            return true;
        }else{
            this.currentNode = rootNode;
            return false;
        }
    }
}
