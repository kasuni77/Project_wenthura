package net.wenthura.wenthura.repository;


import net.wenthura.wenthura.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

@Query("FROM  Event e WHERE e.eStatus ='Published'")
List<Event> FindNewEvents();

@Query("FROM  Event e WHERE  e.eStatus ='In Progress' OR e.eStatus ='Canceled' OR e.eStatus ='Completed'")
List<Event> FindAllEvents();
}
