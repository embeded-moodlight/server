package edu.dongguk.moodlight.mapper;

import edu.dongguk.moodlight.domain.Voice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {

    @Insert({"INSERT INTO VOICE_MAIL (voice_num, token, sender_token, voice_name) VALUES (#{voiceNum}, #{token}, #{senderToken}, #{voiceName})"})
    void insertVoiceMeta(Voice voice);

    @Insert({"INSERT INTO VOICES (save_voice_name, content_type, length)" +
            " VALUES (#{saveVoiceName}, #{contentType}, #{length})"})
    @SelectKey(statement="SELECT last_insert_id()", keyProperty="voiceNum", before=false, resultType=int.class)
    void insertVoiceFile(Voice voice);

    @Results(id = "voiceBox", value = {
            @Result(property = "voiceNum", column = "voice_num", id = true),
            @Result(property = "senderToken", column = "sender_token"),
            @Result(property = "voiceName", column = "voice_name"),
    })
    @Select({"SELECT token, sender_token, voice_name, date, flag" +
            " FROM VOICE_MAIL" +
            " WHERE token = #{token}"})
    List<Voice> selectVoicesByUser(String token);

    @Results(id = "voiceResult", value = {
            @Result(property = "voiceNum", column = "voice_num", id = true),
            @Result(property = "saveVoiceName", column = "save_voice_name"),
            @Result(property = "contentType", column = "content_type"),
    })
    @Select({"SELECT voice_num, save_voice_name, date, content_type, length" +
            " FROM VOICES" +
            " WHERE voice_num = #{voiceNum}"})
    Voice selectVoiceByVoiceNum(int voiceNum);

    @Update({"UPDATE VOICE_MAIL" +
            " SET flag = 1" +
            " WHERE voice_num = #{voiceNum}"})
    void updateVoiceFlagByvoiceNum(int voiceNum);
}
