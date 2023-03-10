package org.example.brotherRecord.api.controller;

import org.example.brotherRecord.api.ApiConstant;
import org.example.brotherRecord.api.vo.SendShortMessageVO;
import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.vo.LoginVO;
import org.example.brotherRecord.api.vo.RegisterVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping(value = ApiConstant.URL_PREFIX)
@RestController
public interface UserAdminController {
    @PostMapping("register")
    public BrotherRecordResponse register(@RequestBody RegisterVO param);
    @PostMapping("/login")
    public BrotherRecordResponse login(@RequestBody LoginVO param);
    @PostMapping("/sendShortMessage")
    public BrotherRecordResponse sendShortMessage(@RequestBody SendShortMessageVO param);
}
