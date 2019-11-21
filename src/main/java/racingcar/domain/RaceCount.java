package racingcar.domain;

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

    public RaceCount(final PlayCount playCount) {
        this.playCount = playCount;
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
}
