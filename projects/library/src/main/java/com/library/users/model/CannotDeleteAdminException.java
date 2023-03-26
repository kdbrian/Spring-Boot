package com.library.users.model;

public class CannotDeleteAdminException extends RuntimeException {

	public CannotDeleteAdminException() {
		super("not authorized to delete an admin yet");
	}
}
