package com.whieb.digitalhome.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

/**
 * @author Vicky 2012-8-11
 */
public class AnalyzerUtil {

	public static PaodingAnalyzer analyzer = new PaodingAnalyzer();;

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

	public static Map<String, Integer> analysisContent(String content) {
		TokenStream token = analyzer.tokenStream(content, new StringReader(
				content));
		Map<String, Integer> maps = new HashMap<String, Integer>();
		Token t;
		try {
			t = token.next();
			while (t != null) {
				String term = t.termText();
				Integer frequency = maps.get(term);
				if (CheckWordUtil.checkWord(term)) {// 检查是否需要
					if (frequency != null) {
						maps.put(term, frequency + 1);
					} else {
						maps.put(term, 1);
					}
				}
				t = token.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return maps;
	}
}
