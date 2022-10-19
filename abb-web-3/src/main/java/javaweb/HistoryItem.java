package javaweb;

import java.time.LocalDateTime;

public class HistoryItem {
    public final int x;
    public final int y;
    public final int z;
    public final LocalDateTime ldt;

    public HistoryItem(int x, int y, int z, LocalDateTime ldt) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ldt = ldt;
    }

    public HistoryItem(int x, int y, int z) {
        this(x, y, z, LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("%s: %d + %d = %d", ldt.toString(), x, y, z);
    }


}
