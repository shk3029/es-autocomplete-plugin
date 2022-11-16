package org.elasticsearch.plugin.utilTest;

import org.elasticsearch.index.common.converter.LanguageConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LanguageConverterTest {

    private LanguageConverter languageConverter;
    private String[] keywords;
    private String[] results;

    @Test
    public void convert() {
        languageConverter = new LanguageConverter();
        keywords = new String[]{"audtptj", "zkemrufwp", "카드결제", "명세서", "카드123", "!@#1923", "nike", "NIKE", "apple", "xptmxm", "1emd!@#Thzk"};
        results = new String[]{"ㅁㅕㅇㅅㅔㅅㅓ", "ㅋㅏㄷㅡㄱㅕㄹㅈㅔ", "zkemrufwp", "audtptj", "zkem123", "!@#1923", "ㅜㅑㅏㄷ", "ㅜㅑㅏㄸ", "ㅁㅔㅔㅣㄷ", "ㅌㅔㅅㅡㅌㅡ", "1ㄷㅡㅇ!@#ㅆㅗㅋㅏ"};

        for (int i = 0; i < keywords.length; i++) {
            System.out.println(results[i] + " " + languageConverter.convert(keywords[i]));
            assertEquals(results[i], languageConverter.convert(keywords[i]));
        }
    }
}