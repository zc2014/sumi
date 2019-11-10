package com.zc.example.demo03;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-15 09:57
 */
public class ChatClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(worker).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new ChatClientHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {
                Channel channel = channelFuture.channel();
                channel.writeAndFlush(br.readLine() + "\r\n");
            }

        } finally {
            worker.shutdownGracefully();
        }
    }
}
