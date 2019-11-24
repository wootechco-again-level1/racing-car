# Racing Car

## 기능 목록

### Car
- 이름(1자 이상, 5자 이하)을 가진다.
- 전진한 횟수를 가진다.
- NumberGenerator로 생성된 숫자가 4 이상이면 움직인다.

### Cars
- Car의 List를 가진다.
- 게임 한 라운드를 진행한다.
- Car들의 최대 위치를 이용해 우승자를 구한다.

### CarsCreator
- 사용자로부터 입력된 이름을 받아 Cars를 만든다.

### OneRound
- 게임이 한 라운드 진행됐을 때 Cars의 상태를 저장한다.

### RoundsResult
- 게임이 진행되는 동안 만들어진 OneRound를 저장한다.

### Winners
- 가장 멀리 나아가 우승한 Car들을 저장한다.

### RacingCarGame
- Cars, 사용자로부터 입력된 게임 진행 횟수, NumberGenerator를 받아 게임을 진행한다.

### RandomNumberGenerator
- NumberGenerator 인터페이스를 구현하여, 0 이상 9 이하의 숫자 하나를 랜덤으로 반환한다.

### InputView
- 사용자로부터 Car들의 이름, 게임 진행 횟수를 입력받는다.

### OutputView
- 게임의 진행 결과와 우승자를 출력한다.

### RacingCarApplication
- 게임 전체를 진행하는 컨트롤러이다.