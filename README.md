# Bulletin Board System
`게시판` 웹 애플리케이션 프로젝트 입니다. <br/><br/>
 `2022.08.04 ~ 2022.08.07` 동안 `Spring Boot` 와 `React` 를 사용해 구현했습니다.

# 📚 목차
* [프로젝트 구조](#-프로젝트-구조)
* [사용 기술](#-사용-기술)
* [구현 기능](#-구현-기능)
* [기능 실행화면](#-기능-실행화면)
* [API 명세서](#-API-명세서)
* [ERD 설계](#-ERD-설계)

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
<details>

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
</details>  
  
# 🤙🏻 API 명세서
HTTP 메서드를 통해 행위를 명시할 수 있도록 RESTful 방식으로 설계했습니다. <br/><br/>

<img width="997" alt="api-definition" src="https://user-images.githubusercontent.com/43202607/183290134-6aeeb889-2efd-4f18-ad53-7179a624e7e8.png">

# 🕸 ERD 설계
<img width="997" alt="erd" src="https://user-images.githubusercontent.com/43202607/183290205-3d55c22f-7564-4b75-b955-e33f505e99cd.png">

# 👾 트러블슈팅
### 회원 인증 및 인가 기능 구현 (Spring Security)

### CORS

### DTO 클래스 분리의 장단점


