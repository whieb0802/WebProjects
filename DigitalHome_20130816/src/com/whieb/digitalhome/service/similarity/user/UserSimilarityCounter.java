package com.whieb.digitalhome.service.similarity.user;

import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.service.similarity.user.collaborative.CollaborativeUserSimilarityCounter;

/**
 * @author Vicky 2012-8-14
 */
public class UserSimilarityCounter {
	private CollaborativeUserSimilarityCounter collaborative_counter;

	public CollaborativeUserSimilarityCounter getCollaborative_counter() {
		return collaborative_counter;
	}

	public void setCollaborative_counter(
			CollaborativeUserSimilarityCounter collaborative_counter) {
		this.collaborative_counter = collaborative_counter;
	}

	public double getCollaborativeSimilarity(UserId userId, UserId otherUserId) {
		return collaborative_counter.getSimilairty(userId, otherUserId);
	}
}
