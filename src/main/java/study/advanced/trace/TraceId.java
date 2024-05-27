package study.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    public TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    // 동일한 아이디에 다음 레벨
    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    // 동일한 아이디에 이전 레벨로 변경
    public TraceId createPreviousId() {
        return new TraceId(id, level - 1);
    }

    // 첫 번째 레벨 여부 확인
    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}
