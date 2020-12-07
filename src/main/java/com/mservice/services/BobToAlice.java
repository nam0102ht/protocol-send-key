package com.mservice.services;

import com.mservice.gen.BobToAlice.Ping;
import com.mservice.gen.BobToAlice.Pong;
import com.mservice.gen.BobToAlice.sendMessageToBobGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BobToAlice extends sendMessageToBobGrpc.sendMessageToBobImplBase{
    @Override
    public void sendToAlice(Ping request, StreamObserver<Pong> responseObserver) {
        log.info(request.getMessage());
    }

    @Override
    public StreamObserver<Ping> sendToBob(StreamObserver<Pong> responseObserver) {
        return super.sendToBob(responseObserver);
    }
}
