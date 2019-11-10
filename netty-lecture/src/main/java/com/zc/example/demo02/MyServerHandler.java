package com.zc.example.demo02;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author by zc21
 * @Description 服务端和客户端的对话
 * @Date 2019-10-14 21:05
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("remote address = [" + ctx.channel().remoteAddress() + "], message = [" + msg + "]");
        Thread.sleep(1000);
        ctx.writeAndFlush("from server : " + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.fillInStackTrace();
        ctx.close();
    }
}
