package com.example.soloProject.apiPayload.code.status;

import com.example.soloProject.apiPayload.code.BaseCode;
import com.example.soloProject.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK, "COMMOM200", "성공입니다"),
    _CREATED(HttpStatus.CREATED, "COMMON201", "요청 성공 및 리소스 생성")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;



    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .httpStatus(httpStatus)
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }
}
