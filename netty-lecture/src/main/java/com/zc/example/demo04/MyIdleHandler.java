package com.zc.example.demo04;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.internal.StringUtil;

import java.time.LocalTime;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-16 10:06
 */
public class MyIdleHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            IdleState state = event.state();
            String idleType = StringUtil.EMPTY_STRING;
            switch (state) {
                case READER_IDLE:
                    idleType = "读空闲";
                    break;
                case WRITER_IDLE:
                    idleType = "写空闲";
                    break;
                case ALL_IDLE:
                    idleType = "读写空闲";
                    break;
            }
            System.out.println(LocalTime.now() + "→" + ctx.channel().remoteAddress() + "~~~~" + idleType);
        }
    }
}
