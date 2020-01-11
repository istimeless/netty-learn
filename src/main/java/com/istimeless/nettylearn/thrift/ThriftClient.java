package com.istimeless.nettylearn.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

    public static void main(String[] args) {
        TTransport transport = new TFastFramedTransport(new TSocket("127.0.0.1", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("ABC");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());

            Person save = new Person();
            save.setUsername("DEF");
            save.setAge(19);
            client.savePerson(save);

        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
