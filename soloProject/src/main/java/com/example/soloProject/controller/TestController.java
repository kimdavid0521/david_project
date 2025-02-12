package com.example.soloProject.controller;

import com.example.soloProject.apiPayload.BaseResponse;
import com.example.soloProject.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/")
    public BaseResponse<String> test() {
        return BaseResponse.onSuccess("성공"); //BaseResponse를 리턴해줌으로써 응답을 통일해 프론트와 통신을 용이하게 한다.
                                                    //성공 응답에 새로운 코드 적고싶을때 SuccessStatus enum을 계속 추가하여준다.
    }

    @GetMapping("/failed")
    public BaseResponse<String> failedTest() {
        testService.failedTest();
        return BaseResponse.onSuccess("성공!");
    }
}
