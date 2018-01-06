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

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import com.mj.mmanage.model.GdBook;
import com.mj.mmanage.model.GdBookRescource;

/**
 * <p> Description:图书维护业务逻辑 </p>
 * <p> Copyright: Copyright (c) 2017 </p>
 * <p> Create Date: 2018-1-2</p>
 * <p> Company: YUSYS </p> 
 *@author:YX-LiAnDong
 *@version:GdBookMapper,v1.0 YX-LiAnDong
 */
public interface GdBookMapper extends Mapper<GdBook>, MySqlMapper<GdBook> {
	

	@Select("select " + 
			"res.txt_path as txt_path, " + 
		    "res.txt_name as txt_name, " + 
		    "res.txt_size as txt_size, " + 
		    "res.voice_path as voice_path, " + 
		    "res.voice_name as voice_name, " + 
		    "res.voice_size as voice_size, " +
		    "res.file_type as file_type, " + 
		    "sign.wx_user_id as wx_user_id " + 
		  "from t_gd_chapter_per_day_rel rel " + 
		  "left join t_gd_book_resource res " + 
			  "on  rel.book_id = res.book_id " + 
			  "and rel.book_chapter = res.book_chapter " + 
		   "left join t_gd_sign_in sign " + 
			  "on  sign.sign_in_date = rel.gd_date " + 
		      "and sign.sign_in_period = rel.gd_period " + 
		      "and sign.wx_user_id = #{wxUserID} " + 
		  "where rel.gd_date = #{currentDate} " + 
		    "and rel.gd_period = #{currentPeriod} " + 
		    "limit 1 ")
	public GdBookRescource findGdBookResource(@Param("wxUserID") String wxUserId, 
								   @Param("currentDate") String currentDate, 
								   @Param("currentPeriod") String currentPeriod);
	
}
