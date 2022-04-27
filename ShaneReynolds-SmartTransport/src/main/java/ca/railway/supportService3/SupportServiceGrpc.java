package ca.railway.supportService3;

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
    comments = "Source: service3Support.proto")
public final class SupportServiceGrpc {

  private SupportServiceGrpc() {}

  public static final String SERVICE_NAME = "supportService3.SupportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ca.railway.supportService3.complaintMsg,
      ca.railway.supportService3.complaintConfirmation> getComplaintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "complaint",
      requestType = ca.railway.supportService3.complaintMsg.class,
      responseType = ca.railway.supportService3.complaintConfirmation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ca.railway.supportService3.complaintMsg,
      ca.railway.supportService3.complaintConfirmation> getComplaintMethod() {
    io.grpc.MethodDescriptor<ca.railway.supportService3.complaintMsg, ca.railway.supportService3.complaintConfirmation> getComplaintMethod;
    if ((getComplaintMethod = SupportServiceGrpc.getComplaintMethod) == null) {
      synchronized (SupportServiceGrpc.class) {
        if ((getComplaintMethod = SupportServiceGrpc.getComplaintMethod) == null) {
          SupportServiceGrpc.getComplaintMethod = getComplaintMethod = 
              io.grpc.MethodDescriptor.<ca.railway.supportService3.complaintMsg, ca.railway.supportService3.complaintConfirmation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "supportService3.SupportService", "complaint"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.supportService3.complaintMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.supportService3.complaintConfirmation.getDefaultInstance()))
                  .setSchemaDescriptor(new SupportServiceMethodDescriptorSupplier("complaint"))
                  .build();
          }
        }
     }
     return getComplaintMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ca.railway.supportService3.emergencyReportBool,
      ca.railway.supportService3.emergencyResponse> getEmergencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "emergency",
      requestType = ca.railway.supportService3.emergencyReportBool.class,
      responseType = ca.railway.supportService3.emergencyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ca.railway.supportService3.emergencyReportBool,
      ca.railway.supportService3.emergencyResponse> getEmergencyMethod() {
    io.grpc.MethodDescriptor<ca.railway.supportService3.emergencyReportBool, ca.railway.supportService3.emergencyResponse> getEmergencyMethod;
    if ((getEmergencyMethod = SupportServiceGrpc.getEmergencyMethod) == null) {
      synchronized (SupportServiceGrpc.class) {
        if ((getEmergencyMethod = SupportServiceGrpc.getEmergencyMethod) == null) {
          SupportServiceGrpc.getEmergencyMethod = getEmergencyMethod = 
              io.grpc.MethodDescriptor.<ca.railway.supportService3.emergencyReportBool, ca.railway.supportService3.emergencyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "supportService3.SupportService", "emergency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.supportService3.emergencyReportBool.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.supportService3.emergencyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SupportServiceMethodDescriptorSupplier("emergency"))
                  .build();
          }
        }
     }
     return getEmergencyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SupportServiceStub newStub(io.grpc.Channel channel) {
    return new SupportServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SupportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SupportServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SupportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SupportServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SupportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void complaint(ca.railway.supportService3.complaintMsg request,
        io.grpc.stub.StreamObserver<ca.railway.supportService3.complaintConfirmation> responseObserver) {
      asyncUnimplementedUnaryCall(getComplaintMethod(), responseObserver);
    }

    /**
     */
    public void emergency(ca.railway.supportService3.emergencyReportBool request,
        io.grpc.stub.StreamObserver<ca.railway.supportService3.emergencyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEmergencyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComplaintMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.railway.supportService3.complaintMsg,
                ca.railway.supportService3.complaintConfirmation>(
                  this, METHODID_COMPLAINT)))
          .addMethod(
            getEmergencyMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ca.railway.supportService3.emergencyReportBool,
                ca.railway.supportService3.emergencyResponse>(
                  this, METHODID_EMERGENCY)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SupportServiceStub extends io.grpc.stub.AbstractStub<SupportServiceStub> {
    private SupportServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceStub(channel, callOptions);
    }

    /**
     */
    public void complaint(ca.railway.supportService3.complaintMsg request,
        io.grpc.stub.StreamObserver<ca.railway.supportService3.complaintConfirmation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getComplaintMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void emergency(ca.railway.supportService3.emergencyReportBool request,
        io.grpc.stub.StreamObserver<ca.railway.supportService3.emergencyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getEmergencyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SupportServiceBlockingStub extends io.grpc.stub.AbstractStub<SupportServiceBlockingStub> {
    private SupportServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ca.railway.supportService3.complaintConfirmation complaint(ca.railway.supportService3.complaintMsg request) {
      return blockingUnaryCall(
          getChannel(), getComplaintMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ca.railway.supportService3.emergencyResponse> emergency(
        ca.railway.supportService3.emergencyReportBool request) {
      return blockingServerStreamingCall(
          getChannel(), getEmergencyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SupportServiceFutureStub extends io.grpc.stub.AbstractStub<SupportServiceFutureStub> {
    private SupportServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SupportServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SupportServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SupportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.railway.supportService3.complaintConfirmation> complaint(
        ca.railway.supportService3.complaintMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getComplaintMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPLAINT = 0;
  private static final int METHODID_EMERGENCY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SupportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SupportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPLAINT:
          serviceImpl.complaint((ca.railway.supportService3.complaintMsg) request,
              (io.grpc.stub.StreamObserver<ca.railway.supportService3.complaintConfirmation>) responseObserver);
          break;
        case METHODID_EMERGENCY:
          serviceImpl.emergency((ca.railway.supportService3.emergencyReportBool) request,
              (io.grpc.stub.StreamObserver<ca.railway.supportService3.emergencyResponse>) responseObserver);
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

  private static abstract class SupportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SupportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ca.railway.supportService3.SupportServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SupportService");
    }
  }

  private static final class SupportServiceFileDescriptorSupplier
      extends SupportServiceBaseDescriptorSupplier {
    SupportServiceFileDescriptorSupplier() {}
  }

  private static final class SupportServiceMethodDescriptorSupplier
      extends SupportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SupportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SupportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SupportServiceFileDescriptorSupplier())
              .addMethod(getComplaintMethod())
              .addMethod(getEmergencyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
