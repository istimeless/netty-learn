package com.istimeless.nettylearn.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @author istimeless
 */
public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8899)).sync().channel();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            for (;;) {
                channel.writeAndFlush(reader.readLine() + "\r\n");
            }
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
