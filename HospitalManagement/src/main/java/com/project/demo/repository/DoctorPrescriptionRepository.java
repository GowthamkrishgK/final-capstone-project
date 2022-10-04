package com.project.demo.repository;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface DoctorPrescriptionRepository extends JpaRepository<DoctorPrescription, Integer> {
	

    @Transactional
	@Query("select patient.Patientname,dp.description,doctor.name,doctor.email,doctor.phone,patient.symptoms from DoctorPrescription dp LEFT JOIN Doctor doctor ON doctor.docid=dp.doctor.docid LEFT JOIN UserAppointment patient On patient.Patientname=dp.patient.Patientname where dp.patient.Patientname=?1 ")
	String findbyPatientname(String name);
}
