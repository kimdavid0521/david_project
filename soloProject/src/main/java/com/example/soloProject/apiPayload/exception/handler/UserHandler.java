package com.example.soloProject.apiPayload.exception.handler;

import com.example.soloProject.apiPayload.code.BaseErrorCode;
import com.example.soloProject.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {

    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
