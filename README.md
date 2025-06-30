# 자바 알고리즘 및 코딩테스트
## 개요
본 저장소는 자바를 활용한 알고리즘 문제 풀이와 코딩 테스트 대비를 위한 스터디용 공간입니다.  
각자 실력 향상과 코드 리뷰를 통해 문제 해결 능력을 높이고,  
다양한 접근 방식과 알고리즘을 함께 학습하는 것을 목표로 합니다.

스터디원들은 매주 정해진 문제를 풀고,  
개인 폴더에 소스코드를 업로드한 뒤 Pull Request를 통해 코드 공유 및 피드백을 진행합니다.

## ✅ 디렉토리 구조
```
Algorithm/
├── src/
│   ├── week01/
│   │   ├── yeopee/
│   │   │   ├── BOJ_1000.java
│   │   │   └── PG_1000.java
│   │   ├── hyeon/
│   │   │   └── PG_42576.java
│   │   └── README.md   ← week01 문제 목록/링크 정리
│   ├── week02/
│   │   ├── yeopee/
│   │   │   └── PG_43105.java
│   │   └── README.md
│   └── ... (week03, week04 등)
├── .github/
│   └── workflows/
│       └── java-ci.yml   ← GitHub Actions (자동 컴파일 체크)
├── .gitignore
├── README.md             ← 전체 스터디 소개, 규칙, 참여자 안내 등
└── PULL_REQUEST_TEMPLATE.md
```
- `src/week01`, `src/week02` 형태로 생성  
- 각 주차 폴더 내에 스터디원 별 디렉터리를 만들어 풀이 업로드  
- 주차 폴더에 `README.md`를 작성해 해당 주차 문제 목록/링크를 정리

### 파일 이름 규칙
- 문제 출처에 따라 아래 규칙을 따릅니다:

| 플랫폼 | 파일명 규칙 | 예시 |
|--------|-------------|------|
| 백준   | `BOJ_문제번호.java` | `BOJ_1000.java` |
| 프로그래머스 | `PG_문제번호.java` | `PG_42576.java` |
| SWEA   | `SW_문제번호.java` | `SW_1234.java` |

## 백준 파일 문제 번호 예시
![image](https://github.com/user-attachments/assets/a7d778e3-c9f9-4222-84ee-899a236daf2f)

## 프로그래머스 파일 문제 번호 예시
![image](https://github.com/user-attachments/assets/f43b8b51-a2e7-4b2f-8068-0246637fe241)

## SWEA 파일 문제 번호 예시
![image](https://github.com/user-attachments/assets/90966f00-bcf3-443b-9c77-de567787d702)
