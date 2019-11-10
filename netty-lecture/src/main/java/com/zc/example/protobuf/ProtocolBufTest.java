package com.zc.example.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author by zc21
 * @Description protoc --java_out=src/main/java  src/main/java/com/zc/example/protobuf/Student.proto
 * @Date 2019-10-18 14:17
 */
public class ProtocolBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("Sumi").setAge(2).setAddress("北京市昌平区").build();


        byte[] byteArray = student.toByteArray();

        DataInfo.Student studentNew = DataInfo.Student.parseFrom(byteArray);
        System.out.println(studentNew);

    }
}
