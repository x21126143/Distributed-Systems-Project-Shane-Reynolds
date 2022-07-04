// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3Support.proto

package ca.railway.supportService3;

/**
 * Protobuf type {@code supportService3.emergencyReportBool}
 */
public  final class emergencyReportBool extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:supportService3.emergencyReportBool)
    emergencyReportBoolOrBuilder {
private static final long serialVersionUID = 0L;
  // Use emergencyReportBool.newBuilder() to construct.
  private emergencyReportBool(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private emergencyReportBool() {
    emergency_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private emergencyReportBool(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            emergency_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ca.railway.supportService3.SupportServiceImpl.internal_static_supportService3_emergencyReportBool_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ca.railway.supportService3.SupportServiceImpl.internal_static_supportService3_emergencyReportBool_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ca.railway.supportService3.emergencyReportBool.class, ca.railway.supportService3.emergencyReportBool.Builder.class);
  }

  public static final int EMERGENCY_FIELD_NUMBER = 1;
  private boolean emergency_;
  /**
   * <code>bool emergency = 1;</code>
   */
  public boolean getEmergency() {
    return emergency_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (emergency_ != false) {
      output.writeBool(1, emergency_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (emergency_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, emergency_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ca.railway.supportService3.emergencyReportBool)) {
      return super.equals(obj);
    }
    ca.railway.supportService3.emergencyReportBool other = (ca.railway.supportService3.emergencyReportBool) obj;

    boolean result = true;
    result = result && (getEmergency()
        == other.getEmergency());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + EMERGENCY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getEmergency());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ca.railway.supportService3.emergencyReportBool parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ca.railway.supportService3.emergencyReportBool parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ca.railway.supportService3.emergencyReportBool parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ca.railway.supportService3.emergencyReportBool prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code supportService3.emergencyReportBool}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:supportService3.emergencyReportBool)
      ca.railway.supportService3.emergencyReportBoolOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ca.railway.supportService3.SupportServiceImpl.internal_static_supportService3_emergencyReportBool_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ca.railway.supportService3.SupportServiceImpl.internal_static_supportService3_emergencyReportBool_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ca.railway.supportService3.emergencyReportBool.class, ca.railway.supportService3.emergencyReportBool.Builder.class);
    }

    // Construct using ca.railway.supportService3.emergencyReportBool.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      emergency_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ca.railway.supportService3.SupportServiceImpl.internal_static_supportService3_emergencyReportBool_descriptor;
    }

    @java.lang.Override
    public ca.railway.supportService3.emergencyReportBool getDefaultInstanceForType() {
      return ca.railway.supportService3.emergencyReportBool.getDefaultInstance();
    }

    @java.lang.Override
    public ca.railway.supportService3.emergencyReportBool build() {
      ca.railway.supportService3.emergencyReportBool result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ca.railway.supportService3.emergencyReportBool buildPartial() {
      ca.railway.supportService3.emergencyReportBool result = new ca.railway.supportService3.emergencyReportBool(this);
      result.emergency_ = emergency_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ca.railway.supportService3.emergencyReportBool) {
        return mergeFrom((ca.railway.supportService3.emergencyReportBool)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ca.railway.supportService3.emergencyReportBool other) {
      if (other == ca.railway.supportService3.emergencyReportBool.getDefaultInstance()) return this;
      if (other.getEmergency() != false) {
        setEmergency(other.getEmergency());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ca.railway.supportService3.emergencyReportBool parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ca.railway.supportService3.emergencyReportBool) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean emergency_ ;
    /**
     * <code>bool emergency = 1;</code>
     */
    public boolean getEmergency() {
      return emergency_;
    }
    /**
     * <code>bool emergency = 1;</code>
     */
    public Builder setEmergency(boolean value) {
      
      emergency_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool emergency = 1;</code>
     */
    public Builder clearEmergency() {
      
      emergency_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:supportService3.emergencyReportBool)
  }

  // @@protoc_insertion_point(class_scope:supportService3.emergencyReportBool)
  private static final ca.railway.supportService3.emergencyReportBool DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ca.railway.supportService3.emergencyReportBool();
  }

  public static ca.railway.supportService3.emergencyReportBool getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<emergencyReportBool>
      PARSER = new com.google.protobuf.AbstractParser<emergencyReportBool>() {
    @java.lang.Override
    public emergencyReportBool parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new emergencyReportBool(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<emergencyReportBool> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<emergencyReportBool> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ca.railway.supportService3.emergencyReportBool getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
