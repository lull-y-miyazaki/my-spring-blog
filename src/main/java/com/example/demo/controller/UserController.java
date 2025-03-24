package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	// 必要なオブジェクトを自動的に生成・管理するためのアノテーション
	@Autowired
	UserRepository userRepository;

	// 新規ユーザー登録画面の表示
	@GetMapping("/users/add")
	public String create() {

		return "addUser";
	}

}
