// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3Support.proto

package ca.railway.supportService3;

public final class SupportServiceImpl {
  private SupportServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_supportService3_complaintMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_supportService3_complaintMsg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_supportService3_complaintConfirmation_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_supportService3_complaintConfirmation_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025service3Support.proto\022\017supportService3" +
      "\"!\n\014complaintMsg\022\021\n\tcomplaint\030\001 \001(\t\"&\n\025c" +
      "omplaintConfirmation\022\r\n\005reply\030\001 \001(\t2f\n\016S" +
      "upportService\022T\n\tcomplaint\022\035.supportServ" +
      "ice3.complaintMsg\032&.supportService3.comp" +
      "laintConfirmation\"\000B2\n\032ca.railway.suppor" +
      "tService3B\022SupportServiceImplP\001b\006proto3"
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
    internal_static_supportService3_complaintMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_supportService3_complaintMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_supportService3_complaintMsg_descriptor,
        new java.lang.String[] { "Complaint", });
    internal_static_supportService3_complaintConfirmation_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_supportService3_complaintConfirmation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_supportService3_complaintConfirmation_descriptor,
        new java.lang.String[] { "Reply", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
