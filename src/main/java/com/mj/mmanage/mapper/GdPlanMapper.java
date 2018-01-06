/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mj.mmanage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import com.mj.mmanage.model.GdBook;
import com.mj.mmanage.model.GdPlan;

/**
 * @author lihailong
 * @since 2018-01-02
 */
public interface GdPlanMapper extends Mapper<GdPlan>, MySqlMapper<GdPlan> {
	
	/**
	 * @param wxUserID 微信用户ID
	 * @param currentDate 当前系统日期,格式YYYYMMDD
	 * @return 返回当前处于报名中的共读计划信息
	 */
	@Select ("select " + 
		"plan.gd_id as gdId, " + 
		"plan.gd_title as gdTitle, " + 
		"plan.signup_begin_date as signupBeginDate, " + 
		"plan.signup_end_date as signupEndDate, " + 
		"plan.gd_begin_date as gdBeginDate, " + 
		"plan.gd_end_date as gdEndDate, " + 
		"plan.gd_state as gdState, " + 
		"plan.sponsor_user as sponsorUser, " + 
		"plan.gd_slogan  as gdSlogan, " + 
		"apply.wx_user_id as wxUserId, " + 
		"applyNum.apply_num as applyNum " + 
	"from t_gd_plan plan " + 
	"left join t_gd_apply apply on plan.gd_id = plan.gd_id and apply.wx_user_id = #{wxUserID} " + 
	"left join (select gd_id as gd_id, count(1) as apply_num from t_gd_apply group by gd_id) as applyNum on applyNum.gd_id = plan.gd_id " + 
	"where " + 
		  "plan.signup_begin_date <= #{currentDate} " + 
	  "and plan.signup_end_date >= #{currentDate} " + 
	  "limit 1 " )
	public GdPlan getGdPlansByWXUserID(@Param("wxUserID") String wxUserID, @Param("currentDate") String currentDate);
	
	/**
	 * @param gdId 共读计划编号
	 * @return 当前共读图书信息列表
	 */
	@Select ("select " + 
				"book.book_id as bookId, " + 
				"book.book_name as bookName, " + 
			    "book.book_author as bookAuthor, " + 
			    "book.book_tag as bookTag, " + 
			    "book.book_slt_path as bookSltPath, " + 
			    "book.book_summary as bookSummary " + 
			  "from  t_gd_plan_book_rel bookrel " + 
			  "left join t_gd_book book on book.book_id = bookrel.book_id " + 
			  "where bookrel.gd_id = #{gdId} " )
	public List<GdBook> findGdBookInfos(@Param("gdId") int gdId);
	
	/**
	 * @param wxUserId
	 * @param gdId
	 */
	@Insert("insert into t_gd_apply(gd_id,wx_user_id,apply_time)" +
			" values (#{gdId},#{wxUserId},CURRENT_TIMESTAMP)")
	public void insertGdApplyInfo(@Param("wxUserId") String wxUserId, @Param("gdId") int gdId);
	
	/**
	 * @param wxUserId
	 * @param gdId
	 */
	@Delete("delete from t_gd_apply where gd_id = #{gdId} and wx_user_id = #{wxUserId}")
	public void deleteGdApplyInfo(@Param("wxUserId") String wxUserId, @Param("gdId") int gdId);
	
}
