package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class BlogController {

	@Autowired
	private Account account;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BlogRepository blogRepository;

	// ブログ一覧画面の表示
	@GetMapping("/blogs")
	public String index(
			@RequestParam(defaultValue = "") Integer categoryId,
			Model model) {

		// 全カテゴリーの取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		// 全てのユーザーのブログ記事の一覧情報を取得
		List<Blog> blogList = null;
		if (categoryId == null) {
			blogList = blogRepository.findAll();
		} else {
			blogList = blogRepository.findByCategoryId(categoryId);
		}

		// 取得した記事一覧をテンプレートに渡す
		model.addAttribute("blogs", blogList);

		return "blogs";
	}

	// ブログの新規登録画面の表示
	@GetMapping("/blogs/add")
	public String create(Model model) {

		// 全カテゴリーの取得
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categories", categoryList);

		return "addBlog";
	}

	// ブログの新規登録処理
	@PostMapping("/blogs/add")
	public String add(
			@RequestParam Integer categoryId,
			@RequestParam String title,
			@RequestParam String content,
			Model model) {

		// カテゴリー情報の取得
		// orElseThrow()：中身が「ある」なら取り出して、「ない」なら例外を投げる
		Category category = categoryRepository.findById(categoryId).orElseThrow();

		// ログインしているユーザー情報の取得
		User user = userRepository.findById(account.getId()).orElseThrow();

		Blog blog = new Blog(category, user, title, content);
		blogRepository.save(blog);

		return "redirect:/blogs";
	}

	// ブログ変更画面の表示
	@GetMapping("/blogs/edit")
	public String update(
			@RequestParam Integer blogId,
			Model model) {
		return "editBlog";
	}

}
