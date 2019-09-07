package com.cscs.customizeanalyzer;

import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;

/**
 * @author jiangqw
 * @date 2019/9/6 14:56
 */
public final class SubStringTokenizer extends Tokenizer {

    private MyCharAttribute charAttr = this.addAttribute(MyCharAttribute.class);

    private char[] buffer = new char[255];
    private int count = 0;

    @Override
    public boolean incrementToken() throws IOException {
        // 清除所有的词项属性
        clearAttributes();
        int length = 0;
        int start = 9;
        int end = 18;
        while (true) {
            int c = this.input.read();
            count++;

            if (c == -1) {
                if (length > 0) {
                    // 复制到charAttr
                    this.charAttr.setChars(buffer, length);
                    return true;
                } else {
                    return false;
                }
            }

            if (count >= end) {
                if (length > 0) {
                    // 复制到charAttr
                    this.charAttr.setChars(buffer, length);
                    return true;
                } else {
                    return false;
                }
            }

            if (start <= count) {
                buffer[length++] = (char) c;
            }
        }
    }
}
