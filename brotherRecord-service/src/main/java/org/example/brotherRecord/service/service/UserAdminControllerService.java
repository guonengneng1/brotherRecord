package org.example.brotherRecord.service.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.example.brotherRecord.common.BrotherRecordResponse;
import org.example.brotherRecord.api.controller.UserAdminController;
import org.example.brotherRecord.api.vo.LoginVo;
import org.example.brotherRecord.api.vo.RegisterVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserAdminControllerService implements UserAdminController {
    @Override
    public void register(RegisterVo param) {
        int a=0;
        return;
    }

    @Override
    public BrotherRecordResponse login(@RequestBody LoginVo param) {
        System.out.println(1);
        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
        try {
            IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
            SecurityManager instance = iniSecurityManagerFactory.getInstance();
            SecurityUtils.setSecurityManager(instance);
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token=new UsernamePasswordToken(param.getUserName(),param.getPassWord());
            subject.login(token);
            brotherRecordResponse.setCode(0);
            brotherRecordResponse.setMsg("登录成功");
            brotherRecordResponse.setData(param.getUserName());
        }catch (Exception e){
            brotherRecordResponse.setCode(1);
            brotherRecordResponse.setMsg("登录失败");
            brotherRecordResponse.setData(param.getUserName());
        }
        return brotherRecordResponse;

    }
}
