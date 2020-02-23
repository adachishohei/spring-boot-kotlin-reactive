# spring-boot-kotlin-reactive

### 概要

SpringbootをWebFluxを使った、リアクティブなAPI実装のサンプル
Colorを使った簡単なCRUD操作が行える

### 使った技術

- SpringBoot
- Kotlin
- MySQL
- R2DBC
- RouterFunction
- Coroutine
- WebFlux

### セットアップ

1. テーブルの構築

```sql
CREATE TABLE `color` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `code` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

2. 実行

```
./gradlew bootRun
```


### TODO

- 登録・編集・削除時のCoroutineを使った時の、データの返し方を考える
- 諸々のバリデーションと例外ハンドリング

