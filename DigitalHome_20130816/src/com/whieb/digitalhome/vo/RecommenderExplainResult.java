package com.whieb.digitalhome.vo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.whieb.digitalhome.model.Item;

/**
 * @author Vicky 2012-8-17
 */
@Root
public class RecommenderExplainResult {
	@Element(required = false)
	private Item item;
	@Element(required = false)
	private String explain;

	public RecommenderExplainResult() {
		super();
	}

	public RecommenderExplainResult(Item item, String explain) {
		super();
		this.item = item;
		this.explain = explain;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

}
