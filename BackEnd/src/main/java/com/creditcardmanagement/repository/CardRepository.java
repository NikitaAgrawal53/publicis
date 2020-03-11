package com.creditcardmanagement.repository;

import com.creditcardmanagement.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long>{

}
