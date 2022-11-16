package org.elasticsearch.index.common.converter;

import org.elasticsearch.index.common.util.language.KorToEngInfo;

import static org.elasticsearch.index.common.util.language.EngToKorInfo.*;
import static org.elasticsearch.index.common.util.language.KorToEngInfo.*;
import static org.elasticsearch.index.common.util.language.KorUnicodeInfo.UNICODE_JONG_SUNG_COUNT;
import static org.elasticsearch.index.common.util.language.KorUnicodeInfo.UNICODE_JUNG_SUNG_COUNT;

public class LanguageConverter {

    public String convert(String token) {
        StringBuilder result = new StringBuilder();
        String keyword = token.trim();

        if (keyword.matches(".*[가-힣]+.*")) {
            result.append(convertKorToEng(keyword));
        } else {
            result.append(convertEngToKor(keyword));
        }

        return result.toString();
    }

    // 한->영
    private StringBuilder convertKorToEng(String keyword) {
        StringBuilder builder = new StringBuilder();

        for (int idx = 0; idx < keyword.length(); idx++) {
            String str = String.valueOf(keyword.charAt(idx));

            if (str.matches(".*[가-힣]+.*")) {
                int baseCode = str.charAt(0) - KorToEngInfo.FIRST_KOREAN;
                int chosungIndex = baseCode / (UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT);
                int jungsungIndex =
                        (baseCode - ((UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT) * chosungIndex)) / UNICODE_JONG_SUNG_COUNT;
                int jongsungIndex = (baseCode - ((UNICODE_JONG_SUNG_COUNT * UNICODE_JUNG_SUNG_COUNT) * chosungIndex) - (
                        UNICODE_JONG_SUNG_COUNT * jungsungIndex));

                builder.append(arrChoSungEng[chosungIndex] + arrJungSungEng[jungsungIndex]);
                if (jongsungIndex > 0) {
                    builder.append(arrJongSungEng[jongsungIndex]);
                }
            } else {
                builder.append(keyword.charAt(idx));
            }
        }
        return builder;
    }

    // 영->한
    private StringBuilder convertEngToKor(String keyword) {
        StringBuilder builder = new StringBuilder();

        for (int idx = 0; idx < keyword.length(); idx++) {
            String str = String.valueOf(keyword.charAt(idx));

            if (str.matches("^[a-zA-Z+]*$")) {
                String replaceKor = "";
                for (int i = 0; i < KEYBOARD_KEY_ENG.length; i++) {
                    if (!UPPER_SET.contains(str)) str = str.toLowerCase();
                    if (str.equals(KEYBOARD_KEY_ENG[i])) replaceKor = KEYBOARD_KEY_KOR[i];
                }

                if (!replaceKor.isEmpty()) {
                    builder.append(replaceKor);
                }

            } else {
                builder.append(keyword.charAt(idx));
            }
        }
        return builder;
    }
}
