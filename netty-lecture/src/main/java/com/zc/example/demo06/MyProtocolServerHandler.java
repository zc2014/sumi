package com.zc.example.demo06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-18 15:46
 */
public class MyProtocolServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}
