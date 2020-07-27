package spring.jpa.separate.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponse {

	public String status;
	public String msg;
	public Object data;

	public BaseResponse(ErrCode errCode) {
		this.status = errCode.getStatus();
		this.msg = errCode.getMessage();
	}

	public BaseResponse(ErrCode errCode, Object data) {
		this.status = errCode.getStatus();
		this.msg = errCode.getMessage();
		this.data = data;
	}

	public BaseResponse(Object data) {
		this.status = ErrCode.SUCCESS.getStatus();
		this.msg = ErrCode.SUCCESS.getMessage();
		this.data = data;
	}
	
}
