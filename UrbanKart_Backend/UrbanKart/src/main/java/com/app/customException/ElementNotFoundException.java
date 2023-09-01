package com.app.customException;

@SuppressWarnings("serial")
public class ElementNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String elementName;
	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public ElementNotFoundException(String name, String errorCode, String errorMessage) {
		super();
		this.elementName = name;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ElementNotFoundException() {
		super();
	}

}