package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "blogs")
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // 記事ID(blogsテーブルのid)

	@ManyToOne // 多対１のリレーション：多くのブログが１つのカテゴリーに属するから
	@JoinColumn(name = "category_id") // blogsテーブルの外部キー（category_id）
	private Category category; // リレーション先のエンティティを指定

	@ManyToOne
	@JoinColumn(name = "user_id") // blogsテーブルの外部キー（user_id）
	private User user;

	private String title;

	private String body;

	// 引数なしコンストラクタ
	public Blog() {
	}

	// 新規作成用のコンストラクタ
	public Blog(Category category, User user, String title, String body) {
		this.category = category;
		this.user = user;
		this.title = title;
		this.body = body;
	}

	// 更新用コンストラクタ
	public Blog(Integer id, Category category, User user, String title, String body) {
		this.id = id;
		this.category = category;
		this.user = user;
		this.title = title;
		this.body = body;
	}

	// ゲッター
	public Integer getId() {

		return id;
	}

	public Category getCategory() {

		return category;
	}

	public User getUser() {

		return user;
	}

	public String getTitle() {

		return title;
	}

	public String getBody() {

		return body;
	}
}
