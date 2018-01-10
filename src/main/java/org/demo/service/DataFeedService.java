package org.demo.service;

import java.util.List;

import org.demo.model.Appointment;
import org.demo.repos.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataFeedService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public void updateAppointment(String orderRef, String paymentRef, boolean isSuccess) {
		List<Appointment> results = appointmentRepository.findFirstByOrderRef(orderRef);
		if(!results.isEmpty()) {
			Appointment appointment = results.get(0);
			appointment.setPaymentRef(paymentRef);
			if(isSuccess) {
				appointment.setStatus("Registered");
				
			} else {
				appointment.setStatus("Unsettled");
			}
			appointmentRepository.save(appointment);
		}
	}
}
