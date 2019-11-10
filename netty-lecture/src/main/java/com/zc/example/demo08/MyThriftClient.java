package com.zc.example.demo08;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-21 07:00
 */
public class MyThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8888, 6000));
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.isMarried);

            Person savePerson = new Person();
            savePerson.setName("李四");
            savePerson.setAge(10);
            savePerson.setIsMarried(false);

            client.savePerson(savePerson);

        } catch (DataException | TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
