// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2Booking.proto

package ca.railway.timetableService1;

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
    internal_static_timetableService1_LoginRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_timetableService1_LoginRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_timetableService1_LoginReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_timetableService1_LoginReply_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_timetableService1_BookingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_timetableService1_BookingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_timetableService1_BookingConfirmationMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_timetableService1_BookingConfirmationMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025service2Booking.proto\022\021timetableServic" +
      "e1\"2\n\014LoginRequest\022\020\n\010username\030\001 \001(\t\022\020\n\010" +
      "password\030\002 \001(\t\"\035\n\nLoginReply\022\017\n\007message\030" +
      "\001 \001(\t\"9\n\016BookingRequest\022\017\n\007trainNo\030\001 \001(\005" +
      "\022\026\n\016specialRequest\030\002 \001(\t\"Y\n\026BookingConfi" +
      "rmationMsg\022\021\n\tbookingNo\030\001 \001(\005\022\017\n\007trainNo" +
      "\030\002 \001(\005\022\033\n\023specialRequestReply\030\003 \001(\t2\270\001\n\016" +
      "BookingService\022I\n\005login\022\037.timetableServi" +
      "ce1.LoginRequest\032\035.timetableService1.Log" +
      "inReply\"\000\022[\n\007booking\022!.timetableService1" +
      ".BookingRequest\032).timetableService1.Book" +
      "ingConfirmationMsg\"\000(\001B4\n\034ca.railway.tim" +
      "etableService1B\022BookingServiceImplP\001b\006pr" +
      "oto3"
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
    internal_static_timetableService1_LoginRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_timetableService1_LoginRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_timetableService1_LoginRequest_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_timetableService1_LoginReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_timetableService1_LoginReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_timetableService1_LoginReply_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_timetableService1_BookingRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_timetableService1_BookingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_timetableService1_BookingRequest_descriptor,
        new java.lang.String[] { "TrainNo", "SpecialRequest", });
    internal_static_timetableService1_BookingConfirmationMsg_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_timetableService1_BookingConfirmationMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_timetableService1_BookingConfirmationMsg_descriptor,
        new java.lang.String[] { "BookingNo", "TrainNo", "SpecialRequestReply", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}