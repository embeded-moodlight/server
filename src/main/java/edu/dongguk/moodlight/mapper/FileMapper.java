package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.Voice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {

    @Insert({"INSERT INTO VOICE_MAIL (token, sender_token, voice_name) values (#{token}, #{senderToken}, #{voiceName})"})
    int insertVoiceMeta(Voice voice);

    @Insert({"INSERT INTO VOICES (voice_num, save_voice_name, content_type, length)" +
            " values (#{voiceNum}, #{saveVoiceName}, #{contentType}, #{length})"})
    void insertVoiceFile(Voice voice);

    @Select({"SELECT sender_token, voice_name, date, flag " +
            "FROM VOICE_MAIL " +
            "WHERE token = #{token}"})
    List<Voice> selectVoicesByUser(String token);

    @Select({"SELECT save_voice_name, content_type, length " +
            "FROM VOICES " +
            "WHERE voice_num = #{voiceNum}"})
    List<Voice> selectVoicesByVoiceNum(int voiceNum);

    @Update({"UPDATE VOICE_MAIL " +
            "SET flag = 1 " +
            "WHERE voice_num = #{voiceNum}"})
    void updateVoiceFlagByvoiceNum(int voiceNum);
}
