package ca.railway.timetableService1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service2Booking.proto")
public final class RailwayService2Grpc {

  private RailwayService2Grpc() {}

  public static final String SERVICE_NAME = "timetableService1.RailwayService2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ca.railway.timetableService1.LoginRequest,
      ca.railway.timetableService1.LoginReply> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = ca.railway.timetableService1.LoginRequest.class,
      responseType = ca.railway.timetableService1.LoginReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ca.railway.timetableService1.LoginRequest,
      ca.railway.timetableService1.LoginReply> getLoginMethod() {
    io.grpc.MethodDescriptor<ca.railway.timetableService1.LoginRequest, ca.railway.timetableService1.LoginReply> getLoginMethod;
    if ((getLoginMethod = RailwayService2Grpc.getLoginMethod) == null) {
      synchronized (RailwayService2Grpc.class) {
        if ((getLoginMethod = RailwayService2Grpc.getLoginMethod) == null) {
          RailwayService2Grpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<ca.railway.timetableService1.LoginRequest, ca.railway.timetableService1.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "timetableService1.RailwayService2", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.timetableService1.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.timetableService1.LoginReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RailwayService2MethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RailwayService2Stub newStub(io.grpc.Channel channel) {
    return new RailwayService2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RailwayService2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RailwayService2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RailwayService2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RailwayService2FutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RailwayService2ImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(ca.railway.timetableService1.LoginRequest request,
        io.grpc.stub.StreamObserver<ca.railway.timetableService1.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.railway.timetableService1.LoginRequest,
                ca.railway.timetableService1.LoginReply>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayService2Stub extends io.grpc.stub.AbstractStub<RailwayService2Stub> {
    private RailwayService2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayService2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayService2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayService2Stub(channel, callOptions);
    }

    /**
     */
    public void login(ca.railway.timetableService1.LoginRequest request,
        io.grpc.stub.StreamObserver<ca.railway.timetableService1.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayService2BlockingStub extends io.grpc.stub.AbstractStub<RailwayService2BlockingStub> {
    private RailwayService2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayService2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayService2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayService2BlockingStub(channel, callOptions);
    }

    /**
     */
    public ca.railway.timetableService1.LoginReply login(ca.railway.timetableService1.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayService2FutureStub extends io.grpc.stub.AbstractStub<RailwayService2FutureStub> {
    private RailwayService2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayService2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayService2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayService2FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.railway.timetableService1.LoginReply> login(
        ca.railway.timetableService1.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RailwayService2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RailwayService2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((ca.railway.timetableService1.LoginRequest) request,
              (io.grpc.stub.StreamObserver<ca.railway.timetableService1.LoginReply>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RailwayService2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RailwayService2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ca.railway.timetableService1.RailwayServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RailwayService2");
    }
  }

  private static final class RailwayService2FileDescriptorSupplier
      extends RailwayService2BaseDescriptorSupplier {
    RailwayService2FileDescriptorSupplier() {}
  }

  private static final class RailwayService2MethodDescriptorSupplier
      extends RailwayService2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RailwayService2MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RailwayService2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RailwayService2FileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
