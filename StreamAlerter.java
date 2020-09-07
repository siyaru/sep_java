package com.example.talent.sep;

public class StreamAlerter {
    //private RingBuffer ring;
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
            currentNode = node;
            if(currentNode.getLeaf()){
                currentNode = this.trie;
                return true;
            }
        }
        return false;
    }
}
