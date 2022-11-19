package org.elasticsearch.index.analysis.jamongram;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.analysis.jamo.JavacafeJamoTokenFilter;

public class JamoNgramTokenFilterFactory extends AbstractTokenFilterFactory {


    public JamoNgramTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream stream) {
        return new JamoNgramTokenFilter(stream);
    }

    
    
}
