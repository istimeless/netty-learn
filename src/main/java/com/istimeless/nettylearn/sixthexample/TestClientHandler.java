package com.istimeless.nettylearn.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(2);
        if (0 == randomInt){
            DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("北京").build();
            DataInfo.MyMessage myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.StudentType).setStudent(student).build();
            ctx.writeAndFlush(myMessage);
        } else {
            DataInfo.Person person = DataInfo.Person.newBuilder().setName("李四").setAge(19).setAddress("南京").build();
            DataInfo.MyMessage myMessage = DataInfo.MyMessage.newBuilder()
                    .setDataType(DataInfo.MyMessage.DataType.PersonType).setPerson(person).build();
            ctx.writeAndFlush(myMessage);
        }

    }
}
