package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

// <User, Integer> はUserエンティティの主キー(id)の方はInteger
// Userエンティティを id（型 Integer）で検索・操作するためのリポジトリって書いてるよ
// ※PKはInteger、UUIDだったらStringになる
public interface UserRepository extends JpaRepository<User, Integer> {

	// クエリメソッド SELECT * FROM users WHERE email = ? AND password = ?;
	User findByEmailAndPassword(String email, String password);

}
