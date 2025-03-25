package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	// BlogエンティティでcategoryIdが一致する全てを取得する
	// 複数の結果が返ってくるので戻り値はList<Blog>
	// SELECT * FROM blog WHERE category_id = ?;
	List<Blog> findByCategoryId(Integer categoryId);

}
