package cz.karan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.karan.jba.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}