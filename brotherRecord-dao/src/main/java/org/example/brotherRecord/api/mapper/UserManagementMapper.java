package org.example.brotherRecord.api.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.brotherRecord.api.entity.UserManagement;
import org.example.brotherRecord.api.example.UserManagementExample;

public interface UserManagementMapper {
    long countByExample(UserManagementExample example);

    int deleteByExample(UserManagementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserManagement record);

    int insertSelective(UserManagement record);

    List<UserManagement> selectByExample(UserManagementExample example);

    UserManagement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserManagement record, @Param("example") UserManagementExample example);

    int updateByExample(@Param("record") UserManagement record, @Param("example") UserManagementExample example);

    int updateByPrimaryKeySelective(UserManagement record);

    int updateByPrimaryKey(UserManagement record);
}