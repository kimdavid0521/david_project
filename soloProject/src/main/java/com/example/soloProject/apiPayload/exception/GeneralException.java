package com.example.soloProject.apiPayload.exception;

import com.example.soloProject.apiPayload.code.BaseErrorCode;
import com.example.soloProject.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason(); //this를 사용하지 않아도 되지만 좀 더 명확하게 하기 위해 사용
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
