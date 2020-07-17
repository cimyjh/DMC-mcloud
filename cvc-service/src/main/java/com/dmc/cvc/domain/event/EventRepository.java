package com.dmc.cvc.domain.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer>, EventRepositoryCustom  {
	
	@Query("select e from Event e where e.store = :store")
	List<Event> findByStore(@Param("store") String store);

}
