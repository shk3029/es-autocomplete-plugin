package org.elasticsearch.plugin.analysis;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.chosung.JavacafeChosungTokenFilterFactory;
import org.elasticsearch.index.analysis.jamo.JavacafeJamoTokenFilterFactory;
import org.elasticsearch.index.analysis.jamongram.JamoNgramTokenFilterFactory;
import org.elasticsearch.index.analysis.language.LanguageConvertFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Javacafe에서 개발한 필터 리스트
 *
 * @author hrkim
 */
public class JavacafePlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();

        // (1) 한글 자모 분석 필터
        extra.put("jamo_filter", JavacafeJamoTokenFilterFactory::new);

        // (2) 한글 초성 분석 필터
        extra.put("chosung_fliter", JavacafeChosungTokenFilterFactory::new);

        // (3) 영/한, 한/영 오타 변환 필터
        extra.put("language_filter", LanguageConvertFilterFactory::new);

        // (4) 자모 + gram 필터
        extra.put("jamo_ngram_filter", JamoNgramTokenFilterFactory::new);

        return extra;
    }

}



