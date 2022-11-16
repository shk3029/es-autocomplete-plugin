package org.elasticsearch.index.analysis.language;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.converter.LanguageConverter;

import java.io.IOException;

public class LanguageConvertFilter extends TokenFilter {

    private LanguageConverter languageConverter;
    private CharTermAttribute termAttribute;

    public LanguageConvertFilter(TokenStream tokenStream) {
        super(tokenStream);
        this.languageConverter = new LanguageConverter();
        this.termAttribute = addAttribute(CharTermAttribute.class);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if(input.incrementToken()) {
            CharSequence parsedData = languageConverter.convert(termAttribute.toString());
            termAttribute.setEmpty();
            termAttribute.append(parsedData);
            return true;
        }
        return false;
    }
}
