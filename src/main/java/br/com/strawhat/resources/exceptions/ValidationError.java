package br.com.strawhat.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, Long timeStemp) {
		super(status, msg, timeStemp);

	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String name, String message) {
		errors.add(new FieldMessage(name, message));
	}

}
