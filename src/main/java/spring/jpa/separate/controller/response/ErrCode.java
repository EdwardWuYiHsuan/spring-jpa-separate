package spring.jpa.separate.controller.response;

public enum ErrCode {

	SUCCESS("0000", "Success"),
	UNKNOWN_ERROR("0001", "System error, please contact administrator"),
	WRONG_JSON_FORMAT("0002", "Wrong JSON format"),
	
	MISSING_ARG("1000", "Missing argument"),
	MISSING_ARG_CARD_NUM("1001", "Missing argument : cardNumber"),
	MISSING_ARG_KERNEL_TRANS_ID("1002", "Missing argument : kernelTransId"),
	MISSING_ARG_CARD_IDENTITY_NUM("1003", "Missing argument : cardNumber or identityNumber"),
	MISSING_ARG_INTEGRATOR_ID("1004", "Missing argument : integratorId"),
	MISSING_ARG_MERCHANT_ID("1005", "Missing argument : merchantId"),
	MISSING_ARG_AMOUNT("1006", "Missing argument : amount"),
	MISSING_ARG_AUTH_ID("1007", "Missing argument : authId"),
	MISSING_ARG_OTP_AUTH_CODE("1008", "Missing argument : otpAuthCode"),
	MISSING_ARG_CARD_HOLDER_ID("1009", "Missing argument : cardHolderId"),
	MISSING_ARG_CARD_BRAND("1010", "Missing argument : cardBrand"),
	MISSING_ARG_AUTH_RESULT_CODE("1011", "Missing argument : authResultCode"),
	MISSING_ARG_SECOND_FACTOR_AUTH_CODE("1012", "Missing argument : secondFactorAuthCode"),
	MISSING_ARG_EXPIRY_DATE("1013", "Missing argument : expiryDate"),
	MISSING_ARG_USER_ID("1014", "Missing argument : userId"),
	MISSING_ARG_COMMON_NAME("1015", "Missing argument : commonName"),
	MISSING_ARG_ORG("1016", "Missing argument : org"),
	MISSING_ARG_ORG_UNIT("1017", "Missing argument : orgUnit"),
	MISSING_ARG_COUNTRY("1018", "Missing argument : country"),
	MISSING_ARG_STATE("1019", "Missing argument : state"),
	MISSING_ARG_LOCALITY("1020", "Missing argument : locality"),
	MISSING_FILE_CERTIFICATE("1021", "Missing file : certificate"),
	MISSING_ARG_ACS_EPHEM_PUBLIC_KEY("1022", "Missing argument : acsEphemPubKey"),
	MISSING_ARG_SDK_EPHEM_PUBLIC_KEY("1023", "Missing argument : sdkEphemPubKey"),
	MISSING_ARG_ACS_URL("1024", "Missing argument : acsUrl"),
	MISSING_ARG_KEYS("1025", "Missing argument : keys"),
	MISSING_ARG_CURRENCY("1026", "Missing argument : currency"),
	MISSING_ARG_VERIFY_OTP_COUNT("1027", "Missing argument : verifyOtpCount"),
	MISSING_ARG_CARD_TYPE("1028", "Missing argument : cardType"),
	MISSING_ARG_MESSAGE("1029", "Missing argument : message"),
	MISSING_ARG_PARES_ID("1030", "Missing argument : paResId"),
	MISSING_ARG_MERCHANT_NAME("1031", "Missing argument : merchantName"),
	MISSING_ARG_VERSION("1032", "Missing argument : version"),
	MISSING_ARG_OTP_TYPE("1033", "Missing argument : otpType"),
	
	INVALID_ARG("2000", "Invalid argument"),
	INVALID_ARG_CARD_NUM("2001", "Invalid argument : cardNumber"),
	INVALID_ARG_IDENTITY_NUM("2002", "Invalid argument : identityNumber"),
	INVALID_ARG_KERNEL_TRANS_ID("2003", "Invalid argument : kernelTransId"),
	INVALID_ARG_INTEGRATOR_ID("2004", "Invalid argument : integratorId"),
	INVALID_ARG_AMOUNT("2005", "Invalid argument : amount"),
	INVALID_ARG_CARD_HOLDER_ID("2006", "Invalid argument : cardHolderId"),
	INVALID_ARG_CARD_BRAND("2007", "Invalid argument : cardBrand"),
	INVALID_ARG_AUTH_RESULT_CODE("2008", "Invalid argument : authResultCode"),
	INVALID_ARG_SECOND_FACTOR_AUTH_CODE("2009", "Invalid argument : secondFactorAuthCode"),
	INVALID_ARG_EXPIRY_DATE("2010", "Invalid argument : expiryDate"),
	INVALID_ARG_CURRENCY("2011", "Invalid argument : currency"),
	INVALID_ARG_VERIFY_OTP_COUNT("2012", "Invalid argument : verifyOtpCount"),
	INVALID_ARG_CARD_TYPE("2013", "Invalid argument : cardType"),
	INVALID_ARG_VERSION("2014", "Invalid argument : version"),
	INVALID_ARG_OTP_TYPE("2015", "Invalid argument : otpType"),
	INVALID_ARG_ACCOUNT_ID("2015", "Invalid argument : accountId"),
	
	INVALID_TRANSACTION_PROCESS_FOR_CAVV("9997", "Invalid transaction process, Because this transaction of integratorID has already calculated CAVV"),
	INVALID_TRANSACTION_PROCESS_FOR_NO_CARD_ID("9998", "Invalid transaction process, Because unable to verify cardholder identity correctly"),
	INVALID_TRANSACTION_PROCESS_FOR_NO_PHONE_NUMBER("9999", "Invalid transaction process, Because card holder phone number is null, Please invoke API-Get OTP Phone Number first");
	
	
	
	private String status;
	private String message;
	private ErrCode(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
