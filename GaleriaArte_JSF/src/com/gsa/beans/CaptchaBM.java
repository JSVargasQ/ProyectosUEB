package com.gsa.beans;

import java.awt.event.ActionEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CaptchaBM {
	public void check(ActionEvent e)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Your Code is correct!",null));
	}
}