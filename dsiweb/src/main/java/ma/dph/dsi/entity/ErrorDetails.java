/**
 * 
 */
package ma.dph.dsi.entity;

/**
 * @author vsubramaniyan
 *
 */
public class ErrorDetails {
	
	String errorMessage;
	String errorCode;
	String errorForwardPage;
	
	

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorForwardPage() {
		return errorForwardPage;
	}
	public void setErrorForwardPage(String errorForwardPage) {
		this.errorForwardPage = errorForwardPage;
	}

	
	@Override
	public String toString() {
		return "ErrorDetails [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", errorForwardPage="
				+ errorForwardPage + "]";
	}
}
