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
public final class RailwayServiceGrpc {

  private RailwayServiceGrpc() {}

  public static final String SERVICE_NAME = "maths.RailwayService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.examples.maths.RequestPrices,
      ds.examples.maths.Pricing> getViewPricingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewPricing",
      requestType = ds.examples.maths.RequestPrices.class,
      responseType = ds.examples.maths.Pricing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.examples.maths.RequestPrices,
      ds.examples.maths.Pricing> getViewPricingMethod() {
    io.grpc.MethodDescriptor<ds.examples.maths.RequestPrices, ds.examples.maths.Pricing> getViewPricingMethod;
    if ((getViewPricingMethod = RailwayServiceGrpc.getViewPricingMethod) == null) {
      synchronized (RailwayServiceGrpc.class) {
        if ((getViewPricingMethod = RailwayServiceGrpc.getViewPricingMethod) == null) {
          RailwayServiceGrpc.getViewPricingMethod = getViewPricingMethod = 
              io.grpc.MethodDescriptor.<ds.examples.maths.RequestPrices, ds.examples.maths.Pricing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "maths.RailwayService", "viewPricing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.RequestPrices.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.Pricing.getDefaultInstance()))
                  .setSchemaDescriptor(new RailwayServiceMethodDescriptorSupplier("viewPricing"))
                  .build();
          }
        }
     }
     return getViewPricingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.maths.Stations,
      ds.examples.maths.TrainDetails> getViewTimetableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewTimetable",
      requestType = ds.examples.maths.Stations.class,
      responseType = ds.examples.maths.TrainDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.examples.maths.Stations,
      ds.examples.maths.TrainDetails> getViewTimetableMethod() {
    io.grpc.MethodDescriptor<ds.examples.maths.Stations, ds.examples.maths.TrainDetails> getViewTimetableMethod;
    if ((getViewTimetableMethod = RailwayServiceGrpc.getViewTimetableMethod) == null) {
      synchronized (RailwayServiceGrpc.class) {
        if ((getViewTimetableMethod = RailwayServiceGrpc.getViewTimetableMethod) == null) {
          RailwayServiceGrpc.getViewTimetableMethod = getViewTimetableMethod = 
              io.grpc.MethodDescriptor.<ds.examples.maths.Stations, ds.examples.maths.TrainDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "maths.RailwayService", "viewTimetable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.Stations.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.TrainDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new RailwayServiceMethodDescriptorSupplier("viewTimetable"))
                  .build();
          }
        }
     }
     return getViewTimetableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.examples.maths.TrainNo,
      ds.examples.maths.TrainAmenities> getAmenitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "amenities",
      requestType = ds.examples.maths.TrainNo.class,
      responseType = ds.examples.maths.TrainAmenities.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.examples.maths.TrainNo,
      ds.examples.maths.TrainAmenities> getAmenitiesMethod() {
    io.grpc.MethodDescriptor<ds.examples.maths.TrainNo, ds.examples.maths.TrainAmenities> getAmenitiesMethod;
    if ((getAmenitiesMethod = RailwayServiceGrpc.getAmenitiesMethod) == null) {
      synchronized (RailwayServiceGrpc.class) {
        if ((getAmenitiesMethod = RailwayServiceGrpc.getAmenitiesMethod) == null) {
          RailwayServiceGrpc.getAmenitiesMethod = getAmenitiesMethod = 
              io.grpc.MethodDescriptor.<ds.examples.maths.TrainNo, ds.examples.maths.TrainAmenities>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "maths.RailwayService", "amenities"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.TrainNo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.examples.maths.TrainAmenities.getDefaultInstance()))
                  .setSchemaDescriptor(new RailwayServiceMethodDescriptorSupplier("amenities"))
                  .build();
          }
        }
     }
     return getAmenitiesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RailwayServiceStub newStub(io.grpc.Channel channel) {
    return new RailwayServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RailwayServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RailwayServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RailwayServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RailwayServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RailwayServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void viewPricing(ds.examples.maths.RequestPrices request,
        io.grpc.stub.StreamObserver<ds.examples.maths.Pricing> responseObserver) {
      asyncUnimplementedUnaryCall(getViewPricingMethod(), responseObserver);
    }

    /**
     */
    public void viewTimetable(ds.examples.maths.Stations request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getViewTimetableMethod(), responseObserver);
    }

    /**
     */
    public void amenities(ds.examples.maths.TrainNo request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainAmenities> responseObserver) {
      asyncUnimplementedUnaryCall(getAmenitiesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getViewPricingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.examples.maths.RequestPrices,
                ds.examples.maths.Pricing>(
                  this, METHODID_VIEW_PRICING)))
          .addMethod(
            getViewTimetableMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.examples.maths.Stations,
                ds.examples.maths.TrainDetails>(
                  this, METHODID_VIEW_TIMETABLE)))
          .addMethod(
            getAmenitiesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.examples.maths.TrainNo,
                ds.examples.maths.TrainAmenities>(
                  this, METHODID_AMENITIES)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayServiceStub extends io.grpc.stub.AbstractStub<RailwayServiceStub> {
    private RailwayServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayServiceStub(channel, callOptions);
    }

    /**
     */
    public void viewPricing(ds.examples.maths.RequestPrices request,
        io.grpc.stub.StreamObserver<ds.examples.maths.Pricing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getViewPricingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void viewTimetable(ds.examples.maths.Stations request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getViewTimetableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void amenities(ds.examples.maths.TrainNo request,
        io.grpc.stub.StreamObserver<ds.examples.maths.TrainAmenities> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAmenitiesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayServiceBlockingStub extends io.grpc.stub.AbstractStub<RailwayServiceBlockingStub> {
    private RailwayServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.examples.maths.Pricing viewPricing(ds.examples.maths.RequestPrices request) {
      return blockingUnaryCall(
          getChannel(), getViewPricingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.examples.maths.TrainDetails> viewTimetable(
        ds.examples.maths.Stations request) {
      return blockingServerStreamingCall(
          getChannel(), getViewTimetableMethod(), getCallOptions(), request);
    }

    /**
     */
    public ds.examples.maths.TrainAmenities amenities(ds.examples.maths.TrainNo request) {
      return blockingUnaryCall(
          getChannel(), getAmenitiesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RailwayServiceFutureStub extends io.grpc.stub.AbstractStub<RailwayServiceFutureStub> {
    private RailwayServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RailwayServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RailwayServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RailwayServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.examples.maths.Pricing> viewPricing(
        ds.examples.maths.RequestPrices request) {
      return futureUnaryCall(
          getChannel().newCall(getViewPricingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.examples.maths.TrainAmenities> amenities(
        ds.examples.maths.TrainNo request) {
      return futureUnaryCall(
          getChannel().newCall(getAmenitiesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VIEW_PRICING = 0;
  private static final int METHODID_VIEW_TIMETABLE = 1;
  private static final int METHODID_AMENITIES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RailwayServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RailwayServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VIEW_PRICING:
          serviceImpl.viewPricing((ds.examples.maths.RequestPrices) request,
              (io.grpc.stub.StreamObserver<ds.examples.maths.Pricing>) responseObserver);
          break;
        case METHODID_VIEW_TIMETABLE:
          serviceImpl.viewTimetable((ds.examples.maths.Stations) request,
              (io.grpc.stub.StreamObserver<ds.examples.maths.TrainDetails>) responseObserver);
          break;
        case METHODID_AMENITIES:
          serviceImpl.amenities((ds.examples.maths.TrainNo) request,
              (io.grpc.stub.StreamObserver<ds.examples.maths.TrainAmenities>) responseObserver);
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

  private static abstract class RailwayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RailwayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.examples.maths.RailwayServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RailwayService");
    }
  }

  private static final class RailwayServiceFileDescriptorSupplier
      extends RailwayServiceBaseDescriptorSupplier {
    RailwayServiceFileDescriptorSupplier() {}
  }

  private static final class RailwayServiceMethodDescriptorSupplier
      extends RailwayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RailwayServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RailwayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RailwayServiceFileDescriptorSupplier())
              .addMethod(getViewPricingMethod())
              .addMethod(getViewTimetableMethod())
              .addMethod(getAmenitiesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
