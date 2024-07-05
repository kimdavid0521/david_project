package com.example.soloProject.apiPayload.exception.handler;

import com.example.soloProject.apiPayload.code.BaseErrorCode;
import com.example.soloProject.apiPayload.exception.GeneralException;

public class PostHandler extends GeneralException {

    public PostHandler(BaseErrorCode code) {
        super(code);
    }
}
