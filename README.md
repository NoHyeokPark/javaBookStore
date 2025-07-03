# 📚 Java 온라인 서점 시스템

> 자바로 구현한 콘솔 기반 온라인 서점 프로젝트

## 📖 프로젝트 소개

온라인으로 책을 구매할 수 있는 웹 서점을 자바로 구현하고 콘솔을 통해 출력하는 프로젝트입니다.
홈페이지에서 책을 검색하고 장바구니에 담고 구매한 뒤 배송상황을 조회하는 과정을 구현하여 JDBC CRUD와 UI-Service-DAO 구조를 학습할 수 있습니다.

## 🎯 프로젝트 목적

- **JDBC CRUD 학습**: 데이터베이스 연동을 통한 생성, 조회, 수정, 삭제 기능 구현
- **아키텍처 이해**: UI - Service - DAO 3계층 구조 학습
- **실무 경험**: 실제 온라인 서점과 유사한 비즈니스 로직 구현

## ⚡ 주요 기능

### 👤 회원 관리
- **로그인 / 회원가입**: 신규 회원 등록 및 기존 회원 인증
- **회원 정보 수정**: 개인정보 변경 및 업데이트
- **아이디 찾기**: 등록된 정보를 통한 아이디 찾기
- **비밀번호 재발급**: 보안 질문을 통한 비밀번호 재설정

### 📚 도서 관리
- **도서 검색**: 
  - 전체 도서 목록 조회
  - 카테고리별 도서 검색
  - 제목, 저자, 키워드 검색
- **검색 결과 페이징**: 대량의 검색 결과를 페이지별로 분할 표시
- **도서 상세 정보**: 도서 정보, 가격, 재고 현황 조회

### 💬 리뷰 시스템
- **도서 리뷰 작성**: 구매한 도서에 대한 리뷰 등록
- **평점 시스템**: 5점 만점 평점 등록 및 평균 평점 계산
- **리뷰 게시판**: 다른 사용자들의 리뷰 조회

### 🛒 쇼핑 기능
- **장바구니 담기**: 원하는 도서를 장바구니에 추가
- **합계 금액 표시**: 장바구니 내 총 금액 자동 계산
- **수량 조절**: 도서별 구매 수량 변경

### 🚚 주문 및 배송
- **배송지 등록**: 다중 배송지 등록 및 관리
- **결제 처리**: 주문 정보 확인 및 결제 진행
- **구매 내역 조회**: 과거 주문 정보 확인
- **배송 상태 추적**: 실시간 배송 현황 조회

### 🎧 고객 서비스
- **고객센터 게시판**: 문의사항 등록 및 답변 확인
- **FAQ**: 자주 묻는 질문 및 답변

## 🛠 기술 스택

### 개발 환경
- **IDE**: Eclipse / IntelliJ IDEA
- **JDK**: Java 8 이상
- **Database**: MySQL / Oracle DB
- **Build Tool**: Maven / Gradle

### 사용 기술
- **Backend**: Java
- **Database**: JDBC
- **Architecture**: UI - Service - DAO Pattern
- **Console**: Java Console Application

## 🏗 프로젝트 구조

```
src/
├── kr/
│   └── ac/
│       └── kopo/
│           ├── ui/              # 사용자 인터페이스 계층
│           │   ├── MainUI.java
│           │   ├── MemberUI.java
│           │   ├── BookUI.java
│           │   └── OrderUI.java
│           ├── service/         # 비즈니스 로직 계층
│           │   ├── MemberService.java
│           │   ├── BookService.java
│           │   ├── CartService.java
│           │   └── OrderService.java
│           ├── dao/             # 데이터 접근 계층
│           │   ├── MemberDAO.java
│           │   ├── BookDAO.java
│           │   ├── CartDAO.java
│           │   └── OrderDAO.java
│           ├── dto/             # 데이터 전송 객체
│           │   ├── Member.java
│           │   ├── Book.java
│           │   ├── Cart.java
│           │   └── Order.java
│           └── util/            # 유틸리티 클래스
│               ├── DBUtil.java
│               └── ValidationUtil.java
```

