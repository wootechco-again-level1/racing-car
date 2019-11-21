package racingcar.domain;

/**
 * 자동차가 게임 도중 앞으로 전진한 횟수를 나타내는 객체.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class ForwardCount {
    private static final int INIT_COUNT = 0;

    private int count;

    public ForwardCount() {
        this.count = INIT_COUNT;
    }

    /**
     * count 값을 1 증가 시킨다.
     *
     * @param condition
     */
    public void race(boolean condition) {
        if (condition) {
            increase();
        }
    }

    private void increase() {
        count++;
    }

    /**
     * count 값이 같은지 확인.
     *
     * @param count
     * @return
     */
    public boolean isSameCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "ForwardCount{" +
            "count=" + count +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForwardCount that = (ForwardCount) o;

        return count == that.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
