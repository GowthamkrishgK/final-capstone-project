package com.project.demo.requests;

import org.springframework.boot.jackson.JsonComponent;

import com.project.demo.model.DoctorPrescription;
@JsonComponent
public class PrescribeRequest {

		
		private String patientname;
		private String description;
		private String  doctorname;
		public String getPatientname() {
			return patientname;
		}
		public void setPatientname(String patientname) {
			this.patientname = patientname;
		}
		public String getDoctorname() {
			return doctorname;
		}
		public void setDoctorname(String doctorname) {
			this.doctorname = doctorname;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public DoctorPrescription toPrescription() {
			DoctorPrescription p=new DoctorPrescription();
			p.setDescription(description);
			return p;
		}
	}


