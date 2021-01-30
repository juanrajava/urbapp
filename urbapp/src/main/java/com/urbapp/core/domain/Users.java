package com.urbapp.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {

	@JsonProperty("id")
	public Integer id;

	@JsonProperty("username")
	public String username;

	@JsonProperty("password")
	@JsonInclude(Include.NON_NULL)
	public String password;

	@JsonProperty("email")
	public String email;

	@JsonProperty("created_on")
	public String createdOn;

	@JsonProperty("last_login")
	@JsonInclude(Include.NON_NULL)
	public String lastLogin;

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	private Users(Users.Builder builder) {
		id = builder.id;
		username = builder.username;
		password = builder.password;
		email = builder.email;
		createdOn = builder.createdOn;
		lastLogin = builder.lastLogin;
	}

	public static Users.Builder builder() {
		return new Users.Builder();
	}

	public static final class Builder {

		private Integer id;
		private String username;
		private String password;
		private String email;
		private String createdOn;
		private String lastLogin;

		private Builder() {
		}

		public Users.Builder withId(Integer val) {
			id = val;
			return this;
		}

		public Users.Builder withUsername(String val) {
			username = val;
			return this;
		}

		public Users.Builder withPassword(String val) {
			password = val;
			return this;
		}

		public Users.Builder withEmail(String val) {
			username = val;
			return this;
		}

		public Users.Builder withCreatedOn(String val) {
			createdOn = val;
			return this;
		}

		public Users.Builder withLastLogin(String val) {
			lastLogin = val;
			return this;
		}

		public Users build() {
			return new Users(this);
		}
	}

}
