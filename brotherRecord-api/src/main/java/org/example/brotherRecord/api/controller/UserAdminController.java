package org.example.brotherRecord.api.controller;

import org.example.brotherRecord.api.ApiConstant;
import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.vo.LoginVo;
import org.example.brotherRecord.api.vo.RegisterVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = ApiConstant.URL_PREFIX)
@RestController
public interface UserAdminController {
    @PostMapping("register")
    public void register(@RequestBody RegisterVo param);
    @PostMapping("/login")
    public BrotherRecordResponse login(@RequestBody LoginVo param);
}
