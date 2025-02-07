package com.horadrim.staff.ltcd.dp;

import java.util.concurrent.atomic.AtomicInteger;

public class ClimbingStairs {
    private final int ONE_STEP_CLIMB = 1;
    private final int TWO_STEPS_CLIMB = 2;

    public int solution(int k) {
        AtomicInteger methods = new AtomicInteger(0);
        if (k <= 0) {
            return 0;
        }

        dp(k, methods);
        return methods.get();
    }

    public int solution2(int k) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= k; ++i) {
            p = q; 
            q = r; 
            r = p + q;
        }
        return r;
    }

    private void dp(int k, AtomicInteger methods) {
        if (k - ONE_STEP_CLIMB == 0) {
            methods.incrementAndGet();
            return;
        }

        dp(k - ONE_STEP_CLIMB, methods);

        if (k - TWO_STEPS_CLIMB == 0) {
            methods.incrementAndGet();;
            return;
        }

        dp(k - TWO_STEPS_CLIMB, methods);
    }
}
