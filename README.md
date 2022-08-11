# Bulletin Board System
`게시판` 웹 애플리케이션 프로젝트 입니다. <br/><br/>
 `2022.08.04 ~ 2022.08.07` 동안 `Spring Boot` 와 `React` 를 사용해 구현했습니다.
 
이 프로젝트를 통해 이루고자 한 목표는 `Spring에서 제공하는 프레임워크를 직접 사용해 보기` 였습니다. 
프로젝트 구현 과정 동안 회원 인증/인가, 예외처리를 고민하며 코드를 작성했습니다.


# 📚 목차
* [프로젝트 구조](#-프로젝트-구조)
* [사용 기술](#-사용-기술)
* [구현 기능](#-구현-기능)
* [기능 실행화면](#-기능-실행화면)
* [API 명세서](#-API-명세서)
* [ERD 설계](#-ERD-설계)
* [트러블슈팅](#-트러블슈팅)

# 🎃 프로젝트 구조
### 📌 Backend
<img width="575" alt="backend-project-structure" src="https://user-images.githubusercontent.com/43202607/183297576-86a27c9f-d2cd-46ce-8f21-eb9845fe3caa.png">


### 🥕 Frontend
<img width="574" alt="frontend-project-structure" src="https://user-images.githubusercontent.com/43202607/183297579-ddaad9a7-3d2b-467f-8519-c639e0feb8f3.png">


# 🕹 사용 기술
### 📌 Backend
|기술|버전|
|----|----|
|Spring Boot|2.7.2|
|Spring Security|2.7.2|
|Bean Validation|2.7.2|
|JSON Web Token|0.9.1|
|MyBatis|2.1.3|
|MySQL Connector J|8.0.28|
|Swagger|3.0.0|

### 🥕 Frontend
|기술|버전|
|----|----|
|NodeJS|16.16.0|
|React|18.2.0|
|axios|0.27.2|
|react-axios|2.0.6|
|react-dom|18.2.0|
|react-js-pagination|3.0.3|
|react-router|6.3.0|
|react-router-dom|6.3.0|
|react-scripts|5.0.1|

# 🎢 구현 기능
* 게시판 기능
  * 모든 게시글 및 특정 게시글 조회
  * 게시글 검색 (제목, 내용, 작성자)
  * 게시글 작성 [회원]
  * 게시글 수정 [회원, 게시글 작성자]
  * 게시글 삭제 [회원, 게시글 작성자]
  * 게시글 답글 작성 [회원]
* 댓글 기능
  * 댓글 조회
  * 댓글 작성 [회원]
  * 댓글 수정 [회원, 댓글 작성자]
  * 댓글 삭제 [회원, 댓글 작성자]
* 회원 기능
  * 회원가입
  * 로그인/로그아웃
  
# 🍭 기능 실행화면

## 게시판 기능
### 모든 게시글 및 특정 게시글 조회
* 모든 게시글을 조회할 수 있습니다. 페이징 기능을 통해 한 페이지에서 최대 10개의 게시글이 조회됩니다.
<img width="1724" alt="bbslist1" src="https://user-images.githubusercontent.com/43202607/183294682-811f8e84-b5b1-4476-9e5c-959c40c92482.png">
<img width="1724" alt="bbslist2" src="https://user-images.githubusercontent.com/43202607/183294659-bd54745a-45aa-4765-99ee-9c17c67dc648.png">

* 게시글의 제목을 클릭하면, 게시글의 상세 내용을 조회할 수 있습니다.
<img width="1724" alt="bbsdetail1" src="https://user-images.githubusercontent.com/43202607/183294838-c7d9a344-b00f-4467-b4d5-4db6f1a74cb2.png">
<img width="1724" alt="bbsdetail2" src="https://user-images.githubusercontent.com/43202607/183294851-20b6e927-4bb2-4e34-b050-3d8b6e21b2d9.png">


### 게시글 검색
* 게시글의 제목과 내용 또는 작성자로 게시글을 검색할 수 있습니다.
<img width="1724" alt="bbs-search" src="https://user-images.githubusercontent.com/43202607/183294908-b849e173-3ace-41bd-b316-5ca71d74f046.png">


### 게시글 작성
* 로그인한 사용자는 게시글을 작성할 수 있습니다.
<img width="1724" alt="bbs-write" src="https://user-images.githubusercontent.com/43202607/183295068-8fc5dc5f-bbb9-44c4-87b7-8d23bad2f887.png">
<img width="1724" alt="bbs-write-success" src="https://user-images.githubusercontent.com/43202607/183295056-72b89db7-2e88-4628-9195-66dabc2b3fed.png">
<img width="1724" alt="bbs-write-result" src="https://user-images.githubusercontent.com/43202607/183295063-b76de0dc-3497-4384-90a9-3eb71d86ce8e.png">

* 로그인하지 않았을 경우 글 작성이 제한됩니다.
<img width="1724" alt="bbs-write-auth" src="https://user-images.githubusercontent.com/43202607/183295121-58b3a5eb-3b11-415e-a4fb-c67d75a6c37d.png">


### 게시글 수정
* 게시글 작성자는 게시글을 수정할 수 있습니다. 
<img width="1724" alt="bbs-update" src="https://user-images.githubusercontent.com/43202607/183295328-17e3da89-21c1-41d9-8def-a6aa1ee5662a.png">
<img width="1724" alt="bbs-update2" src="https://user-images.githubusercontent.com/43202607/183295289-19ad2629-68e4-4891-a232-1a0128d04bf1.png">
<img width="1724" alt="bbs-update-success" src="https://user-images.githubusercontent.com/43202607/183295332-523f981a-278f-4729-8fe5-e28d2c1e42e7.png">

* 자신이 작성한 게시글에만 수정, 삭제 버튼이 활성화됩니다.
![bbs-update-delete-btn-deactive](https://user-images.githubusercontent.com/43202607/183295398-a3d3b599-90ea-4356-be7a-793736fee4e9.png)
<img width="1724" alt="bbs-update-delete-btn-active" src="https://user-images.githubusercontent.com/43202607/183295443-8729288a-9dc3-4809-a0ee-5ad735c23bcf.png">

### 게시글 삭제
* 게시글 작성자는 게시글을 삭제할 수 있습니다.
<img width="1724" alt="bbs-delete" src="https://user-images.githubusercontent.com/43202607/183295478-3fb544f3-11fa-4a62-a8bd-8254fbd9dc95.png">
<img width="1724" alt="bbs-delete-result" src="https://user-images.githubusercontent.com/43202607/183295579-50135571-e6a3-4a66-a169-d98d27f834c2.png">


### 게시글 답글 작성
* 하나의 게시글에 대한 답글을 작성할 수 있습니다. `게시글 작성` 과 마찬가지로 로그인한 사용자만 답글을 작성할 수 있습니다.
<img width="1724" alt="bbs-answer1" src="https://user-images.githubusercontent.com/43202607/183295700-405f212f-d622-4b2c-88bc-beb543a4a25d.png">
<img width="1724" alt="bbs-answer2" src="https://user-images.githubusercontent.com/43202607/183295709-f3790b18-ce98-4857-b9e1-47f95cb8d147.png">
<img width="1724" alt="bbs-answer3" src="https://user-images.githubusercontent.com/43202607/183295712-a931f628-b2b9-44dc-9036-4170774920fc.png">
<img width="1724" alt="bbs-answer4" src="https://user-images.githubusercontent.com/43202607/183295729-4860a08b-f698-4087-9dde-1e0781b09093.png">


## 댓글 기능
### 댓글 조회
* `게시글 상세` 에서 관련된 댓글을 조회할 수 있습니다. 페이징 기능을 통해 한 페이지에서 최대 5개의 댓글이 조회됩니다.
<img width="1724" alt="comment1" src="https://user-images.githubusercontent.com/43202607/183295890-bca96b8e-dc81-4b17-931b-246664a6d6cd.png">
<img width="1724" alt="comment2" src="https://user-images.githubusercontent.com/43202607/183295887-f6f06db8-5f75-4dba-93a9-24eb29153700.png">


### 댓글 작성
* 로그인한 사용자는 댓글을 작성할 수 있습니다.

<img width="1680" alt="comment-write1" src="https://user-images.githubusercontent.com/43202607/183296007-26bbc9e4-f6de-4daf-aef9-ef261b978ee7.png">
<img width="1724" alt="comment-write2" src="https://user-images.githubusercontent.com/43202607/183296016-19c585ef-04ee-4452-9546-608876c2c3d8.png">


### 댓글 수정
* 자신이 작성한 댓글을 수정할 수 있습니다.
<img width="1724" alt="comment-update1" src="https://user-images.githubusercontent.com/43202607/183296205-aa135997-27a2-40f0-a2a3-5611640768a3.png">
<img width="1724" alt="comment-update2" src="https://user-images.githubusercontent.com/43202607/183296209-ae3ff631-5014-405b-b2b0-7659fe26edb6.png">
<img width="1724" alt="comment-update3" src="https://user-images.githubusercontent.com/43202607/183296211-6bb4f080-e2ce-4be7-89ae-713709f104ab.png">

### 댓글 삭제
* 자신이 작성한 댓글을 삭제할 수 있습니다.
<img width="1724" alt="comment-delete" src="https://user-images.githubusercontent.com/43202607/183296297-d81bdc9e-410f-4cdb-bfec-cbc066a90a9f.png">
<img width="1680" alt="comment-delete2" src="https://user-images.githubusercontent.com/43202607/183296289-a23f7cbb-bdd0-49ab-994f-618f49638446.png">


## 회원 기능
### 회원가입
* 회원가입 시 아이디 중복을 체크합니다.
<img width="1532" alt="signup-idcheck" src="https://user-images.githubusercontent.com/43202607/183293384-c6729cec-bbe1-4244-8ff5-4bac37cfb25b.png">


* 회원가입을 통해 서비스에 사용자 정보를 저장합니다.
<img width="1532" alt="signup-success" src="https://user-images.githubusercontent.com/43202607/183293393-52ccf9f7-90a0-420e-ac71-60baec18b791.png">


### 로그인/로그아웃
* 로그인
<img width="1532" alt="login-form" src="https://user-images.githubusercontent.com/43202607/183293389-8dceae44-f5c5-4381-ac5e-244e868a7813.png">
<img width="1532" alt="login-success" src="https://user-images.githubusercontent.com/43202607/183293435-e707c650-696f-408f-8ba3-11acbac5b989.png">

  * 로그인을 완료하면 브라우저의 `Local Storage` 에 사용자 `id` 와 `JWT` 토큰 정보를 저장합니다.
  <img width="1374" alt="login-after-devtool" src="https://user-images.githubusercontent.com/43202607/183293460-68a98ae0-9e13-47c9-88f4-6ca5b429dc1a.png">


* 로그아웃
<img width="1724" alt="logout" src="https://user-images.githubusercontent.com/43202607/183296452-126a6bcc-3223-4230-88b0-0d2a51111b56.png">


* 로그아웃을 완료하면 브라우저의 `Local Storage` 의 내용도 삭제합니다.
<img width="1374" alt="logout-after-devtool" src="https://user-images.githubusercontent.com/43202607/183296489-b4710d6b-380d-4293-a102-a96735bd4749.png">
  
# 🤙🏻 API 명세서
HTTP 메서드를 통해 행위를 명시할 수 있도록 RESTful 방식으로 설계했습니다. <br/><br/>

<img width="997" alt="api-definition" src="https://user-images.githubusercontent.com/43202607/183290134-6aeeb889-2efd-4f18-ad53-7179a624e7e8.png">

# 🕸 ERD 설계
<img width="997" alt="erd" src="https://user-images.githubusercontent.com/43202607/183290205-3d55c22f-7564-4b75-b955-e33f505e99cd.png">

# 👾 트러블슈팅
### 회원 인증 및 인가 기능 구현 (Spring Security + JWT)

회원 및 비회원에 따라 가용한 기능에 제약을 두기 위해 Spring Security + JWT 토큰 방식으로 구현했다.

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/security/WebSecurityConfig.java#L35-L56

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/jwt/JwtAuthenticationFilter.java#L35-L70



간단한 BBS 시스템을 만드는 것을 목표로 했으나, Spring Security 를 사용하니 인증 로직을 구현하기 복잡했다. Spring Security 의 동작 원리를 정확하게 모르는 상태에서 구현하려 하니 어려움이 있었다. (배보다 배꼽이 더 커진 느낌 🫤)

Spring 에서 제공하는 Interceptor 기능과 ArgumentResolver, Annotation 기능을 사용하고 사용자 아이디만을 받아 인가 체크를 했다면 간단하게 구현 가능했을 것 같다.



요청을 보낸 사용자를 판별하기 위해 `@AuthenticationPrincipal` 을 사용하여, 로그인 시 인증한 후 저장한 사용자 정보인 `UserDetails` 의 `username(Id)` 를 가져와 글 작성자와 비교했다.

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/comment/controller/CommentController.java#L61-L68

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/comment/service/CommentService.java#L52-L68

<br/><br/>
### 사용자 로그인 요청 데이터 검증과 사용자 인증 예외 처리

사용자가 회원가입과 로그인을 위해 입력한 데이터에 대해 `Bean Validation` 을 사용해 검증 기능을 구현했다.

템플릿 엔진으로 서버에서 뷰를 그리는 방식이 아닌, 데이터만 전송하는 API 서버에서 입력값 검증에 대한 오류 메시지를 어떻게 전달해야 할지 고민했었다.

 `Bean Validation` 에서 던진 예외를 받아서 처리한 다음 오류 메시지를 응답으로 내려주도록 구현했다.



* **회원가입 요청 폼 데이터**

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/member/dto/request/JoinRequest.java#L5-L21


* **회원 가입 요청 처리 컨트롤러**

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/member/controller/MemberController.java#L57-L71
  

또한 사용자 관련 예외를 처리하기 위해 커스텀 예외를 만들어서 예외를 발생시키고 핸들러에서 처리할 수 있도록 구현했다.

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/member/service/MemberService.java#L95-L106

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/member/controller/MemberController.java#L73-L79



`@AdviceController` 를 더 많이 사용한다고 했는데, 이 프로젝트에서는 회원 관련된 예외 처리만을 작성하기 위해 전역 예외처리를 사용하지 않았다. 또한 평소에도 컨트롤러별로 처리하는 예외를 세분화 하는게 좋지 않을까? 라는 생각을 가지고 있었다. 

하지만 결국 어떤 예외처리든 서버에서 발생한 예외를 처리한 다음 요청을 보낸 프론트 쪽으로 상태 코드든 오류 메시지든 내려줘야 한다. 따라서 커스텀 예외와 예외 메시지를 범용성 있게 작성하면 오히려 전역에서 예외처리 하는게 일관성 있을 것이라는 깨달음을 얻었다.


<br/><br/>
### DTO 클래스 분리

요청과 응답으로 주고받는 데이터를 한 눈에 확인하기 위해 요청 데이터와 응답 데이터를 각각의 DTO로 분리했다.

요청으로 받은 데이터를 바탕으로 SQL 쿼리를 수행할 때 필요한 데이터만을 넘겨주기 위해 Service에서 Dao로 넘기는 파라미터도 DTO로 분리했다.


<img width="558" alt="project-structure" src="https://user-images.githubusercontent.com/43202607/184118909-0a503b1c-23c1-469b-94f7-4e5b67bbf0b0.png">


이렇게 구현했을 때의 장점은 컨트롤러 메서드의 파라미터로 많은 인자를 넘겨주지 않아도 된다는 점, 주고받는 데이터를 확인하고 수정해야하는 경우 DTO 클래스 만을 수정해야 하는 점이었다.

하지만 단점은 기능이 추가될 때마다 클래스 파일이 늘어나 관리가 힘들어졌고, 데이터를 한 눈에 확인할 수 있지만 확인하기 위해서는 직접 클래스 파일을 열어봐야 한다는 점 이었다.

요청 파라미터가 많지 않은 경우 (2-3개) 굳이 클래스 파일로 따로 작성하지 않고 컨트롤러 메서드에 어노테이션으로 매핑하는 것이 코드의 가독성과 유지보수 측면에서 좋은 방법이 될 것이라 생각된다.


<br/><br/>
### 조회수 중복 카운팅 예방

게시글 조회수 중복 카운팅 예방을 위해 `read_history` 테이블을 두어 구현했다. 

`Cookie` 의 경우 하나의 도메인 당 사용할 수 있는 개수가 제한되기 때문에, 여러 게시글을 조회하면 제한 개수를 넘어버릴 것이라 예상했다. 그래서 사용자가 이미 읽은 게시글인지 확인할 수 있도록 서버에서 `사용자 아이디` `게시글` `조회 시간` 을 두어 체크했다.

https://github.com/hellonayeon/bbs/blob/aede584cff3b95566f3f5a77052d603fe01461c5/backend/src/main/java/me/hellonayeon/backend/bbs/service/BbsService.java#L45-L58

스케쥴러를 구현해 24시간 단위로 조회수를 초기화 시켜서 다음날이 되면 조회수가 다시 카운팅 될 수 있게끔 구현하면 좋을 것 같다. 아니면 조회수라는 데이터를 관리하지 않고 읽은 글, 읽지 않은 글 로 관리될 수 있도록 구현하는 것도 하나의 좋은 방법이라 생각한다.


