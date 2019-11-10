package com.zc.example.demo08;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @author by zc21
 * @Description TODO
 * @Date 2019-10-21 07:00
 */
public class MyThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8888);
        THsHaServer.Args arg = new THsHaServer.Args(socket).workerThreads(4);
        PersonService.Processor processor = new PersonService.Processor(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(arg);
        System.out.println("thrift server started!");
        server.serve(); //死循环
    }
}
