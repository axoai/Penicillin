[![Kotlin 1.2.70](https://img.shields.io/badge/Kotlin-1.3.0-blue.svg)](http://kotlinlang.org)
[![Maven Central](https://img.shields.io/maven-central/v/jp.nephy/penicillin.svg)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22jp.nephy%22)
[![Travis](https://img.shields.io/travis/NephyProject/Penicillin.svg)](https://travis-ci.org/NephyProject/Penicillin/builds)
[![MIT License](https://img.shields.io/github/license/NephyProject/Penicillin.svg)](https://github.com/NephyProject/Penicillin/blob/master/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/NephyProject/Penicillin.svg)](https://github.com/NephyProject/Penicillin/issues)


Penicillin: Full-featured Twitter API wrapper for Kotlin.
===========================

- すべての公開Twitter APIと認証方式(OAuth 1.0a, OAuth 2.0)に対応しています.
- 一部の非公開APIに対応しています(投票など). 今後もサポートを充実する予定です.
- 全エンドポイントのパラメータがKotlinの名前付き引数として解決できるため, 簡単にAPIが利用できます.
- 全エンドポイントのレスポンスのモデルクラスが用意されているので, APIの返り値の利用が容易にできます.
- 非同期なAPI実行に対応しています.
- カーソル操作があるエンドポイントでは`.next()`や`.untilLast()` といったメソッドでページングできます.

もし未対応のエンドポイントやバグを発見した際は, お気軽に [Issue](https://github.com/NephyProject/Penicillin/issues) を立ててください. すぐに対応します.


- [サンプル](https://github.com/NephyProject/Penicillin/wiki/Sample-%5Bja%5D) / [Sample](https://github.com/NephyProject/Penicillin/wiki/Sample-%5Ben%5D)
- 導入 / Get Started
  - [with Gradle](https://github.com/NephyProject/Penicillin/wiki/Get-Started#gradle-buildgradle)
  - [with Maven](https://github.com/NephyProject/Penicillin/wiki/Get-Started#maven)
- [変更履歴 / Change Logs](https://github.com/NephyProject/Penicillin/wiki/Change-Logs)
- [Contributing](https://github.com/NephyProject/Penicillin/wiki/Contributing)

License
---------
Penicillin is provided under MIT license. A copy of MIT license of Nephy Project is available [here](https://nephy.jp/license/mit).

Copyright (c) 2018 Nephy Project.
