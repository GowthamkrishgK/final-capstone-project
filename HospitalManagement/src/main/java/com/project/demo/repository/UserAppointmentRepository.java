package com.project.demo.repository;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface UserAppointmentRepository extends JpaRepository<UserAppointment, String> {
	
	
	
	@Query("select u from UserAppointment u where u.Patientname=?1")
	  UserAppointment findbyname(String name);

	@Query("select u.Patientname,u.symptoms,u.date,doctor.name,dp.isAvailable  from UserAppointment u left join Doctor doctor on doctor.docid=u.doctor.docid left join DoctorPrescription dp on dp.prescriptionid=u.p.prescriptionid ")
       List<String> getAppointments();      
	@Query("delete from UserAppointment u where u.Patientname=?1")
	void deleteAppointment(String name);
}
