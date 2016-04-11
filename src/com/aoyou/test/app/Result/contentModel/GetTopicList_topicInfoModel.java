package com.aoyou.test.app.Result.contentModel;

import java.util.List;

public class GetTopicList_topicInfoModel {

		//主题ID
		public int topic_id;
		
		//板块ID
		public int board_id;
		
		public int type;
		
		public String board_name;
		
		//内容简写
		public String subject;
		
		//标题
		public String title;
		
		//图片路径（第一张图）
		public String pic_path;
		
		//点击量
		public int hits;
		
		//回复数量
		public int replies;
		
		//最后回复时间
		public String last_reply_date;
		
		public int vote;
		
		public int top;
		
		public int hot;
		
		public int essence;
		
		public int status;
		
		//图片列表
		public List<String> imageList; 
		
		//会员ID
		public int user_id;
		
		//会员昵称
		public String user_nick_name;
		
		public int gender;
		
		public int recommendAdd;
		
		//点赞数量
		public int firstPostSupportNum;
		
		public int isHasRecommendAdd;
				
		public String sourceWebUrl;
		
		//会员头像
		public String userAvatar;
		
		//图片长宽比
		public String ratio;
}
