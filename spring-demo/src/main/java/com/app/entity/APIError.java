package com.app.entity;

import lombok.Data;

@Data
public class APIError {

    private String errorMessage;

    private String errorCode;

    private String request;

    private String requestType;


}