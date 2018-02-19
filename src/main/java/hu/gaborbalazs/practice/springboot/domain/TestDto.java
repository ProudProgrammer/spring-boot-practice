package hu.gaborbalazs.practice.springboot.domain;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_NULL)
public class TestDto {

	private String stringField;
	private int intField;
	private String anotherStringField;

	public TestDto() {
	}

	public TestDto(String stringField, int intField) {
		super();
		this.stringField = stringField;
		this.intField = intField;
	}

	public String getStringField() {
		return stringField;
	}

	public void setStringField(String stringField) {
		this.stringField = stringField;
	}

	public int getIntField() {
		return intField;
	}

	public void setIntField(int intField) {
		this.intField = intField;
	}

	public String getAnotherStringField() {
		return anotherStringField;
	}

	public void setAnotherStringField(String anotherStringField) {
		this.anotherStringField = anotherStringField;
	}

	@Override
	public String toString() {
		return "TestDto [stringField=" + stringField + ", intField=" + intField + ", anotherStringField="
				+ anotherStringField + "]";
	}

}
