package com.grainoil.common.core.domain;

import com.grainoil.common.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 15:21
 */
@ApiModel(value="ResponseResult",description="result")
public class ResponseResult<T> {

    @ApiModelProperty(value="code",name="code")
    public int code; //返回状态码

    @ApiModelProperty(value="msg",name="msg")
    private String msg; //返回描述信息

    @ApiModelProperty(value="data",name="data")
    private T data; //返回内容体

    /**
     * 200
     * @return
     */
    public static ResponseResult success(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResultCode.SUCCESS);
        responseResult.setMsg(ResultCode.SUCCESS);
        return responseResult;
    }

    /**
     * 200成功对象
     * @param data
     * @return
     */
    public static <T> ResponseResult<T> success(T data){
        ResponseResult<T> responseResult = success();
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 500
     * @return
     */
    public static ResponseResult error(){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResultCode.INTERNAL_SERVER_ERROR);
        responseResult.setMsg(ResultCode.INTERNAL_SERVER_ERROR);
        return responseResult;
    }

    /**
     * 500错误信息
     * @return
     */
    public static ResponseResult error(String message){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResultCode.INTERNAL_SERVER_ERROR);
        responseResult.setMsg(message);
        return responseResult;
    }

    /**
     * 自定义resultCode
     * @param resultCode
     * @return
     */
    public static ResponseResult result(ResultCode resultCode){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(resultCode.code);
        responseResult.setMsg(resultCode.message);
        return responseResult;
    }



    public ResponseResult<T> setCode(ResultCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public ResponseResult<T> setMsg(ResultCode retCode) {
        this.msg = retCode.message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
