package com.whieb.digitalhome.service.similarity.item.contentbased;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.whieb.digitalhome.util.CosineSimilarityMeasure;

/**
 * 计算基于内容的相似度算法
 * 
 * @author Vicky
 * 
 */
public class ContentAlgorithm {

	private CosineSimilarityMeasure consine;

	public CosineSimilarityMeasure getConsine() {
		return consine;
	}

	public void setConsine(CosineSimilarityMeasure consine) {
		this.consine = consine;
	}

	public double calculate(Map<String, Double> value01,
			Map<String, Double> value02) {
		if (null == value01 || value01.size() == 0 || null == value02
				|| value02.size() == 0) {
			return 0.00;
		}
		Set<String> s1 = value01.keySet();
		Set<String> s2 = value02.keySet();

		Set<String> all = getAll(s1, s2);

		double[] d1 = getTermVector(value01, all);
		double[] d2 = getTermVector(value02, all);
		return consine.calculate(d1, d2);
	}

	public double calculate(Collection<String> v1, Collection<String> v2) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.addAll(v1);
		s2.addAll(v2);
		Set<String> all = getAll(s1, s2);
		double[] d1 = getTermVector(s1, all);
		double[] d2 = getTermVector(s2, all);
		for (Double d : d1) {
			System.out.print(d + "  ");
		}
		System.out.println();
		for (Double d : d2) {
			System.out.print(d + "  ");
		}
		System.out.println();
		return consine.calculate(d1, d2);
	}

	public Set<String> getAll(Set<String> s1, Set<String> s2) {
		Set<String> all_set = new HashSet<String>();
		all_set.addAll(s1);
		all_set.addAll(s2);
		return all_set;
	}

	public double[] getTermVector(Map<String, Double> term, Set<String> all) {
		double[] termVector = new double[all.size()];
		int i = 0;
		for (String s : all) {
			if (term.containsKey(s)) {
				termVector[i] = term.get(s);
			} else {
				termVector[i] = 0;
			}
			i++;
		}
		return termVector;
	}

	public double[] getTermVector(Collection<String> term, Set<String> all) {
		double[] termVector = new double[all.size()];
		int i = 0;
		for (String s : all) {
			if (term.contains(s)) {
				termVector[i] = 1;
			} else {
				termVector[i] = 0;
			}
			i++;
		}
		return termVector;
	}

	public static void main(String[] args) {
		ContentAlgorithm al = new ContentAlgorithm();
		CosineSimilarityMeasure consine = new CosineSimilarityMeasure();
		al.setConsine(consine);

	}
}
