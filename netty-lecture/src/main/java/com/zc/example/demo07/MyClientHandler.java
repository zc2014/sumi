package com.zc.example.demo07;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-18 17:40
 */
public class MyClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Data> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Data msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Data data = null;
        int type = new Random().nextInt(3);
        if (type == 1) {
            data = MyDataInfo.Data.newBuilder().setDataType(MyDataInfo.Data.DataType.PersonType)
                    .setPerson(MyDataInfo.Data.Person.newBuilder()
                            .setName("Sumi").setAge(2).setAddress("北京市昌平区").build()).build();
        } else if (type == 2) {
            data = MyDataInfo.Data.newBuilder().setDataType(MyDataInfo.Data.DataType.RhinoType)
                    .setRhino(MyDataInfo.Data.Rhino.newBuilder()
                            .setName("小犀牛").setAge(5).build()).build();
        } else {
            data = MyDataInfo.Data.newBuilder().setDataType(MyDataInfo.Data.DataType.ZebraType)
                    .setZebra(MyDataInfo.Data.Zebra.newBuilder()
                            .setName("小斑马").setColor("黑白").build()).build();
        }
        ctx.channel().writeAndFlush(data);
    }

}
