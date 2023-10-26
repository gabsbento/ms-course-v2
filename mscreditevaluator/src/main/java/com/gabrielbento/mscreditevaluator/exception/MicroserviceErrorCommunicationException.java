package com.gabrielbento.mscreditevaluator.exception;

import lombok.Getter;

public class MicroserviceErrorCommunicationException extends  Exception{
    @Getter
    private Integer status;
    public MicroserviceErrorCommunicationException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
