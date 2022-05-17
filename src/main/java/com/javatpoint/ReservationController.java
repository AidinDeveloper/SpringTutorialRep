package com.javatpoint;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class ReservationController {
	@RequestMapping("/bookingForm")
	public String bookingForm(Model model) {
		// create a reservation object
		Reservation res = new Reservation();
		res.setFirstName("Aidin");
		// provide reservation object to the model
		model.addAttribute("reservation", res);
		System.out.println("Created Object is : " + res);
		return "reservation-page";
	}

	@RequestMapping("/submitForm")
	// @ModelAttribute binds form data to the object
	public String submitForm(@ModelAttribute("reservation") Reservation res) {
		System.out.println("Received Object is : " + res);
		//Infact a new Object is created for Reservation and the info is set into it after clicking submit, this object is different than the one created in the line 14.  
		return "confirmation-page";
	}
}