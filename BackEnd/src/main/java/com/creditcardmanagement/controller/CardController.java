package com.creditcardmanagement.controller;

import com.creditcardmanagement.model.Card;
import com.creditcardmanagement.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*" , allowedHeaders = "*")
@RestController		// Useful to create the RESTful webservices.
public class CardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	// @Autowired annotation provides the automatic dependency injection.
	@Autowired
	CardService cardService;

	// Add card entity in the h2 database.
	// @PostMapping annotation handles the http post request matched with the given uri.
	// @RequestBody annotation binds the http request body to the domain object.
	// @Valid annotation validates a model after binding the user input to it.
	@PostMapping(value= "/card/add")
	public Long save(final @RequestBody @Valid Card card) {
		log.info("Adding card details in the database.");
		cardService.save(card);
		return card.getCardNumber();
	}

	// Get all card details from the h2 database.
	// @GetMapping annotation handles the http get request matched with the given uri.
	@GetMapping(value= "/card/getall", produces= "application/vnd.jcg.api.v1+json")
	public List<Card> getAll() {
		log.info("Getting Card details from the database.");
		return cardService.getAll();
	}
}
