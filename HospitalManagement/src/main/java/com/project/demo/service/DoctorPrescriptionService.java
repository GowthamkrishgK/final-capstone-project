package com.project.demo.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.PrescribeRequest;
import com.project.demo.response.Prescriptionresponse;
import com.project.demo.repository.DoctorPrescriptionRepository;
import com.project.demo.repository.DoctorRepository;
import com.project.demo.repository.UserAppointmentRepository;

@Service
public class DoctorPrescriptionService {
@Autowired
private DoctorPrescriptionRepository prescription;
@Autowired
private UserAppointmentRepository appointmentrepo;
@Autowired
private DoctorRepository doctorRepo;
private final String  delimitors=",";

public UserAppointment addprescription(PrescribeRequest prescript) {
	  DoctorPrescription pres= prescript.toPrescription();
	  String patientname=prescript.getPatientname();
	  String doctorname=prescript.getDoctorname();
	  Doctor d=null;
	  UserAppointment a=null;
	  if(patientname!=null && doctorname!=null) {
	           d=doctorRepo.findbyEmail(doctorname);
	           a=appointmentrepo.findbyname(patientname);
	  }
	  
	           pres.setDoctor(d);
	          
	           pres.setIsAvailable(true);
	           if(a!=null) {
	           pres.setPatient(a);
	           a.setP(pres);
	           prescription.save(pres);
	           
	           }
	           return  appointmentrepo.save(a);
	 
}
public DoctorPrescription getprPrescriptionbyid(int id) {
	return prescription.findById(id).orElse(null);
}
public List<DoctorPrescription> getprPrescriptions(){
	return prescription.findAll();
}

public String deleteDoctorPrescription(int id) {
	prescription.deleteById(id);
	return "DoctorPrescription Removed "+id;
}

public Prescriptionresponse viewPrescription(String name) {
	String a=prescription.findbyPatientname(name);
	   String arr[]=a.split(delimitors);
	   Prescriptionresponse p=new Prescriptionresponse();
	   p.setPatientName(arr[0]);
	   p.setDescription(arr[1]);
	   p.setDoctorName(arr[2]);
	   p.setDoctoremail(arr[3]);
	  long phone= Long.parseLong(arr[4]);
	   p.setDoctorphone(phone);
	   p.setSymptoms(arr[5]);
	   return p;
	
			
}
}
