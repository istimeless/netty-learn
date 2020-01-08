package com.istimeless.nettylearn.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static com.istimeless.nettylearn.sixthexample.DataInfo.*;

/**
 * @author istimeless
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
        MyMessage.DataType dataType = msg.getDataType();
        if (dataType.equals(MyMessage.DataType.StudentType)) {
            Student student = msg.getStudent();
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getAddress());
        } else {
            Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        }

    }
}
