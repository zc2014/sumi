package com.zc.example.demo07;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-18 17:34
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Data msg) throws Exception {
        MyDataInfo.Data.DataType dataType = msg.getDataType();
        switch (dataType.getNumber()) {
            case 1:
                MyDataInfo.Data.Person person = msg.getPerson();
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                break;
            case 2:
                MyDataInfo.Data.Rhino rhino = msg.getRhino();
                System.out.println(rhino.getName());
                System.out.println(rhino.getAge());
                break;
            case 3:
                MyDataInfo.Data.Zebra zebra = msg.getZebra();
                System.out.println(zebra.getName());
                System.out.println(zebra.getColor());
                break;
            default:
                System.out.println("类型有误！");
                break;

        }
    }
}
