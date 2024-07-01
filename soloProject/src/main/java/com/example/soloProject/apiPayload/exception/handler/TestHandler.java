package com.example.soloProject.apiPayload.exception.handler;

import com.example.soloProject.apiPayload.code.BaseErrorCode;
import com.example.soloProject.apiPayload.exception.GeneralException;

public class TestHandler extends GeneralException {
    public TestHandler(BaseErrorCode code) {
        super(code); //super는 부모의 생성자 호출
    }
}
