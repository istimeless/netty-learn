package com.istimeless.nettylearn.thrift;

import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("getPersonByUsername被调用：" + username);
        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
    }
}
