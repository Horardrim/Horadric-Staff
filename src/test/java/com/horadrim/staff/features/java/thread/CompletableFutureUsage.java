package com.horadrim.staff.features.java.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompletableFutureUsage {
    @Test
    void normalUsage() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> 21)
                         .thenApply(x -> x * 2)
                         .thenCompose(
                            x -> CompletableFuture.supplyAsync(() -> x * 2));

        // thenCompose 接收返回Future类型的Function
        // CompletableFuture<Integer> flat =
        //     CompletableFuture.supplyAsync(() -> 100)
        //         .thenCompose(x -> CompletableFuture.completedFuture(x + 1));
        System.out.println(cf.get());
    }
}