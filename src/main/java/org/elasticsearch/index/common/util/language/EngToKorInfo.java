package org.elasticsearch.index.common.util.language;

import java.util.HashSet;
import java.util.Set;

public class EngToKorInfo {

    /**
     * 쌍자음, 이중모음
     */
    public static final Set<String> UPPER_SET = new HashSet<String>() {
        {
            add("Q");
            add("W");
            add("E");
            add("R");
            add("T");
            add("O");
            add("P");
        }
    };

    /**
     * 키보드상에서 한영키에 의해서 오타 교정이 필요한 키배열
     */
    public static final String[] KEYBOARD_KEY_ENG = {
            "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "Q", "W", "E", "R", "T", "O", "P"
    };

    /**
     * 키보드상에서 한영키에 의해서 오타 교정이 필요한 키배열
     */
    public static final String[] KEYBOARD_KEY_KOR = {
            "ㅁ", "ㅠ", "ㅊ", "ㅇ", "ㄷ",
            "ㄹ", "ㅎ", "ㅗ", "ㅑ", "ㅓ",
            "ㅏ", "ㅣ", "ㅡ", "ㅜ", "ㅐ",
            "ㅔ", "ㅂ", "ㄱ", "ㄴ", "ㅅ",
            "ㅕ", "ㅍ", "ㅈ", "ㅌ", "ㅛ", "ㅋ",
            "ㅃ", "ㅉ", "ㄸ", "ㄲ", "ㅆ", "ㅒ", "ㅖ"
    };

}
