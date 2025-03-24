package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Account;

// アスペクト（共通処理を差し込むクラス）をSpringに伝えるアノテーション
@Aspect
// このクラスをSpringのコンテナが管理するようにするアノテーション（DIやAOPが機能するため）
@Component
public class CheckLoginAspect {

	@Autowired
	private Account account;

	// 全Controllerクラスの全メソッドの処理前にログインチェックしてログ出力処理を差し込む
	@Before("execution(* com.example.demo.controller.*Controller.*(..))")
	public void writeLog(JoinPoint jp) {
		// ログインしたアカウント情報を取得
		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.out.print("ゲスト：");
		} else {
			System.out.print(account.getName() + "：");
		}
		System.out.println(jp.getSignature());
	}

	// 未ログインの場合ログインページにリダイレクト
	// `*` は「すべての戻り値・メソッド名」に、`(..)` は「すべての引数の組み合わせ」に
	@Around("execution(* com.example.demo.controller.UserController.*(..)) ||"
			+ "execution(* com.example.demo.controller.BlogController.*(..))")
	public Object checkLogin(ProceedingJoinPoint jp) throws Throwable {

		if (account == null || account.getName() == null
				|| account.getName().length() == 0) {
			System.err.println("ログインしていません!");

			// リダイレクト先を指定する
			// パラメータを渡すことでログインControllerで
			// 個別のメッセージをThymeleafに渡すことも可能
			return "redirect:/login?error=notLoggedIn";
		}
		// jp.proceed()でコントローラーの処理を実行
		return jp.proceed();
	}

}
