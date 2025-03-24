package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
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

	// 新規登録の処理内容
	@PostMapping("/users/add")
	public String store(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String password_confirm,
			Model model) {

		User user = new User(name, email, password);
		userRepository.save(user);
		// 登録するユーザーの確認用
		System.out.println("登録データ: " + user.toString());

		return "redirect:/login";
	}

	// ログイン画面の表示
	@GetMapping({ "/", "/login" })
	public String index(
			@RequestParam(defaultValue = "") String error,
			Model model) {

		return "login";
	}

	// ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestBody String entity) {

		return entity;
	}

}