## 📋 데이터베이스 설계

### 주요 테이블
- **MEMBER**: 회원 정보 관리
- **BOOK**: 도서 정보 관리
- **CATEGORY**: 도서 카테고리 관리
- **CART**: 장바구니 관리
- **ORDER**: 주문 정보 관리
- **ORDER_DETAIL**: 주문 상세 정보 관리
- **REVIEW**: 도서 리뷰 관리
- **DELIVERY**: 배송 정보 관리

## 🚀 실행 방법

### 1. 프로젝트 다운로드
```bash
git clone https://github.com/NoHyeokPark/javaBookStore.git
cd javaBookStore
```

### 2. 데이터베이스 설정
```sql
-- 데이터베이스 생성
CREATE DATABASE bookstore;

-- 테이블 생성 스크립트 실행
-- (database/schema.sql 파일 참조)
```

### 3. 애플리케이션 실행
```bash
# 컴파일
javac -cp .:lib/* src/kr/ac/kopo/*.java

# 실행
java -cp .:lib/* kr.ac.kopo.Main
```

## 📱 사용법

### 메인 메뉴
1. **회원가입/로그인**
2. **도서 검색 및 조회**
3. **장바구니 관리**
4. **주문 및 결제**
5. **마이페이지**
6. **고객센터**

### 주요 사용 흐름
1. 회원가입 또는 로그인
2. 원하는 도서 검색
3. 도서 상세 정보 확인
4. 장바구니에 추가
5. 주문 정보 입력
6. 결제 완료
7. 배송 현황 조회

## 🎨 주요 학습 포인트

### JDBC 활용
- **Connection Pool**: 효율적인 데이터베이스 연결 관리
- **PreparedStatement**: SQL Injection 방지 및 성능 최적화
- **Transaction**: 데이터 무결성 보장

### 아키텍처 패턴
- **UI Layer**: 사용자 입력 처리 및 결과 출력
- **Service Layer**: 비즈니스 로직 처리
- **DAO Layer**: 데이터베이스 접근 로직

### 객체지향 설계
- **캡슐화**: 데이터와 메서드의 은닉화
- **상속**: 공통 기능의 재사용
- **다형성**: 인터페이스를 통한 유연한 구조

## 🔧 개발 환경 설정

### 1. JDK 설치
```bash
# JDK 8 이상 설치 확인
java -version
javac -version
```

### 2. 데이터베이스 드라이버 설정
```java
// MySQL 드라이버 예시
Class.forName("com.mysql.cj.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/bookstore";
Connection conn = DriverManager.getConnection(url, "username", "password");
```

### 3. 빌드 도구 설정 (Maven)
```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```

## 📈 향후 개선 계획

- **웹 인터페이스**: JSP/Servlet 또는 Spring Boot 적용
- **보안 강화**: 암호화 및 인증 시스템 개선
- **성능 최적화**: 캐싱 및 인덱싱 적용
- **모바일 지원**: 반응형 웹 디자인 구현

## 🤝 기여하기

1. 프로젝트를 Fork 합니다
2. 기능 브랜치를 생성합니다 (`git checkout -b feature/새기능`)
3. 변경사항을 커밋합니다 (`git commit -am '새 기능 추가'`)
4. 브랜치에 Push 합니다 (`git push origin feature/새기능`)
5. Pull Request를 생성합니다

## 📄 라이선스

이 프로젝트는 MIT 라이선스를 따릅니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

## 👨‍💻 개발자

**NoHyeokPark**
- GitHub: [@NoHyeokPark](https://github.com/NoHyeokPark)
- Email: your.email@example.com

## 📞 문의사항

프로젝트에 대한 질문이나 제안사항이 있으시면 언제든지 연락주세요!

- GitHub Issues: [이슈 등록](https://github.com/NoHyeokPark/javaBookStore/issues)
- Email: your.email@example.com

---

⭐ 이 프로젝트가 도움이 되셨다면 Star를 눌러주세요!