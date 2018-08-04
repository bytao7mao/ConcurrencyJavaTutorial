package FalseSharing;

/**
 * Created by taoLen on 8/4/2018.
 */
public class FalseSharing {
    public static int NUM_THREADS_MAX = 4;
    public final static long ITERATIONS = 50_000_000L;
    private static VolatileLongPaded[] paddedLongs;
    private static VolatileLongUnPaded[] unpaddedLongs;
    public final static class VolatileLongPaded{
        public long q1,q2,q3,q4,q5,q6;
        public volatile long value = 0L;
        public long q11,q12,q13,q14,q15,q16;
    }
    public final static class VolatileLongUnPaded{
        public volatile long value = 0L;
    }
    static {

    }
}
