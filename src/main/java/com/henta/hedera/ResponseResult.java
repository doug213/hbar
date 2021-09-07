package com.henta.hedera;

import com.hedera.hashgraph.sdk.TransactionReceipt;

public class ResponseResult {
    private Integer code;
    private TransactionReceipt transactionReceipt;
    private String info;
    private Integer responseCodeEnum;

    public ResponseResult(Integer code, TransactionReceipt transactionReceipt) {
        this.code = code;
        this.transactionReceipt = transactionReceipt;
    }

    public ResponseResult() {
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public TransactionReceipt getTransactionReceipt() {
        return this.transactionReceipt;
    }

    public void setTransactionReceipt(TransactionReceipt transactionReceipt) {
        this.transactionReceipt = transactionReceipt;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getResponseCodeEnum() {
        return this.responseCodeEnum;
    }

    public void setResponseCodeEnum(Integer responseCodeEnum) {
        this.responseCodeEnum = responseCodeEnum;
    }
}
