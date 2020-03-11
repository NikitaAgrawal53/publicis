package com.creditcardmanagement.service;

import com.creditcardmanagement.model.Card;
import com.creditcardmanagement.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	CardRepository cardRepository;

	// Save Card details in the h2 database.
	public void save(final Card card) {
		cardRepository.save(card);
	}

	// Get all cards from the h2 database.
	public List<Card> getAll() {
		final List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(card -> cards.add(card));
		return cards;
	}
}
