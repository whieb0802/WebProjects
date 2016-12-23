package com.whieb.digitalhome.model;

import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.usersimilarity.UserSimilarity;

/**
 * 
 * @author Vicky
 *
 */
public class CollaborativeUserSimilarity extends UserSimilarity {
	private Long id;

	public CollaborativeUserSimilarity() {
		super();
	}

	public CollaborativeUserSimilarity(UserId userId, UserId otherUserId) {
		super(userId, otherUserId);
	}

	
	public CollaborativeUserSimilarity(UserId userId, UserId otherUserId,
			double similarity, int sampleSize) {
		super(userId, otherUserId, similarity, sampleSize);
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

	public void setOtherUserId(UserId otherUserId) {
		this.otherUserId = otherUserId;
	}
}
