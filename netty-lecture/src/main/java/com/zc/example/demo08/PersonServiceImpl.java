package com.zc.example.demo08;

import org.apache.thrift.TException;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-21 07:06
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println(username);
        Person person = new Person();
        person.setName(username);
        person.setAge(88);
        person.setIsMarried(true);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried);
    }
}
