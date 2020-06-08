package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.TopicBean;
import com.bean.UserBean;
import com.dao.TopicDao;
import com.dao.UserDao;

//works as REST Controller
@RestController
public class APIController {

	@Autowired
	UserDao userDao;
	@Autowired
	TopicDao topicDao;

//	add new user email to subscription list
	@PostMapping("/")
	public int subscribeEmail(UserBean userBean) {
		return userDao.subscribeUser(userBean);
	}
	
//	publish new topic
	@PostMapping("/topic")
	public int publishTopic(TopicBean topicBean) {
		return topicDao.notifySubscribers(topicBean);
	}
}
