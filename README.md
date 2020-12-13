[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fkenshin579%2Ftutorials-java-design-pattern&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

# Study: Java Design Pattern
--------------------------------
 
**스터디에 사용되는 자료**

* Java Design Pattern 열혈강의 (프리렉)

**참고자료**

* 디자인 패턴 입문 (영진)
* Head First Java Design Pattern

카페주소: http://cafe.naver.com/happinessfactory

**아직 정리되지 않는 패턴들**
* [last updated 10/20]State, Decorator, Adapter, Iterator, Interpreter, Observer

## 시스템 세팅 (Mac)
------------------------
Id | Password  
--- | ---
root |1234

### DB Setup

1. 소스에서 세팅된 DB 계정 정보 윗 테이블 참조 (id/passwd)
2. 위 정보를 이용해서 mysql DB 설정하기 (아래 링크 참조하세요)
	* 참고: installing mysql using homebrew, https://www.evernote.com/shard/s7/sh/7f91a75b-b3cc-477a-9e0c-72feb5457260/e5eac65a2d457536929ec0c697ba29c8
3. mysql schema (designdb) 생성하기

> mysql -u root -p 1234

> mysql> create schema designdb;

### IDE Setup
1. Intellij로 github project import하기
	* 메뉴에서 VCS > Checkout from Version Control > GitHub 선택하고 아래 github 주소 입력

<table>
<tr>
  <td> 
* Git Repository URL: https://github.com/kenshin579/java-design-pattern.git<br/>
* Parent Directory: /Users/kenshin579/IdeaProjects<br/>
* Directory Name: java-design-pattern</td>
</tr>
</table>
2. 예제 프로그램(freelec.strategy.Context) Intellij에서 실행하기
	* resources 폴더에 있는 mysql statement를 mysql DB console에서 실행시킨다. 
	* strategy > src > main > java > freelec.strategy > Context.java을 Project 메뉴에서 클릭하여 파일을 연다.
	* Shift + Ctrl + F9을 클릭하여 Debug Mode로 실행시킨다.