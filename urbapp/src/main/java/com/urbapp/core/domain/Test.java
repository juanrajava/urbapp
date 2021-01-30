package com.urbapp.core.domain;

public class Test {

	public String value;

	public String getValue() {
		return value;
	}

	private Test(Test.Builder builder) {
		value = builder.value;
	}

	public static Test.Builder builder() {
		return new Test.Builder();
	}

	public static final class Builder {

		private String value;

		private Builder() {
		}

		public Test.Builder withValue(String val) {
			value = val;
			return this;
		}

		public Test build() {
			return new Test(this);
		}
	}

}
