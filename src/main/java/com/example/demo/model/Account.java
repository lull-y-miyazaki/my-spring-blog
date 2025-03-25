package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Account {

	// フィールド
	private Integer id;
	private String name;

	// コンストラクタ
	public Account() {
	}

	public Account(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// ゲッター
	public String getName() {

		return name;
	}

	public Integer getId() {

		return id;
	}

	// セッター
	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// ログイン状態を確認するメソッド（未使用）
	public boolean isLoggedIn() {
		return id != null && name != null && !name.isEmpty();
	}

	// デバッグ・ログ出力用
	@Override
	public String toString() {
		return "Account{id = " + id + ", name = '" + name + "'}";
	}

}
