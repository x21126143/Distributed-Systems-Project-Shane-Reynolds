package ds.examples.maths;

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
    comments = "Source: service1Timetable.proto")
public final class MathServiceGrpc {

  private MathServiceGrpc() {}

  public static final String SERVICE_NAME = "maths.MathService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.examples.maths.Stations,
      ds.examples.maths.TrainDetails> getViewTimetableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewTimetable",
      requestType = ds.examples.maths.Stations.class,
      responseType = ds.examples.maths.TrainDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.examples.maths.Stations,
      ds.examples.maths.TrainDetails> getViewTimetableMethod() {
    io.grpc.MethodDescriptor<ds.examples.maths.Stations, ds.examples.maths.TrainDetails> getViewTimetableMethod;
    if ((getViewTimetableMethod = MathServiceGrpc.getViewTimetableMethod) == null) {
      synchronized (MathServiceGrpc.class) {
        if ((getViewTimetableMethod = MathServiceGrpc.getViewTimetableMethod) == null) {
          MathServiceGrpc.getViewTimetableMethod = getViewTimetableMethod = 
              io.grpc.MethodDescriptor.<ds.examples.maths.Stations, ds.examples.maths.TrainDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "maths.MathService", "viewTimetable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.Stations.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.TrainDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new MathServiceMethodDescriptorSupplier("viewTimetable"))
                  .build();
          }
        }
     }
     return getViewTimetableMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MathServiceStub newStub(io.grpc.Channel channel) {
    return new MathServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MathServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MathServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MathServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MathServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class MathServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void viewTimetable(ds.examples.maths.Stations request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getViewTimetableMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViewTimetableMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.examples.maths.Stations,
                ds.examples.maths.TrainDetails>(
                  this, METHODID_VIEW_TIMETABLE)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MathServiceStub extends io.grpc.stub.AbstractStub<MathServiceStub> {
    private MathServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceStub(channel, callOptions);
    }

    /**
     */
    public void viewTimetable(ds.examples.maths.Stations request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getViewTimetableMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MathServiceBlockingStub extends io.grpc.stub.AbstractStub<MathServiceBlockingStub> {
    private MathServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.examples.maths.TrainDetails viewTimetable(ds.examples.maths.Stations request) {
      return blockingUnaryCall(
          getChannel(), getViewTimetableMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class MathServiceFutureStub extends io.grpc.stub.AbstractStub<MathServiceFutureStub> {
    private MathServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MathServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MathServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MathServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.examples.maths.TrainDetails> viewTimetable(
        ds.examples.maths.Stations request) {
      return futureUnaryCall(
          getChannel().newCall(getViewTimetableMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VIEW_TIMETABLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MathServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MathServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VIEW_TIMETABLE:
          serviceImpl.viewTimetable((ds.examples.maths.Stations) request,
              (io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails>) responseObserver);
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

  private static abstract class MathServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MathServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.examples.maths.MathServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MathService");
    }
  }

  private static final class MathServiceFileDescriptorSupplier
      extends MathServiceBaseDescriptorSupplier {
    MathServiceFileDescriptorSupplier() {}
  }

  private static final class MathServiceMethodDescriptorSupplier
      extends MathServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MathServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MathServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MathServiceFileDescriptorSupplier())
              .addMethod(getViewTimetableMethod())
              .build();
        }
      }
    }
    return result;
  }
}
