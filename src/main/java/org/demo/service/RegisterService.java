package org.demo.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.demo.model.Appointment;
import org.demo.model.RegisterResult;
import org.demo.repos.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
	private static AtomicInteger orderNo = new AtomicInteger(1);

	@Autowired
	private AppointmentRepository appointmentRepository;

	public RegisterResult register(String userId, String location) {
		List<Appointment> results = appointmentRepository.findFirstByUserIdAndLocation(userId, location);

		RegisterResult registerResult = new RegisterResult("Error", "", -1.0);
		if (!results.isEmpty()) {
			Appointment appointment = results.get(0);
			appointment.setOrderRef(generateOrderRef());
			appointment.setStatus("Arrived");
			registerResult = new RegisterResult("Success", appointment.getOrderRef(), appointment.getFee());
			appointmentRepository.save(appointment);
		}

		return registerResult;
	}
	
	private String generateOrderRef() {
		return "INV18" + String.format("%05d", orderNo.getAndIncrement());
	}
}
