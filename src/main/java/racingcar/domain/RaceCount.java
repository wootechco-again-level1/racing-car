package racingcar.domain;

import java.util.Objects;

/**
 * playcount와 forwardcount를 가지고있는 객체.
 *
 * @author heebg
 * @version 1.0
 * @date 2019-11-20
 */
public class RaceCount {
    private final PlayCount playCount;
    private final ForwardCount forwardCount;

    public RaceCount(final int playCount) {
        this.playCount = new PlayCount(playCount);
        this.forwardCount = new ForwardCount();
    }

    /**
     * 결과에 따라 forwardCount값 증가. <br/>
     * playRaceCount값 감소.
     *
     * @param predicate
     */
    public void race(final boolean predicate) {
        if (predicate) {
            forwardCount.increase();
        }
        playCount.decrease();
    }

    public int getForwardCount() {
        return forwardCount.getCount();
    }

    public int getPlayCount() {
        return playCount.getCount();
    }

    @Override
    public String toString() {
        return "RaceCount{" +
            "playCount=" + playCount +
            ", forwardCount=" + forwardCount +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCount raceCount = (RaceCount) o;

        if (!Objects.equals(playCount, raceCount.playCount)) return false;
        return Objects.equals(forwardCount, raceCount.forwardCount);
    }

    @Override
    public int hashCode() {
        int result = playCount.hashCode();
        result = 31 * result + forwardCount.hashCode();
        return result;
    }
}
