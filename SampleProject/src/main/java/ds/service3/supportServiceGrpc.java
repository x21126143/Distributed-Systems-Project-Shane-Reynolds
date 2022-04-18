package ds.service3;

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
    comments = "Source: supportService.proto")
public final class supportServiceGrpc {

  private supportServiceGrpc() {}

  public static final String SERVICE_NAME = "service3.supportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.RequestMessage,
      ds.service3.ResponseMessage> getService3DoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "service3_do",
      requestType = ds.service3.RequestMessage.class,
      responseType = ds.service3.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service3.RequestMessage,
      ds.service3.ResponseMessage> getService3DoMethod() {
    io.grpc.MethodDescriptor<ds.service3.RequestMessage, ds.service3.ResponseMessage> getService3DoMethod;
    if ((getService3DoMethod = supportServiceGrpc.getService3DoMethod) == null) {
      synchronized (supportServiceGrpc.class) {
        if ((getService3DoMethod = supportServiceGrpc.getService3DoMethod) == null) {
          supportServiceGrpc.getService3DoMethod = getService3DoMethod = 
              io.grpc.MethodDescriptor.<ds.service3.RequestMessage, ds.service3.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.supportService", "service3_do"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new supportServiceMethodDescriptorSupplier("service3_do"))
                  .build();
          }
        }
     }
     return getService3DoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static supportServiceStub newStub(io.grpc.Channel channel) {
    return new supportServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static supportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new supportServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static supportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new supportServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class supportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void service3Do(ds.service3.RequestMessage request,
        io.grpc.stub.StreamObserver<ds.service3.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getService3DoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getService3DoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service3.RequestMessage,
                ds.service3.ResponseMessage>(
                  this, METHODID_SERVICE3_DO)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class supportServiceStub extends io.grpc.stub.AbstractStub<supportServiceStub> {
    private supportServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private supportServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected supportServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new supportServiceStub(channel, callOptions);
    }

    /**
     */
    public void service3Do(ds.service3.RequestMessage request,
        io.grpc.stub.StreamObserver<ds.service3.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getService3DoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class supportServiceBlockingStub extends io.grpc.stub.AbstractStub<supportServiceBlockingStub> {
    private supportServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private supportServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected supportServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new supportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.service3.ResponseMessage service3Do(ds.service3.RequestMessage request) {
      return blockingUnaryCall(
          getChannel(), getService3DoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class supportServiceFutureStub extends io.grpc.stub.AbstractStub<supportServiceFutureStub> {
    private supportServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private supportServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected supportServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new supportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service3.ResponseMessage> service3Do(
        ds.service3.RequestMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getService3DoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SERVICE3_DO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final supportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(supportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SERVICE3_DO:
          serviceImpl.service3Do((ds.service3.RequestMessage) request,
              (io.grpc.stub.StreamObserver<ds.service3.ResponseMessage>) responseObserver);
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

  private static abstract class supportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    supportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("supportService");
    }
  }

  private static final class supportServiceFileDescriptorSupplier
      extends supportServiceBaseDescriptorSupplier {
    supportServiceFileDescriptorSupplier() {}
  }

  private static final class supportServiceMethodDescriptorSupplier
      extends supportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    supportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (supportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new supportServiceFileDescriptorSupplier())
              .addMethod(getService3DoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
