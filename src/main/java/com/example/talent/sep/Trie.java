package com.example.talent.sep;

import java.util.HashMap;

public class Trie {
    private Boolean isLeaf = false;
    private HashMap<Character, Trie> value;

    public Trie() {
        this.value = new HashMap<Character, Trie>();
    }

    public Boolean getLeaf() {
        return isLeaf;
    }

    public void setLeaf(Boolean leaf) {
        isLeaf = leaf;
    }

    public HashMap<Character, Trie> getValue() {
        return value;
    }

    public void setValue(HashMap<Character, Trie> value) {
        this.value = value;
    }
}
