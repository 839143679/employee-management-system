package com.zjr.Mapper;

import com.zjr.model.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Insert("insert into notice(sendname,getname,time,message) values(#{sendName},#{getName},#{time},#{message})")
    int addNotice(Notice notice);//创建通知

    @Delete("delete from notice where id =?")
    int deleteNotice(Integer id);//删除通知

    @Update("update notice set saw = true where id = #{id}")
    int updateNotice(Integer id);//通知已读

    @Select("select id,sendname,getname,message,time,saw from notice")
    List<Notice> queryNotices();

    @Select("select id,sendname,getname,message,time,saw from notice where sendname = #{sendName} or getname = #{getName}")
    List<Notice> queryLoginNotices(String name);
}
