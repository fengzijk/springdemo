/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       FENGZIJK LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2022年06月22日 21时31分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Description
 *   -----------------------------------------------------------------------------------
 *  2022-06-22 21:31:04    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.fengzijk.springdemo.config.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>功能描述:</pre>
 *
 * @author : fengzijk
 * @className : ResponseEntity
 * @email: guozhifengvip@gmail.com
 * @date : 2021/7/10 上午2:00
 */
@SuppressWarnings("All")
public class ResponseEntity<T> {
    /**
     * 响应状态码
     **/
    private volatile String statusCode = StatusCode.BAD_REQUEST.getCode();
    /**
     * 响应状态码对应的提示信息
     **/
    private volatile String statusMessage = StatusCode.BAD_REQUEST.getMessage();
    /**
     * 响应内容
     **/
    private volatile T data = null;

    /**
     *
     */
    public ResponseEntity() {
    }

    /**
     * @param statusCode
     * @param statusMessage
     */
    private ResponseEntity(final String statusCode, final String statusMessage) {
        this(statusCode, statusMessage, null);
    }

    /**
     * @param statusCode
     * @param statusMessage
     * @param data
     */
    private ResponseEntity(final String statusCode, final String statusMessage, final T data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    /**
     * 判断 是否调用成功
     *
     * @param responseEntity
     * @return
     */
    public static <T> boolean hasSuccessResponse(ResponseEntity<T> responseEntity) {
        if (responseEntity != null && responseEntity.isOk()) {
            return true;
        }
        return false;
    }

    /**
     * 判断 是否存在调用成功的响应内容
     *
     * @param responseEntity
     * @return
     */
    public static <T> boolean hasSuccessdata(ResponseEntity<T> responseEntity) {
        if (hasSuccessResponse(responseEntity) && responseEntity.getdata() != null) {
            return true;
        }
        return false;
    }

    /**
     * 请求成功，状态码为20000
     *
     * @return
     */
    public ResponseEntity<T> ok() {
        return ok(StatusCode.OK.getCode(), StatusCode.OK.getMessage());
    }

    /**
     * 请求成功，状态码为20000
     *
     * @param message 提示消息
     * @return
     */
    public ResponseEntity<T> ok(final String message) {
        return ok(StatusCode.OK.getCode(), message);
    }

    /**
     * 成功请求,成功状态码自行指定
     *
     * @param okStatusCode 成功状态码
     * @param message      提示消息
     * @return
     */
    public ResponseEntity<T> ok(final String okStatusCode, final String message) {
        return new ResponseEntity<T>(okStatusCode, message);
    }

    /**
     * 成功请求,成功状态码自行指定
     *
     * @param okStatusCode 成功状态码
     * @param message      提示消息
     * @return
     */
    public ResponseEntity<T> ok(final StatusCode okStatusCode, final String message) {
        return new ResponseEntity<T>(okStatusCode.getCode(), message);
    }

    /**
     * 服务器发生错误，将无法判断发出的请求是否成功，状态码：20500
     *
     * @param message 提示消息
     * @return
     */
    public ResponseEntity<T> systemError(final String message) {
        return new ResponseEntity<T>(StatusCode.SYSTEM_ERROR.getCode(), message);
    }

    /**
     * 服务器发生错误，将无法判断发出的请求是否成功
     *
     * @param errorStatusCode 错误状态码
     * @param message         提示消息
     * @return
     */
    public ResponseEntity<T> systemError(final StatusCode errorStatusCode, final String message) {
        return new ResponseEntity<T>(errorStatusCode.getCode(), message);
    }

    /**
     * 失败请求，状态码：20400
     *
     * @return
     */
    public ResponseEntity<T> badRequest() {
        return badRequest(StatusCode.BAD_REQUEST.getCode(), StatusCode.BAD_REQUEST.getMessage());
    }

    /**
     * 失败请求，状态码：20400
     *
     * @param message 提示消息
     * @return
     */
    public ResponseEntity<T> badRequest(final String message) {
        return badRequest(StatusCode.BAD_REQUEST.getCode(), message);
    }

    /**
     * 失败请求,失败状态码自行指定
     *
     * @param failStatusCode 失败状态码
     * @param message        提示消息
     * @return
     */
    public ResponseEntity<T> badRequest(final String failStatusCode, final String message) {
        return new ResponseEntity<T>(failStatusCode, message);
    }

    /**
     * 失败请求,失败状态码自行指定
     *
     * @param failStatusCode 失败状态码
     * @param message        提示消息
     * @return
     */
    public ResponseEntity<T> badRequest(final StatusCode failStatusCode, final String message) {
        return new ResponseEntity<T>(failStatusCode.getCode(), message);
    }

    /**
     * 是否成功
     *
     * @return 如果状态 <b style="color:red">是<code>StatusCode.OK</code></b> 则返回 <code>true</code>
     */
    @JsonIgnore
    public boolean isOk() {
        return this.getCode() != null && StatusCode.OK.getCode().equalsIgnoreCase(this.getCode());
    }

    /**
     * 获取返回对象
     *
     * @return
     */
    public T getdata() {
        return data;
    }

    /**
     * 设置返回对象
     *
     * @param data
     * @return
     */
    public ResponseEntity<T> setdata(T data) {
        this.data = data;
        return this;
    }

    /**
     * 获取状态码
     *
     * @return
     */
    public String getCode() {
        return statusCode;
    }

    /**
     * 获取状态信息
     *
     * @return
     */
    public String getMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 业务状态码
     */
    @Getter
    @AllArgsConstructor
    public enum StatusCode {
        /**
         * 请求成功
         **/
        OK("200", "请求成功"),
        /**
         * 请求参数出错
         **/
        BAD_VALIDATED("207", "请求参数出错"),
        /**
         * 请求失败
         **/
        BAD_REQUEST("204", "请求失败"),
        /**
         * 系统内部错误
         **/
        SYSTEM_ERROR("400", "系统内部错误");

        private final String code;
        private final String message;

    }


}
