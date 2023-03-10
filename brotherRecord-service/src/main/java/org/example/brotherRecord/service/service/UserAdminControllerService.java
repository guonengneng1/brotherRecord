package org.example.brotherRecord.service.service;

import lombok.extern.slf4j.Slf4j;
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
import org.example.brotherRecord.service.utils.RedisClientUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class UserAdminControllerService implements UserAdminController {

    @Resource
    RedisClientUtils redisClientUtils;

    @Override
    public BrotherRecordResponse register(@RequestBody RegisterVO param) {
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
        redisClientUtils.set(param.getUserName(), param.getPassword(),1000*60*60);
        brotherRecordResponse.setCode(0);
        brotherRecordResponse.setMsg("注册成功");
        brotherRecordResponse.setData(param.getUserName());
        return brotherRecordResponse;
    }

    @Override
    public BrotherRecordResponse login(@RequestBody LoginVO param) {
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
        String passWord = (String)redisClientUtils.get(param.getUserName());
        log.info("password={},getPassWord()={}",passWord,param.getPassWord());
        if(passWord.equals(param.getPassWord())){
            brotherRecordResponse.setCode(0);
            brotherRecordResponse.setMsg("登录成功");
            brotherRecordResponse.setData(param.getUserName());
        }else {
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
