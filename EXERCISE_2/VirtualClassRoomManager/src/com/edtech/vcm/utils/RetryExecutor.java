package com.edtech.vcm.utils;

import com.edtech.vcm.exception.TransientException;

public class RetryExecutor {
    public static <T> T executeWithRetry(Operation<T> operation, int retries) {
        int attempts = 0;
        while (true) {
            try {
                return operation.run();
            } catch (TransientException e) {
                if (++attempts > retries) throw e;
            }
        }
    }

    @FunctionalInterface
    public interface Operation<T> {
        T run();
    }
}
