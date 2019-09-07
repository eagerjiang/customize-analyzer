package com.cscs.customizeanalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.junit.Test;

import java.io.IOException;

/**
 * @author jiangqw
 * @date 2019/9/6 15:15
 */
public class AnalyzerTest {
    @Test
    public void test() {
        String text = "aadfdfdafdaf";
        try {
            Analyzer ana = new SubStringAnalyzer();
            TokenStream ts = ana.tokenStream("aa", text);
            MyCharAttribute ca = ts.getAttribute(MyCharAttribute.class);
            ts.reset();
            while (ts.incrementToken()) {
                System.out.print(ca.getString() + "|");
            }
            ts.end();
            ana.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
