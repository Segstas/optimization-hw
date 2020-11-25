package com.sbt;

import com.google.gson.Gson;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class TestRunnerTest {
    User userObject;
    Gson gson;
    String userSerializationExample;

    @Setup
    public void setupJson() {
        userObject = new User(
                "Norman",
                "norman@futurestud.io",
                26,
                true
        );
        gson = new Gson();
        userSerializationExample = gson.toJson(userObject);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testJsonSerialize(Blackhole blackhole) {
        blackhole.consume(
                gson.toJson(userObject));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testJsonDeserialize(Blackhole blackhole) {
        blackhole.consume(
                gson.fromJson(userSerializationExample, User.class));
    }

}