// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2Booking.proto

package ca.railway.bookingService2;

public final class BookingServiceImpl {
  private BookingServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bookingService2_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bookingService2_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bookingService2_LoginReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bookingService2_LoginReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bookingService2_Booking_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bookingService2_Booking_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025service2Booking.proto\022\017bookingService2" +
      "\"2\n\014LoginRequest\022\020\n\010username\030\001 \001(\t\022\020\n\010pa" +
      "ssword\030\002 \001(\t\"\035\n\nLoginReply\022\017\n\007message\030\001 " +
      "\001(\t\"5\n\007Booking\022\017\n\007trainNo\030\001 \001(\005\022\031\n\021speci" +
      "alRequestMsg\030\002 \001(\t2\237\001\n\016BookingService\022E\n" +
      "\005login\022\035.bookingService2.LoginRequest\032\033." +
      "bookingService2.LoginReply\"\000\022F\n\014makeBook" +
      "ings\022\030.bookingService2.Booking\032\030.booking" +
      "Service2.Booking\"\000(\001B2\n\032ca.railway.booki" +
      "ngService2B\022BookingServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_bookingService2_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_bookingService2_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bookingService2_LoginRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_bookingService2_LoginReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_bookingService2_LoginReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bookingService2_LoginReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_bookingService2_Booking_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_bookingService2_Booking_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bookingService2_Booking_descriptor,
        new java.lang.String[] { "TrainNo", "SpecialRequestMsg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
