package org.example.brotherRecord.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterVO {
    //姓名
    private String personName;
    //账号
    private String userName;
    //密码
    private String password;
}
