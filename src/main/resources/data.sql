-- categories テーブルにデータを挿入
INSERT INTO categories (id, name) VALUES
(1, '仕事'),
(2, '遊び'),
(3, '勉強');

-- users テーブルにデータを挿入
-- INSERT INTO users (id, email, name, password) VALUES
-- (1, 'tanaka@aaa.com', '田中太郎', 'test123'),
-- (2, 'suzuki@aaa.com', '鈴木一郎', 'test456'),
-- (3, 'testuser@com', 'テストユーザー', 'testuser');

-- 上記のようにidを指定してデータを挿入すると、idが重複エラーとなるため下記に修正
INSERT INTO users (email, name, password) VALUES
('tanaka@aaa.com', '田中太郎', 'test123'),
('suzuki@aaa.com', '鈴木一郎', 'test456'),
('testuser@com', 'テストユーザー', 'testuser'),
('test@com', 'テストマン', 'testuser');

-- blogs テーブルにデータを挿入
--INSERT INTO blogs (id, category_id, user_id, title, body) VALUES
--(1, 1, 1, '見積もり', '見積もり金額を明日までに提出');

INSERT INTO blogs (category_id, user_id, title, content) VALUES
(1, 1, '見積もり', '見積もり金額を明日までに提出'),
(2, 1, 'ゲームの作り方', 'ゲームの作り方を明日までに考える'),
(3, 1, 'コーヒー豆の煎り方', 'コーヒー豆の煎り方を明日までにマスターする'),
(1, 2, '請求', '請求金額を明日までに提出'),
(2, 2, '漫画の描き方', '漫画の描き方を明日までにマスターする'),
(3, 3, 'リマインド', '明日までにリマインドをする');
