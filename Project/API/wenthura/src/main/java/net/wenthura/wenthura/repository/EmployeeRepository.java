package net.wenthura.wenthura.repository;


import net.wenthura.wenthura.model.Employee;
import net.wenthura.wenthura.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("FROM  Employee e WHERE e.edesig ='Event Planner'")
    List<Employee> FindAllPlanners();

}
