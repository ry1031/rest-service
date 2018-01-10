package org.demo.repos;

import java.util.List;

import org.demo.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "appointment", path = "appointment")
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
	List<Appointment> findFirstByUserIdAndLocation(@Param("userId") String userId, @Param("location") String location);
	List<Appointment> findFirstByOrderRef(@Param("orderRef") String orderRef);
}
