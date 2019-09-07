package com.cscs.customizeanalyzer;

import org.apache.lucene.analysis.Analyzer;

/**
 * @author jiangqw
 * @date 2019/9/6 14:53
 */
public class SubStringAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        return new TokenStreamComponents(
                new SubStringTokenizer()
        );
    }
}
