# 페어 매칭관리 어플리케이션

### 구현할 기능 목록

#### 기능 선택하기

- 4가지 기능 중 한 가지를 선택한다.

```1. 페어 매칭
2. 페어 조회
3. 페어 초기화
Q. 종료
```

- [예외] 1,2,3,Q의 입력만 받을 수 있다.

#### 페어 매칭 선택 시

- 과정와 미션을 출력한다.
- 매칭하고자 하는 과정, 레벨, 미션을 입력 받는다.

  - [예외] 과정, 레벨, 미션 형식으로 입력한다. ( ,)로 구분
  - [예외] 과정에는 백엔드 또는 프론트엔드만 입력한다.
  - [예외] 레벨에는 레벨x (x = 1,2,3,4,5)만 입력한다.
  - [예외] 미션에는 각 레벨에 존재하는 미션만 입력한다.

- 매칭 정보가 존재한다면 원래 존재하던 것을 볼 지, 다시 매칭할 지 입력한다.

  - [예외] `네 또는 아니오`만 입력한다.

- `예`를 입력한 경우 원래 존재하던 매칭 정보를 보여준다.

- `아니오`를 입력한 경우 새롭게 입력했던 매칭에 대한 정보를 보여준다.
