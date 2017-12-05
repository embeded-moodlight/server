package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.Diffuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DiffuserMapper {

    @Insert("INSERT INTO DIFFUSERS (token, diffuser_name, flag) VALUES (#{token}, #{diffuserName}, #{flag})")
    void insertDiffuser(Diffuser diffuser);

    @Update("Update  DIFFUSERS " +
            "SET diffuser_name = #{diffuserName}, flag = #{flag} " +
            "WHERE token = #{token}")
    void updateDiffuser(Diffuser diffuser);
}
