// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bookingService.proto

package ds.bookingService;

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
    internal_static_ds_bookingService_RequestMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_bookingService_RequestMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ds_bookingService_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ds_bookingService_ResponseMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024bookingService.proto\022\021ds.bookingServic" +
      "e\"\036\n\016RequestMessage\022\014\n\004text\030\001 \001(\t\"!\n\017Res" +
      "ponseMessage\022\016\n\006length\030\001 \001(\0052b\n\016bookingS" +
      "ervice\022P\n\005login\022!.ds.bookingService.Requ" +
      "estMessage\032\".ds.bookingService.ResponseM" +
      "essage\"\000B)\n\021ds.bookingServiceB\022BookingSe" +
      "rviceImplP\001b\006proto3"
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
    internal_static_ds_bookingService_RequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ds_bookingService_RequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_bookingService_RequestMessage_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_ds_bookingService_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_ds_bookingService_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ds_bookingService_ResponseMessage_descriptor,
        new java.lang.String[] { "Length", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
