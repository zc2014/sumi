package com.zc.example.demo06;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-18 15:50
 */
public class MyProtocolClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder()
                .setName("Sumi").setAge(2).setAddress("北京市昌平区").build();
        ctx.writeAndFlush(person);
    }
}
