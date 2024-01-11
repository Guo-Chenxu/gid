package com.guochenxu.gid.protobuf.grpc;

import com.guochenxu.gid.protobuf.java.com.guochenxu.gid.protobuf.*;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.0)",
    comments = "Source: gid.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RPCDateServiceGrpc {

  private RPCDateServiceGrpc() {}

  public static final String SERVICE_NAME = "com.guochenxu.gid.protobuf.RPCDateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<PingReq,
          PingResp> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ping",
      requestType = PingReq.class,
      responseType = PingResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<PingReq,
          PingResp> getPingMethod() {
    io.grpc.MethodDescriptor<PingReq, PingResp> getPingMethod;
    if ((getPingMethod = RPCDateServiceGrpc.getPingMethod) == null) {
      synchronized (RPCDateServiceGrpc.class) {
        if ((getPingMethod = RPCDateServiceGrpc.getPingMethod) == null) {
          RPCDateServiceGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<PingReq, PingResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PingReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  PingResp.getDefaultInstance()))
              .setSchemaDescriptor(new RPCDateServiceMethodDescriptorSupplier("ping"))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CreateTagReq,
          CreateTagResp> getCreateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createTag",
      requestType = CreateTagReq.class,
      responseType = CreateTagResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateTagReq,
          CreateTagResp> getCreateTagMethod() {
    io.grpc.MethodDescriptor<CreateTagReq, CreateTagResp> getCreateTagMethod;
    if ((getCreateTagMethod = RPCDateServiceGrpc.getCreateTagMethod) == null) {
      synchronized (RPCDateServiceGrpc.class) {
        if ((getCreateTagMethod = RPCDateServiceGrpc.getCreateTagMethod) == null) {
          RPCDateServiceGrpc.getCreateTagMethod = getCreateTagMethod =
              io.grpc.MethodDescriptor.<CreateTagReq, CreateTagResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateTagReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateTagResp.getDefaultInstance()))
              .setSchemaDescriptor(new RPCDateServiceMethodDescriptorSupplier("createTag"))
              .build();
        }
      }
    }
    return getCreateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetIdReq,
          GetIdResp> getGetIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getId",
      requestType = GetIdReq.class,
      responseType = GetIdResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetIdReq,
          GetIdResp> getGetIdMethod() {
    io.grpc.MethodDescriptor<GetIdReq, GetIdResp> getGetIdMethod;
    if ((getGetIdMethod = RPCDateServiceGrpc.getGetIdMethod) == null) {
      synchronized (RPCDateServiceGrpc.class) {
        if ((getGetIdMethod = RPCDateServiceGrpc.getGetIdMethod) == null) {
          RPCDateServiceGrpc.getGetIdMethod = getGetIdMethod =
              io.grpc.MethodDescriptor.<GetIdReq, GetIdResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetIdResp.getDefaultInstance()))
              .setSchemaDescriptor(new RPCDateServiceMethodDescriptorSupplier("getId"))
              .build();
        }
      }
    }
    return getGetIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetSnowId,
          GetSnowIdResp> getGetSnowIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSnowId",
      requestType = GetSnowId.class,
      responseType = GetSnowIdResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetSnowId,
          GetSnowIdResp> getGetSnowIdMethod() {
    io.grpc.MethodDescriptor<GetSnowId, GetSnowIdResp> getGetSnowIdMethod;
    if ((getGetSnowIdMethod = RPCDateServiceGrpc.getGetSnowIdMethod) == null) {
      synchronized (RPCDateServiceGrpc.class) {
        if ((getGetSnowIdMethod = RPCDateServiceGrpc.getGetSnowIdMethod) == null) {
          RPCDateServiceGrpc.getGetSnowIdMethod = getGetSnowIdMethod =
              io.grpc.MethodDescriptor.<GetSnowId, GetSnowIdResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSnowId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSnowId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSnowIdResp.getDefaultInstance()))
              .setSchemaDescriptor(new RPCDateServiceMethodDescriptorSupplier("getSnowId"))
              .build();
        }
      }
    }
    return getGetSnowIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RPCDateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceStub>() {
        @Override
        public RPCDateServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceStub(channel, callOptions);
        }
      };
    return RPCDateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RPCDateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceBlockingStub>() {
        @Override
        public RPCDateServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceBlockingStub(channel, callOptions);
        }
      };
    return RPCDateServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RPCDateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RPCDateServiceFutureStub>() {
        @Override
        public RPCDateServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RPCDateServiceFutureStub(channel, callOptions);
        }
      };
    return RPCDateServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RPCDateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ping(PingReq request,
                     io.grpc.stub.StreamObserver<PingResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }

    /**
     */
    public void createTag(CreateTagReq request,
                          io.grpc.stub.StreamObserver<CreateTagResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagMethod(), responseObserver);
    }

    /**
     */
    public void getId(GetIdReq request,
                      io.grpc.stub.StreamObserver<GetIdResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIdMethod(), responseObserver);
    }

    /**
     */
    public void getSnowId(GetSnowId request,
                          io.grpc.stub.StreamObserver<GetSnowIdResp> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSnowIdMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      PingReq,
                      PingResp>(
                  this, METHODID_PING)))
          .addMethod(
            getCreateTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      CreateTagReq,
                      CreateTagResp>(
                  this, METHODID_CREATE_TAG)))
          .addMethod(
            getGetIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      GetIdReq,
                      GetIdResp>(
                  this, METHODID_GET_ID)))
          .addMethod(
            getGetSnowIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      GetSnowId,
                      GetSnowIdResp>(
                  this, METHODID_GET_SNOW_ID)))
          .build();
    }
  }

  /**
   */
  public static final class RPCDateServiceStub extends io.grpc.stub.AbstractAsyncStub<RPCDateServiceStub> {
    private RPCDateServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RPCDateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceStub(channel, callOptions);
    }

    /**
     */
    public void ping(PingReq request,
                     io.grpc.stub.StreamObserver<PingResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createTag(CreateTagReq request,
                          io.grpc.stub.StreamObserver<CreateTagResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getId(GetIdReq request,
                      io.grpc.stub.StreamObserver<GetIdResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSnowId(GetSnowId request,
                          io.grpc.stub.StreamObserver<GetSnowIdResp> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnowIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RPCDateServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RPCDateServiceBlockingStub> {
    private RPCDateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RPCDateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public PingResp ping(PingReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }

    /**
     */
    public CreateTagResp createTag(CreateTagReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetIdResp getId(GetIdReq request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetSnowIdResp getSnowId(GetSnowId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnowIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RPCDateServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RPCDateServiceFutureStub> {
    private RPCDateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected RPCDateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RPCDateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<PingResp> ping(
        PingReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CreateTagResp> createTag(
        CreateTagReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetIdResp> getId(
        GetIdReq request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetSnowIdResp> getSnowId(
        GetSnowId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnowIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_CREATE_TAG = 1;
  private static final int METHODID_GET_ID = 2;
  private static final int METHODID_GET_SNOW_ID = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RPCDateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RPCDateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((PingReq) request,
              (io.grpc.stub.StreamObserver<PingResp>) responseObserver);
          break;
        case METHODID_CREATE_TAG:
          serviceImpl.createTag((CreateTagReq) request,
              (io.grpc.stub.StreamObserver<CreateTagResp>) responseObserver);
          break;
        case METHODID_GET_ID:
          serviceImpl.getId((GetIdReq) request,
              (io.grpc.stub.StreamObserver<GetIdResp>) responseObserver);
          break;
        case METHODID_GET_SNOW_ID:
          serviceImpl.getSnowId((GetSnowId) request,
              (io.grpc.stub.StreamObserver<GetSnowIdResp>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RPCDateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RPCDateServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return GIDServiceApi.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RPCDateService");
    }
  }

  private static final class RPCDateServiceFileDescriptorSupplier
      extends RPCDateServiceBaseDescriptorSupplier {
    RPCDateServiceFileDescriptorSupplier() {}
  }

  private static final class RPCDateServiceMethodDescriptorSupplier
      extends RPCDateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RPCDateServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RPCDateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RPCDateServiceFileDescriptorSupplier())
              .addMethod(getPingMethod())
              .addMethod(getCreateTagMethod())
              .addMethod(getGetIdMethod())
              .addMethod(getGetSnowIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
