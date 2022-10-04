package com.project.demo.requests;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class viewRequest {
private String Patientname;

public String getPatientname() {
	return Patientname;
}

public void setPatientname(String patientname) {
	Patientname = patientname;
}


}
