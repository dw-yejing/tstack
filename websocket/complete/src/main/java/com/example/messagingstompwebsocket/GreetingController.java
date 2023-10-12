package com.example.messagingstompwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpSession;
import org.springframework.messaging.simp.user.SimpSubscriptionMatcher;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Set;

@RestController
public class GreetingController {
	@Autowired
	// simpMessageSendingOperations 与 simpMessagingTemplate 使用区别在于是否需要加上根路由
	private SimpMessageSendingOperations simpMessageSendingOperations;
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	private SimpUserRegistry simpUserRegistry;
	@Autowired
	private HttpServletRequest httpServletRequest;

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting(String message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return message;
	}

	@GetMapping("test")
	public  HelloMessage test1(String id, String name){
		Principal userPrincipal = httpServletRequest.getUserPrincipal();
		simpUserRegistry.getUsers();
		// 全员发送
		simpMessagingTemplate.convertAndSend("/topic/greetings", name);
		// 定向发送
		simpMessagingTemplate.convertAndSendToUser(id, "/remind", name);
		return null;
	}

}
