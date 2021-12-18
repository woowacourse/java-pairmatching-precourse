# 미션 - 페어매칭관리 애플리케이션

## 구현 목록

### enum 1. 과정
- 이름 반환 ( -> String 이름)

### enum 2. 레벨
- 이름 반환 ( -> String 이름)

### enum 3. 미션
- 이름 반환 ( -> String 이름)
- 레벨 반환 ( -> Level 레벨)

### enum 4. 크루
- 크루 리스트 반환 ( -> List<String>) (백/프론트)

### 페어 리스트 저장소
1. 필드값 : HashMap<Course, HashMap<Level, HashMap<Crew, HashSet(Crew)> > >
   - Course - Front/Back 구분
   - Level - 1,2,4레벨 구분
   - Crew - 크루 이름
   - HashSet - 페어매치된 크루들 목록


### 협력 목록

#### 메인(Application)
1. 기능선택 ( int 작업번호 -> )

#### 페어 매칭
1. 과정, 레벨 미션 출력 ( -> )
2. 매칭 기능 입력 -> ( (콘솔:과정,레벨,미션) -> )
3. 매칭 결과 출력 ( -> )

#### 페어 조회
1. 매칭 결과 출력 ( (콘솔:과정,레벨,미션)  -> )


#### 페어 초기화
1. 페어 초기화 하기 ( -> )