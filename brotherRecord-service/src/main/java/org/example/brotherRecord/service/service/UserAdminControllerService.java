package org.example.brotherRecord.service.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.example.brotherRecord.api.vo.SendShortMessageVO;
import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.controller.UserAdminController;
import org.example.brotherRecord.api.vo.LoginVO;
import org.example.brotherRecord.api.vo.RegisterVO;
import org.example.brotherRecord.service.utils.GetMessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.ExecutionException;

@Controller
public class UserAdminControllerService implements UserAdminController {
    @Override
    public BrotherRecordResponse register(@RequestBody RegisterVO param) {
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
//
//        String test = testApi.getTest();
//        brotherRecordResponse.setCode(0);
//        brotherRecordResponse.setData("成功");
//        brotherRecordResponse.setMsg(test);
        return brotherRecordResponse;
    }

    @Override
    public BrotherRecordResponse login(@RequestBody LoginVO param) {
        System.out.println(1);
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
        try {
            IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
            SecurityManager instance = iniSecurityManagerFactory.getInstance();
            SecurityUtils.setSecurityManager(instance);
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(param.getUserName(), param.getPassWord());
            subject.login(token);
            brotherRecordResponse.setCode(0);
            brotherRecordResponse.setMsg("登录成功");
            brotherRecordResponse.setData(param.getUserName());
        } catch (Exception e) {
            brotherRecordResponse.setCode(1);
            brotherRecordResponse.setMsg("登录失败");
            brotherRecordResponse.setData(param.getUserName());
        }
        return brotherRecordResponse;

    }

    @Override
    public BrotherRecordResponse sendShortMessage(SendShortMessageVO param) {
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
        try {
            String shortMessage = GetMessageUtils.getShortMessage(param.getPhoneNumber());
            brotherRecordResponse.setCode(0);
            brotherRecordResponse.setMsg("登录成功");
            brotherRecordResponse.setData(shortMessage);
        } catch (Exception e) {
            brotherRecordResponse.setCode(1);
            brotherRecordResponse.setMsg("登录失败");
            brotherRecordResponse.setData(param.getPhoneNumber());
        }
        return null;
    }
}
