// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fromBobtoAlice.proto

package com.mservice.gen.BobToAlice;

public final class GrpcServer {
  private GrpcServer() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mservice_gen_BobToAlice_Ping_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mservice_gen_BobToAlice_Ping_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_mservice_gen_BobToAlice_Pong_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_mservice_gen_BobToAlice_Pong_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024fromBobtoAlice.proto\022\033com.mservice.gen" +
      ".BobToAlice\"\027\n\004Ping\022\017\n\007message\030\001 \001(\t\"\027\n\004" +
      "Pong\022\017\n\007message\030\001 \001(\t2\302\001\n\020sendMessageToB" +
      "ob\022U\n\013sendToAlice\022!.com.mservice.gen.Bob" +
      "ToAlice.Ping\032!.com.mservice.gen.BobToAli" +
      "ce.Pong\"\000\022W\n\tsendToBob\022!.com.mservice.ge" +
      "n.BobToAlice.Ping\032!.com.mservice.gen.Bob" +
      "ToAlice.Pong\"\000(\0010\001B+\n\033com.mservice.gen.B" +
      "obToAliceB\nGrpcServerP\001b\006proto3"
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
    internal_static_com_mservice_gen_BobToAlice_Ping_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_mservice_gen_BobToAlice_Ping_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mservice_gen_BobToAlice_Ping_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_com_mservice_gen_BobToAlice_Pong_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_mservice_gen_BobToAlice_Pong_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_mservice_gen_BobToAlice_Pong_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}