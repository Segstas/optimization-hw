package com.sbt;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import lombok.val;
import pbdirect.*;
public class TestRunner {
    public static void main(String[] args) {
        User userObject = new User(
                "Norman",
                "norman@futurestud.io",
                26,
                true
        );

        XStream xstream = new XStream();
        String xml = xstream.toXML(userObject);

        User newUserXstream = (User)xstream.fromXML(xml);
    }
}