package com.mservice.gen.BobToAlice;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: fromBobtoAlice.proto")
public final class sendMessageToBobGrpc {

  private sendMessageToBobGrpc() {}

  public static final String SERVICE_NAME = "com.mservice.gen.BobToAlice.sendMessageToBob";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.mservice.gen.BobToAlice.Ping,
      com.mservice.gen.BobToAlice.Pong> METHOD_SEND_TO_ALICE =
      io.grpc.MethodDescriptor.<com.mservice.gen.BobToAlice.Ping, com.mservice.gen.BobToAlice.Pong>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.mservice.gen.BobToAlice.sendMessageToBob", "sendToAlice"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.mservice.gen.BobToAlice.Ping.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.mservice.gen.BobToAlice.Pong.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.mservice.gen.BobToAlice.Ping,
      com.mservice.gen.BobToAlice.Pong> METHOD_SEND_TO_BOB =
      io.grpc.MethodDescriptor.<com.mservice.gen.BobToAlice.Ping, com.mservice.gen.BobToAlice.Pong>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "com.mservice.gen.BobToAlice.sendMessageToBob", "sendToBob"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.mservice.gen.BobToAlice.Ping.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.mservice.gen.BobToAlice.Pong.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static sendMessageToBobStub newStub(io.grpc.Channel channel) {
    return new sendMessageToBobStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static sendMessageToBobBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new sendMessageToBobBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static sendMessageToBobFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new sendMessageToBobFutureStub(channel);
  }

  /**
   */
  public static abstract class sendMessageToBobImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendToAlice(com.mservice.gen.BobToAlice.Ping request,
        io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEND_TO_ALICE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Ping> sendToBob(
        io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_SEND_TO_BOB, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SEND_TO_ALICE,
            asyncUnaryCall(
              new MethodHandlers<
                com.mservice.gen.BobToAlice.Ping,
                com.mservice.gen.BobToAlice.Pong>(
                  this, METHODID_SEND_TO_ALICE)))
          .addMethod(
            METHOD_SEND_TO_BOB,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.mservice.gen.BobToAlice.Ping,
                com.mservice.gen.BobToAlice.Pong>(
                  this, METHODID_SEND_TO_BOB)))
          .build();
    }
  }

  /**
   */
  public static final class sendMessageToBobStub extends io.grpc.stub.AbstractStub<sendMessageToBobStub> {
    private sendMessageToBobStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendMessageToBobStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendMessageToBobStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendMessageToBobStub(channel, callOptions);
    }

    /**
     */
    public void sendToAlice(com.mservice.gen.BobToAlice.Ping request,
        io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_ALICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Ping> sendToBob(
        io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_SEND_TO_BOB, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class sendMessageToBobBlockingStub extends io.grpc.stub.AbstractStub<sendMessageToBobBlockingStub> {
    private sendMessageToBobBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendMessageToBobBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendMessageToBobBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendMessageToBobBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mservice.gen.BobToAlice.Pong sendToAlice(com.mservice.gen.BobToAlice.Ping request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SEND_TO_ALICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class sendMessageToBobFutureStub extends io.grpc.stub.AbstractStub<sendMessageToBobFutureStub> {
    private sendMessageToBobFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sendMessageToBobFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sendMessageToBobFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sendMessageToBobFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mservice.gen.BobToAlice.Pong> sendToAlice(
        com.mservice.gen.BobToAlice.Ping request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SEND_TO_ALICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_TO_ALICE = 0;
  private static final int METHODID_SEND_TO_BOB = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final sendMessageToBobImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(sendMessageToBobImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TO_ALICE:
          serviceImpl.sendToAlice((com.mservice.gen.BobToAlice.Ping) request,
              (io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TO_BOB:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendToBob(
              (io.grpc.stub.StreamObserver<com.mservice.gen.BobToAlice.Pong>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class sendMessageToBobDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mservice.gen.BobToAlice.GrpcServer.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (sendMessageToBobGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new sendMessageToBobDescriptorSupplier())
              .addMethod(METHOD_SEND_TO_ALICE)
              .addMethod(METHOD_SEND_TO_BOB)
              .build();
        }
      }
    }
    return result;
  }
}
