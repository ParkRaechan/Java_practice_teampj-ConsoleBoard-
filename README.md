# ConsoleBoard
5. 게시판
- 주요기능 : 회원가입 로그인 글쓰기 글보기

- 희망기능 :  
      
1순위 : 카테고리, 댓글, 추천/비추천, 검색기능, 글수정/삭제
2순위 : 포인트(글쓰기 2포인트, 댓글 1포인트, 출석체크 1포인트(하루한번)), 인기글, 포인트랭킹
3순위 : 복권, 댓글수정/삭제, 신고
4순위 : 친구추가, 쪽지기능
5순위 : 답글달기

부가적기능)
관리자 기능 : 누적신고수 확인, 댓글/게시글 삭제, 포인트 주기/뺏기


메인화면
컨트롤러
회원
- id, pw, 이름, 이메일, 전화번호, 포인트, 차단유저목록(리스트), 신고누적횟수, 친구
게시판
-게시물 제목, 게시물 내용,게시물 작성자, 날짜, 조회수, 카테고리, 추천수, 비추천수, 댓글클래스 , 신고누적횟수
댓글
-댓글내용, 댓글 작성자, 날짜,추천수, 비추천수, 신고누적횟수




*컨트롤러*
총괄 래찬
- 회원가입 메소드 [2] 지웅
- 로그인 메소드 [2] 지웅
- 글쓰기 메소드 [2] 요한
- 글상세보기 메소드 [2] 요한
------------------------------------------------------
- 카테고리 글 출력 메소드 [3] 요한
- 댓글 작성 메소드 [3] 요한
- 글수정 메소드 [2] 지웅
- 글삭제 메소드 [2] 지웅
- 검색 메소드 [2] 지웅
------------------------------------------------------목요일~금요일(30)
- 인기글 메소드 [5] 래찬
- 댓글 수정 메소드 [2] 요한
- 댓글 삭제 메소드 [2] 요한
------------------------------------------------------
- 복권 메소드 [3] 지웅
- 포인트랭킹 메소드 [5] 래찬
- 신고 메소드 [5] 지웅
-----------------------------------------------------주말~월요일(30)
- 친구추가 메소드 [2] 요한
- 쪽지확인 메소드 [2] 요한
- 쪽지 보내기 메소드 [2] 지웅
----------------------------------------------------
- 답글달기 메소드 [2] 요한


*파일처리*
- 게시물 저장 메소드 [3]
- 게시물 불러오기 메소드 [3]
   -제목,내용,작성자,날짜,조회수,추천수,비추천수,신고누적횟수

- 회원 저장 메소드 [1]
- 회원 불러오기 메소드 [1]

- 댓글 저장 메소드 [1]
- 댓글 불러오기 메소드 [1]
래찬
