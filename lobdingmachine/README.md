1. 모델 생성
	- `kr.co.ldcc.lobdingbachine.model`에 알맞은 이름으로 package생성 (비슷한 객체끼리 묶기위해! 이미 존재하면 그쪽에 객체만들면됨)
	- 해당 객체 생성(보통 테이블과 비슷한 형태)
	
2. DAO 생성
	- `kr.co.ldcc.lobdingbachine.dao`에 인터페이스 생성 후, `@Mapper`를 붙여줌
	- 해당 인터페이스에 쿼리를 날리기위함 함수를 만듦 (ex : `List<PopularSearch> getPopularSearch();`)
	- `src/main/resources/mapper`에 디렉토리를 만들고, 그안에 xml파일을 생성
	- 생성한 xml 파일에 다른 xml 파일을 복사해옴
	- id는 함수이름, parameterType은 파라미터, resultType은 리턴되는 type! 
	- `src/main/resources/mybatis-config.xml`에 생성한 model과 xml파일을 정의해줌
	
3. Controller 생성
	- `kr.co.ldcc.lobdingbachine.controller.app`안에 객체를 만들고 다른 객체 따라서 만들면됨