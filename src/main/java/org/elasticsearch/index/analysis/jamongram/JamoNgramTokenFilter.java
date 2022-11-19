package org.elasticsearch.index.analysis.jamongram;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.parser.KoreanJamoParser;

import java.io.IOException;

/**
 * 한글 자모 분석 필터
 *
 * @author hrkim
 *
 */
public final class JamoNgramTokenFilter extends TokenFilter {

    private KoreanJamoParser parser;
    private CharTermAttribute termAtt;


    public JamoNgramTokenFilter(TokenStream stream) {
        super(stream);
        this.parser = new KoreanJamoParser();
        this.termAtt = addAttribute(CharTermAttribute.class);
    }

    
    /**
     * 한글 자모 Parser를 이용하여 토큰을 파싱하고 Term을 구한다. 
     */
    @Override
    public boolean incrementToken() throws IOException {
        
        if (input.incrementToken()) {
            CharSequence parserdData = parser.parse(termAtt.toString());
            termAtt.setEmpty();
            termAtt.append(parserdData);
        
            return true;
        }
        
        return false;
    }
    
    
}
