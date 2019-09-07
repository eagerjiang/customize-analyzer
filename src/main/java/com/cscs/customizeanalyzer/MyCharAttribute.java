package com.cscs.customizeanalyzer;

import org.apache.lucene.util.Attribute;
/**
 * @author jiangqw
 * @date 2019/9/6 15:07
 */
public interface MyCharAttribute extends Attribute {
    void setChars(char[] buffer, int length);

    char[] getChars();

    int getLength();

    String getString();
}
