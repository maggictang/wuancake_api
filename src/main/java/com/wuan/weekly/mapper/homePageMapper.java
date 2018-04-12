package com.wuan.weekly.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wuan.weekly.entity.Leave;

@Mapper
public interface homePageMapper {

	@Insert(
			"inset into report(week_num,user_id,group_id,status,text)"
			+ "values (leaveNum,userId,groupId,status,reason)")
	public void Main(Leave leave);
	
	@Select(
			"select * from report where user_id = #{userId} "
			+ "and status = #{status}")
	public Leave leave(
			@Param("userId")int user_id, 
			@Param("status") int status);

	@Select("select status from report where user_id = #{userId}")
	public int getStatus(@Param("userId") int id);
	
}
