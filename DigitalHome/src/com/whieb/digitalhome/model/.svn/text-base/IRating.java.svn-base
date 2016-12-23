package com.whieb.digitalhome.model;

import java.util.Date;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.Rating;

public class IRating extends Rating {
	private Long id;

	public IRating() {

	}

	public IRating(UserId userId, RatableItemId contentItemId, double value,
			double certainty, Date lastModification) {
		super(userId, contentItemId, value, certainty, lastModification);
	}

	public IRating(UserId user, RatableItemId contentItemId, double value,
			double certainty) {
		super(user, contentItemId, value, certainty, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	public void setRatableItemId(RatableItemId itemId) {
		this.ratableItemId = itemId;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

}
