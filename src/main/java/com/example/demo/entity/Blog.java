package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 記事ID(blogsテーブルのid)

	@Column(name = "category_id") // blogsテーブルのcategory_id
	private Integer categoryId; // カテゴリーID

	@Column(name = "user_id") // blogsテーブルのuser_id
	private Integer userId; // ユーザーID

	private String title;

	private String body;

	// 引数なしコンストラクタ
	public Blog() {
	}

	// 新規作成用のコンストラクタ
	public Blog(Integer categoryId, Integer userId, String title, String body) {
		this.categoryId = categoryId;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	// 更新用コンストラクタ
	public Blog(Integer id, Integer categoryId, Integer userId, String title, String body) {
		this.id = id;
		this.categoryId = categoryId;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	// ゲッター
	public Integer getId() {

		return id;
	}

	public Integer getCategoryId() {

		return categoryId;
	}

	public Integer getUserId() {

		return userId;
	}

	public String getTitle() {

		return title;
	}

	public String getBody() {

		return body;
	}
}
