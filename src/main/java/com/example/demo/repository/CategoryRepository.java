package com.example.demo.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository は Spring Data JPA によって提供される データベース操作（CRUD）を簡単に実装できるインターフェース
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
