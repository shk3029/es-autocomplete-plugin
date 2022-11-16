package org.elasticsearch.index.common.util.language;

public class KorToEngInfo {
    // First '가' : 0xAC00(44032), 끝 '힟' : 0xD79F(55199)
    public static final int FIRST_KOREAN = 44032;

    // 초성
    public static final String[] arrChoSungEng = {"r", "R", "s", "e", "E",
            "f", "a", "q", "Q", "t", "T", "d", "w",
            "W", "c", "z", "x", "v", "g"};

    // 중성
    public static final String[] arrJungSungEng = {"k", "o", "i", "O",
            "j", "p", "u", "P", "h", "hk", "ho", "hl",
            "y", "n", "nj", "np", "nl", "b", "m", "ml",
            "l"};

    // 종성
    public static final String[] arrJongSungEng = {"", "r", "R", "rt",
            "s", "sw", "sg", "e", "f", "fr", "fa", "fq",
            "ft", "fx", "fv", "fg", "a", "q", "qt", "t",
            "T", "d", "w", "c", "z", "x", "v", "g"};

    // 단일자음
    public static final String[] arrSingleJaumEng = {"r", "R", "rt",
            "s", "sw", "sg", "e", "E", "f", "fr", "fa", "fq",
            "ft", "fx", "fv", "fg", "a", "q", "Q", "qt", "t",
            "T", "d", "w", "W", "c", "z", "x", "v", "g"};

}
