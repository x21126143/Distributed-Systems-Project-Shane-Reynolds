// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2Booking.proto

package ca.railway.bookingService2;

/**
 * Protobuf type {@code bookingService2.Booking}
 */
public  final class Booking extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bookingService2.Booking)
    BookingOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Booking.newBuilder() to construct.
  private Booking(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Booking() {
    trainNo_ = "";
    specialRequestMsg_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Booking(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            trainNo_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            specialRequestMsg_ = s;
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
    return ca.railway.bookingService2.BookingServiceImpl.internal_static_bookingService2_Booking_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ca.railway.bookingService2.BookingServiceImpl.internal_static_bookingService2_Booking_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ca.railway.bookingService2.Booking.class, ca.railway.bookingService2.Booking.Builder.class);
  }

  public static final int TRAINNO_FIELD_NUMBER = 1;
  private volatile java.lang.Object trainNo_;
  /**
   * <code>string trainNo = 1;</code>
   */
  public java.lang.String getTrainNo() {
    java.lang.Object ref = trainNo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      trainNo_ = s;
      return s;
    }
  }
  /**
   * <code>string trainNo = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTrainNoBytes() {
    java.lang.Object ref = trainNo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      trainNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SPECIALREQUESTMSG_FIELD_NUMBER = 2;
  private volatile java.lang.Object specialRequestMsg_;
  /**
   * <code>string specialRequestMsg = 2;</code>
   */
  public java.lang.String getSpecialRequestMsg() {
    java.lang.Object ref = specialRequestMsg_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      specialRequestMsg_ = s;
      return s;
    }
  }
  /**
   * <code>string specialRequestMsg = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSpecialRequestMsgBytes() {
    java.lang.Object ref = specialRequestMsg_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      specialRequestMsg_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getTrainNoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, trainNo_);
    }
    if (!getSpecialRequestMsgBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, specialRequestMsg_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTrainNoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, trainNo_);
    }
    if (!getSpecialRequestMsgBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, specialRequestMsg_);
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
    if (!(obj instanceof ca.railway.bookingService2.Booking)) {
      return super.equals(obj);
    }
    ca.railway.bookingService2.Booking other = (ca.railway.bookingService2.Booking) obj;

    boolean result = true;
    result = result && getTrainNo()
        .equals(other.getTrainNo());
    result = result && getSpecialRequestMsg()
        .equals(other.getSpecialRequestMsg());
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
    hash = (37 * hash) + TRAINNO_FIELD_NUMBER;
    hash = (53 * hash) + getTrainNo().hashCode();
    hash = (37 * hash) + SPECIALREQUESTMSG_FIELD_NUMBER;
    hash = (53 * hash) + getSpecialRequestMsg().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ca.railway.bookingService2.Booking parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.bookingService2.Booking parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ca.railway.bookingService2.Booking parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ca.railway.bookingService2.Booking parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ca.railway.bookingService2.Booking parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ca.railway.bookingService2.Booking parseFrom(
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
  public static Builder newBuilder(ca.railway.bookingService2.Booking prototype) {
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
   * Protobuf type {@code bookingService2.Booking}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bookingService2.Booking)
      ca.railway.bookingService2.BookingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ca.railway.bookingService2.BookingServiceImpl.internal_static_bookingService2_Booking_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ca.railway.bookingService2.BookingServiceImpl.internal_static_bookingService2_Booking_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ca.railway.bookingService2.Booking.class, ca.railway.bookingService2.Booking.Builder.class);
    }

    // Construct using ca.railway.bookingService2.Booking.newBuilder()
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
      trainNo_ = "";

      specialRequestMsg_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ca.railway.bookingService2.BookingServiceImpl.internal_static_bookingService2_Booking_descriptor;
    }

    @java.lang.Override
    public ca.railway.bookingService2.Booking getDefaultInstanceForType() {
      return ca.railway.bookingService2.Booking.getDefaultInstance();
    }

    @java.lang.Override
    public ca.railway.bookingService2.Booking build() {
      ca.railway.bookingService2.Booking result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ca.railway.bookingService2.Booking buildPartial() {
      ca.railway.bookingService2.Booking result = new ca.railway.bookingService2.Booking(this);
      result.trainNo_ = trainNo_;
      result.specialRequestMsg_ = specialRequestMsg_;
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
      if (other instanceof ca.railway.bookingService2.Booking) {
        return mergeFrom((ca.railway.bookingService2.Booking)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ca.railway.bookingService2.Booking other) {
      if (other == ca.railway.bookingService2.Booking.getDefaultInstance()) return this;
      if (!other.getTrainNo().isEmpty()) {
        trainNo_ = other.trainNo_;
        onChanged();
      }
      if (!other.getSpecialRequestMsg().isEmpty()) {
        specialRequestMsg_ = other.specialRequestMsg_;
        onChanged();
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
      ca.railway.bookingService2.Booking parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ca.railway.bookingService2.Booking) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object trainNo_ = "";
    /**
     * <code>string trainNo = 1;</code>
     */
    public java.lang.String getTrainNo() {
      java.lang.Object ref = trainNo_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        trainNo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string trainNo = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTrainNoBytes() {
      java.lang.Object ref = trainNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        trainNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string trainNo = 1;</code>
     */
    public Builder setTrainNo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      trainNo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string trainNo = 1;</code>
     */
    public Builder clearTrainNo() {
      
      trainNo_ = getDefaultInstance().getTrainNo();
      onChanged();
      return this;
    }
    /**
     * <code>string trainNo = 1;</code>
     */
    public Builder setTrainNoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      trainNo_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object specialRequestMsg_ = "";
    /**
     * <code>string specialRequestMsg = 2;</code>
     */
    public java.lang.String getSpecialRequestMsg() {
      java.lang.Object ref = specialRequestMsg_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        specialRequestMsg_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string specialRequestMsg = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSpecialRequestMsgBytes() {
      java.lang.Object ref = specialRequestMsg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        specialRequestMsg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string specialRequestMsg = 2;</code>
     */
    public Builder setSpecialRequestMsg(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      specialRequestMsg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string specialRequestMsg = 2;</code>
     */
    public Builder clearSpecialRequestMsg() {
      
      specialRequestMsg_ = getDefaultInstance().getSpecialRequestMsg();
      onChanged();
      return this;
    }
    /**
     * <code>string specialRequestMsg = 2;</code>
     */
    public Builder setSpecialRequestMsgBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      specialRequestMsg_ = value;
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


    // @@protoc_insertion_point(builder_scope:bookingService2.Booking)
  }

  // @@protoc_insertion_point(class_scope:bookingService2.Booking)
  private static final ca.railway.bookingService2.Booking DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ca.railway.bookingService2.Booking();
  }

  public static ca.railway.bookingService2.Booking getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Booking>
      PARSER = new com.google.protobuf.AbstractParser<Booking>() {
    @java.lang.Override
    public Booking parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Booking(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Booking> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Booking> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ca.railway.bookingService2.Booking getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

