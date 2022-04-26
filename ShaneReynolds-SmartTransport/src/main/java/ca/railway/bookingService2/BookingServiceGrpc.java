package ca.railway.bookingService2;

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
public final class BookingServiceGrpc {

  private BookingServiceGrpc() {}

  public static final String SERVICE_NAME = "ca.railway.bookingService2.BookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ca.railway.bookingService2.LoginRequest,
      ca.railway.bookingService2.LoginReply> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = ca.railway.bookingService2.LoginRequest.class,
      responseType = ca.railway.bookingService2.LoginReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ca.railway.bookingService2.LoginRequest,
      ca.railway.bookingService2.LoginReply> getLoginMethod() {
    io.grpc.MethodDescriptor<ca.railway.bookingService2.LoginRequest, ca.railway.bookingService2.LoginReply> getLoginMethod;
    if ((getLoginMethod = BookingServiceGrpc.getLoginMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getLoginMethod = BookingServiceGrpc.getLoginMethod) == null) {
          BookingServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<ca.railway.bookingService2.LoginRequest, ca.railway.bookingService2.LoginReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ca.railway.bookingService2.BookingService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.bookingService2.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.bookingService2.LoginReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ca.railway.bookingService2.BookingRequest,
      ca.railway.bookingService2.BookingReply> getMakeBookingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "makeBookings",
      requestType = ca.railway.bookingService2.BookingRequest.class,
      responseType = ca.railway.bookingService2.BookingReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ca.railway.bookingService2.BookingRequest,
      ca.railway.bookingService2.BookingReply> getMakeBookingsMethod() {
    io.grpc.MethodDescriptor<ca.railway.bookingService2.BookingRequest, ca.railway.bookingService2.BookingReply> getMakeBookingsMethod;
    if ((getMakeBookingsMethod = BookingServiceGrpc.getMakeBookingsMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getMakeBookingsMethod = BookingServiceGrpc.getMakeBookingsMethod) == null) {
          BookingServiceGrpc.getMakeBookingsMethod = getMakeBookingsMethod = 
              io.grpc.MethodDescriptor.<ca.railway.bookingService2.BookingRequest, ca.railway.bookingService2.BookingReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ca.railway.bookingService2.BookingService", "makeBookings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.bookingService2.BookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.railway.bookingService2.BookingReply.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("makeBookings"))
                  .build();
          }
        }
     }
     return getMakeBookingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingServiceStub newStub(io.grpc.Channel channel) {
    return new BookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookingServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class BookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(ca.railway.bookingService2.LoginRequest request,
        io.grpc.stub.StreamObserver<ca.railway.bookingService2.LoginReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void makeBookings(ca.railway.bookingService2.BookingRequest request,
        io.grpc.stub.StreamObserver<ca.railway.bookingService2.BookingReply> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeBookingsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.railway.bookingService2.LoginRequest,
                ca.railway.bookingService2.LoginReply>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getMakeBookingsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.railway.bookingService2.BookingRequest,
                ca.railway.bookingService2.BookingReply>(
                  this, METHODID_MAKE_BOOKINGS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BookingServiceStub extends io.grpc.stub.AbstractStub<BookingServiceStub> {
    private BookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(ca.railway.bookingService2.LoginRequest request,
        io.grpc.stub.StreamObserver<ca.railway.bookingService2.LoginReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeBookings(ca.railway.bookingService2.BookingRequest request,
        io.grpc.stub.StreamObserver<ca.railway.bookingService2.BookingReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeBookingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BookingServiceBlockingStub extends io.grpc.stub.AbstractStub<BookingServiceBlockingStub> {
    private BookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ca.railway.bookingService2.LoginReply login(ca.railway.bookingService2.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public ca.railway.bookingService2.BookingReply makeBookings(ca.railway.bookingService2.BookingRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeBookingsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class BookingServiceFutureStub extends io.grpc.stub.AbstractStub<BookingServiceFutureStub> {
    private BookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.railway.bookingService2.LoginReply> login(
        ca.railway.bookingService2.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.railway.bookingService2.BookingReply> makeBookings(
        ca.railway.bookingService2.BookingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeBookingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_MAKE_BOOKINGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((ca.railway.bookingService2.LoginRequest) request,
              (io.grpc.stub.StreamObserver<ca.railway.bookingService2.LoginReply>) responseObserver);
          break;
        case METHODID_MAKE_BOOKINGS:
          serviceImpl.makeBookings((ca.railway.bookingService2.BookingRequest) request,
              (io.grpc.stub.StreamObserver<ca.railway.bookingService2.BookingReply>) responseObserver);
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

  private static abstract class BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ca.railway.bookingService2.BookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookingService");
    }
  }

  private static final class BookingServiceFileDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier {
    BookingServiceFileDescriptorSupplier() {}
  }

  private static final class BookingServiceMethodDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getMakeBookingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
