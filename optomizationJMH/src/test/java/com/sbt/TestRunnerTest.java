package com.sbt;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class TestRunnerTest {
    User userObject;
    Gson gson;
    String userSerializationExampleJSON;
    String userSerializationExampleXML;
    XStream xstream;

    @Setup
    public void setupJsonXML() {
        userObject = new User(
                "Norman",
                "norman@futurestud.io",
                26,
                true
        );
        xstream = new XStream();
        gson = new Gson();

        userSerializationExampleJSON = gson.toJson(userObject);
        userSerializationExampleXML = xstream.toXML(userObject);
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Warmup(iterations = 10)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testJsonSerialize(Blackhole blackhole) {
        blackhole.consume(
                gson.toJson(userObject));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Warmup(iterations = 10)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testJsonDeserialize(Blackhole blackhole) {
        blackhole.consume(
                gson.fromJson(userSerializationExampleJSON, User.class));
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Warmup(iterations = 10)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testXMLSerializeXstream(Blackhole blackhole) {
        blackhole.consume(xstream.toXML(userObject)
        );
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Warmup(iterations = 10)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void testXMLDeserializeXstream(Blackhole blackhole) {
        blackhole.consume(xstream.fromXML(userSerializationExampleXML));
    }
}