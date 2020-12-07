package com.mservice.verticle;

import com.mservice.gen.BobToAlice.sendMessageToBobGrpc;
import com.mservice.gen.BobToAlice.Ping;
import com.mservice.gen.BobToAlice.Pong;
import com.mservice.services.BobToAlice;
import com.mservice.services.MyInterceptor;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.stub.StreamObserver;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.grpc.BlockingServerInterceptor;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class AliceVerticle extends AbstractVerticle {
    public BobToAlice service;
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        MyInterceptor myInterceptor = new MyInterceptor();
        ServerInterceptor wrapped = BlockingServerInterceptor.wrap(vertx, myInterceptor);
        service = new BobToAlice();
        VertxServer vertxServer = VertxServerBuilder
                .forAddress(vertx, "0.0.0.0", 50054)
                .addService(ServerInterceptors.intercept(new sendMessageToBobGrpc.sendMessageToBobImplBase() {
                    @Override
                    public void sendToAlice(Ping request, StreamObserver<Pong> responseObserver) {
                        service.sendToAlice(request, responseObserver);
                    }

                    @Override
                    public StreamObserver<Ping> sendToBob(StreamObserver<Pong> responseObserver) {
                        return service.sendToBob(responseObserver);
                    }
                }, wrapped)).build();
        // Start it
        vertxServer.start(handler -> {
            if(handler.succeeded()) {
                log.info("GRPC is initial successed");
                return;
            }
            log.error("GRPC can not initial successed: "+handler.cause().getCause());
        });
    }

    @Override
    public void stop(Promise<Void> stopPromise) throws Exception {

    }
}
