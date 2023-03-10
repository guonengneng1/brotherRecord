package org.example.brotherRecord.service.controller;


import org.example.brotherRecord.common.CommonTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("hello")
    public String hello(){
        return CommonTest.TestCommon();
    }
//    @PostMapping("login")
//    public BrotherRecordResponse login(@RequestBody LoginVo param){
//        System.out.println(1);
//        BrotherRecordResponse brotherRecordResponse = new BrotherRecordResponse();
//        try {
//            IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
//            SecurityManager instance = iniSecurityManagerFactory.getInstance();
//            SecurityUtils.setSecurityManager(instance);
//            Subject subject = SecurityUtils.getSubject();
//            AuthenticationToken token=new UsernamePasswordToken(param.getUserName(),param.getPassWord());
//            subject.login(token);
//            brotherRecordResponse.setCode(0);
//            brotherRecordResponse.setMsg("登录成功");
//            brotherRecordResponse.setData(param.getUserName());
//        }catch (Exception e){
//            brotherRecordResponse.setCode(1);
//            brotherRecordResponse.setMsg("登录失败");
//            brotherRecordResponse.setData(param.getUserName());
//        }
//        return brotherRecordResponse;
//    }
}
