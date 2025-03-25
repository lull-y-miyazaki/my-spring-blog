package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	// 必要なオブジェクトを自動的に生成・管理するためのアノテーション
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HttpSession session;

	@Autowired
	private Account account;

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

		// セッション情報全てをクリア
		session.invalidate();

		// クエリパラメータで"notLoggedIn"を受け取った場合
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログインしてください");
		}

		return "login";
	}

	// ログイン処理
	@PostMapping("/login")
	public String login(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		// email または password が空の場合にエラーメッセージを表示
		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			model.addAttribute("message", "メールアドレスとパスワードを入力してください");
			return "login";
		}

		// データーベースからユーザー情報を取得
		User user = userRepository.findByEmailAndPassword(email, password);

		// email または password が正しくない場合にエラーメッセージを表示
		if (user == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが正しくありません");
			return "login";
		}

		// ログイン情報をAccountに保存
		account.setId(user.getId());
		account.setName(user.getName());

		return "redirect:/blogs";
	}

}
