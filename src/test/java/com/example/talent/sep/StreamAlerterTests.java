package com.example.talent.sep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class StreamAlerterTests {

    @DisplayName("检查字符流中的敏感词")
    @Test
    public void testQuery() {
        StreamAlerter as = new StreamAlerter(new String[]{"赌博", "游戏", "摇头丸", "XXX"});
        assertFalse(as.query('a'));
        assertFalse(as.query('赌'));
        assertTrue(as.query('博'));
        assertFalse(as.query('游'));
        assertTrue(as.query('戏'));
        assertFalse(as.query('摇'));
        assertFalse(as.query('头'));
        assertTrue(as.query('丸'));
        assertFalse(as.query('X'));
        assertFalse(as.query('X'));
        assertTrue(as.query('X'));
    }

    @DisplayName("检查很长时间的字符流")
    @Test
    public void testLongTimeQuery() {
        StreamAlerter as = new StreamAlerter(new String[]{"abc", "xyz"});
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 1_000_000_000; i++) { // Integer.MAX_VALUE
            char ch = (char) ('a' + random.nextInt(26));
            if (as.query(ch)) count += 1;
        }
        // TODO 按照您的实际情况写运行时间，并在提交时说明这两种情况下耗时情况
        // on my Laptop,
        // total time is about 25s, Random use 11s, Trie+Ring use 14s
        assertNotEquals(0, count); // count > 0
    }
}

