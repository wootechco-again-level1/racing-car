# racing-car
java racing car study



## 기능 목록

## 도메인

### Car

- 이름을 가진다
  - 5자 이하만 가능하다
- 레이스를 실행한 횟수를 가진다
- 전진한 횟수를 가진다
- 레이스를 한 번 실행하면 전진하거나 정지한다.
  - 전진/정지 여부는 DetermineMovement의 실행 결과로 구분한다.
  - DetermineMovement는 생성 시 받는다.
  - 레이스 한번 실행시 레이스 실행 횟수를 -1 한다.
  - 만약 전진이면 전진한 횟수를 +1 한다.
- 현재 전진한 횟수를 반환한다.
- <u>굳이 move()가 public으로 테스트를 받아야할 필요가 있을까?</u>
- <u>getRandomNumber()를 CarUtils로 뺄까?</u>
- <u>CarName 객체를 만들까..?</u>



### DetermineMovement

- 움직이거나 아니거나를 true/false로 결정
- true/false를 가릴 로직을 받음



### RaceCount

- 생성자로 총 레이스갈 횟수를 받는다.
  - 생성시 숫자를 가지면 1보다 커야한다.
- -1 할 수 있다.
  - 단 -1 값이 0 미만이 되면 안된다.
- 값이 0인지 확인할 수 있다.



### ForwardCount

- 자동차가 전진한 횟수를 가진다.
  - 생성시 무조건 0으로 초기화한다.
- 조건이 참일 경우 +1을 한다.



### Cars

- Car를 리스트로 가지고 있는 객체
- 이름 리스트와 DetermineMovement, RaceCount를 생성자로 받는다.
- Car 리스트 자체를 받을 수도 있다.
- 현재 점수가 가장 높은 자동차들을 리턴하는 로직이 있다.



### RacingCars

- 실행할 레이스의 값을 가진다.
- 참여한 자동차들을 가진다.
- 생성자로 실행할 레이스의 값과 자동차 이름들 받는다.
- 남아있는 레이스 값이 있는지 확인하는 로직이 있다.
- 레이스를 실행하는 로직이 있다.
- 현재 모든 자동차들을 리턴하는 로직이 있다.
- 최종 점수가 가장 높은 자동차들을 리턴하는 로직이 있다.



## DTO



### 자동차 이름 입력

- <u>input : 문자열 한 줄</u>
- convert : `,`를 기준으로 구분, 앞뒤 공백 제거, `List<String>`으로 변경
- NamesRequestDto
- Cars 생성



### 시도할 횟수 입력

- <u>input : `int` 하나</u>
- convert : 없음.
- RaceCountRequestDto
- RaceCount, RacingCars 생성



### 실행

- convert : `Map<자동차이름(String),전진 횟수(int)>` 로 변경
- <u>RaceProcessResponseDto</u>
- <u>output : `이름` : `- x 전진횟수` 로 표시</u>



### 최종 결과

- convert : `List<자동차이름(String)>` 로 변경
- <u>RaceWinnerResponseDto</u>
- <u>output: `이름,이름` 으로 표시</u>



## 규칙

- Controller에선 Dto만 사용한다.
- service에서 domain을 사용한다.
- main에서 controller와 view 사이에 데이터를 주고 받는다.