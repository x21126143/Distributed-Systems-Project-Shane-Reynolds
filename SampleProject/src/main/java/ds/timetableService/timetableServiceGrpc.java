package ds.timetableService;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: timetableService.proto")
public final class timetableServiceGrpc {

  private timetableServiceGrpc() {}

  public static final String SERVICE_NAME = "service1.timetableService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.timetableService.Stations,
      ds.timetableService.TrainDetails> getViewTimetableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ViewTimetable",
      requestType = ds.timetableService.Stations.class,
      responseType = ds.timetableService.TrainDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.timetableService.Stations,
      ds.timetableService.TrainDetails> getViewTimetableMethod() {
    io.grpc.MethodDescriptor<ds.timetableService.Stations, ds.timetableService.TrainDetails> getViewTimetableMethod;
    if ((getViewTimetableMethod = timetableServiceGrpc.getViewTimetableMethod) == null) {
      synchronized (timetableServiceGrpc.class) {
        if ((getViewTimetableMethod = timetableServiceGrpc.getViewTimetableMethod) == null) {
          timetableServiceGrpc.getViewTimetableMethod = getViewTimetableMethod = 
              io.grpc.MethodDescriptor.<ds.timetableService.Stations, ds.timetableService.TrainDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.timetableService", "ViewTimetable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.Stations.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.TrainDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new timetableServiceMethodDescriptorSupplier("ViewTimetable"))
                  .build();
          }
        }
     }
     return getViewTimetableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.timetableService.TrainNo,
      ds.timetableService.DelaysBool> getDelaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delays",
      requestType = ds.timetableService.TrainNo.class,
      responseType = ds.timetableService.DelaysBool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.timetableService.TrainNo,
      ds.timetableService.DelaysBool> getDelaysMethod() {
    io.grpc.MethodDescriptor<ds.timetableService.TrainNo, ds.timetableService.DelaysBool> getDelaysMethod;
    if ((getDelaysMethod = timetableServiceGrpc.getDelaysMethod) == null) {
      synchronized (timetableServiceGrpc.class) {
        if ((getDelaysMethod = timetableServiceGrpc.getDelaysMethod) == null) {
          timetableServiceGrpc.getDelaysMethod = getDelaysMethod = 
              io.grpc.MethodDescriptor.<ds.timetableService.TrainNo, ds.timetableService.DelaysBool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.timetableService", "delays"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.TrainNo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.DelaysBool.getDefaultInstance()))
                  .setSchemaDescriptor(new timetableServiceMethodDescriptorSupplier("delays"))
                  .build();
          }
        }
     }
     return getDelaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.timetableService.TrainNo,
      ds.timetableService.TrainAmenities> getAmenitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "amenities",
      requestType = ds.timetableService.TrainNo.class,
      responseType = ds.timetableService.TrainAmenities.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.timetableService.TrainNo,
      ds.timetableService.TrainAmenities> getAmenitiesMethod() {
    io.grpc.MethodDescriptor<ds.timetableService.TrainNo, ds.timetableService.TrainAmenities> getAmenitiesMethod;
    if ((getAmenitiesMethod = timetableServiceGrpc.getAmenitiesMethod) == null) {
      synchronized (timetableServiceGrpc.class) {
        if ((getAmenitiesMethod = timetableServiceGrpc.getAmenitiesMethod) == null) {
          timetableServiceGrpc.getAmenitiesMethod = getAmenitiesMethod = 
              io.grpc.MethodDescriptor.<ds.timetableService.TrainNo, ds.timetableService.TrainAmenities>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.timetableService", "amenities"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.TrainNo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.timetableService.TrainAmenities.getDefaultInstance()))
                  .setSchemaDescriptor(new timetableServiceMethodDescriptorSupplier("amenities"))
                  .build();
          }
        }
     }
     return getAmenitiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static timetableServiceStub newStub(io.grpc.Channel channel) {
    return new timetableServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static timetableServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new timetableServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static timetableServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new timetableServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class timetableServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.timetableService.Stations> viewTimetable(
        io.grpc.stub.StreamObserver<ds.timetableService.TrainDetails> responseObserver) {
      return asyncUnimplementedStreamingCall(getViewTimetableMethod(), responseObserver);
    }

    /**
     */
    public void delays(ds.timetableService.TrainNo request,
        io.grpc.stub.StreamObserver<ds.timetableService.DelaysBool> responseObserver) {
      asyncUnimplementedUnaryCall(getDelaysMethod(), responseObserver);
    }

    /**
     */
    public void amenities(ds.timetableService.TrainNo request,
        io.grpc.stub.StreamObserver<ds.timetableService.TrainAmenities> responseObserver) {
      asyncUnimplementedUnaryCall(getAmenitiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViewTimetableMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.timetableService.Stations,
                ds.timetableService.TrainDetails>(
                  this, METHODID_VIEW_TIMETABLE)))
          .addMethod(
            getDelaysMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.timetableService.TrainNo,
                ds.timetableService.DelaysBool>(
                  this, METHODID_DELAYS)))
          .addMethod(
            getAmenitiesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.timetableService.TrainNo,
                ds.timetableService.TrainAmenities>(
                  this, METHODID_AMENITIES)))
          .build();
    }
  }

  /**
   */
  public static final class timetableServiceStub extends io.grpc.stub.AbstractStub<timetableServiceStub> {
    private timetableServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private timetableServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected timetableServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new timetableServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.timetableService.Stations> viewTimetable(
        io.grpc.stub.StreamObserver<ds.timetableService.TrainDetails> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getViewTimetableMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void delays(ds.timetableService.TrainNo request,
        io.grpc.stub.StreamObserver<ds.timetableService.DelaysBool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDelaysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void amenities(ds.timetableService.TrainNo request,
        io.grpc.stub.StreamObserver<ds.timetableService.TrainAmenities> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAmenitiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class timetableServiceBlockingStub extends io.grpc.stub.AbstractStub<timetableServiceBlockingStub> {
    private timetableServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private timetableServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected timetableServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new timetableServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.timetableService.DelaysBool delays(ds.timetableService.TrainNo request) {
      return blockingUnaryCall(
          getChannel(), getDelaysMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.timetableService.TrainAmenities> amenities(
        ds.timetableService.TrainNo request) {
      return blockingServerStreamingCall(
          getChannel(), getAmenitiesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class timetableServiceFutureStub extends io.grpc.stub.AbstractStub<timetableServiceFutureStub> {
    private timetableServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private timetableServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected timetableServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new timetableServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.timetableService.DelaysBool> delays(
        ds.timetableService.TrainNo request) {
      return futureUnaryCall(
          getChannel().newCall(getDelaysMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELAYS = 0;
  private static final int METHODID_AMENITIES = 1;
  private static final int METHODID_VIEW_TIMETABLE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final timetableServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(timetableServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELAYS:
          serviceImpl.delays((ds.timetableService.TrainNo) request,
              (io.grpc.stub.StreamObserver<ds.timetableService.DelaysBool>) responseObserver);
          break;
        case METHODID_AMENITIES:
          serviceImpl.amenities((ds.timetableService.TrainNo) request,
              (io.grpc.stub.StreamObserver<ds.timetableService.TrainAmenities>) responseObserver);
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
        case METHODID_VIEW_TIMETABLE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.viewTimetable(
              (io.grpc.stub.StreamObserver<ds.timetableService.TrainDetails>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class timetableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    timetableServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.timetableService.TimetableServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("timetableService");
    }
  }

  private static final class timetableServiceFileDescriptorSupplier
      extends timetableServiceBaseDescriptorSupplier {
    timetableServiceFileDescriptorSupplier() {}
  }

  private static final class timetableServiceMethodDescriptorSupplier
      extends timetableServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    timetableServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (timetableServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new timetableServiceFileDescriptorSupplier())
              .addMethod(getViewTimetableMethod())
              .addMethod(getDelaysMethod())
              .addMethod(getAmenitiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
