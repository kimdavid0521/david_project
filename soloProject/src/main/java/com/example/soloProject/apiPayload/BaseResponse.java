package com.example.soloProject.apiPayload;

import com.example.soloProject.apiPayload.code.BaseCode;
import com.example.soloProject.apiPayload.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class BaseResponse<T> {  //성공이나 실패할시 리턴할 함수들과 필드들 적음

    @JsonProperty("isSuccess")
    private final boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;


    //성공한 경우 응답 생성
    //onSuccess함수 : SuccessStatus._OK를 사용하여 응답 생성, 성공 상태 코드, 메세지, 결과 데이터를 포함한 BaseResponse객체를 반환
    // 특정 성공 상태를 표현할 필요 없고, 일반적인 성공 응답 반환할때 사용
    public static <T> BaseResponse<T> onSuccess(T result) {
        return new BaseResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    //of 함수 : BaseCode 인터페이스를 구현한 특정 코드 객체를 받아서 응답 생성,
    //다양한 성공 상태를 표현해야할때 사용 예를 들어, 여러 종류의 성공 상태 코드와 메세지를 정의하고 싶을때 유용
    public static <T> BaseResponse<T> of(BaseCode code, T result) {
        return new BaseResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }

    //실패한 경우 응답 생성
    public static <T> BaseResponse<T> onFailure(String code, String message, T data) {
        return new BaseResponse<>(false, code, message, data);
    }

}
