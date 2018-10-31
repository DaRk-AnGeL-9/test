package com.test.redis;

import java.util.concurrent.ExecutionException;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

public class LettuceTest {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		RedisClient redis = RedisClient.create("redis://localhost:6379/");
		
		StatefulRedisConnection<String, String> connection = redis.connect();
		
		RedisAsyncCommands<String, String> command = connection.async();
		
		RedisFuture<String> value = command.get("angel");
		
		System.out.println("value: " + value.get());
	}
}