// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: gid.proto

package com.guochenxu.gid.protobuf.java.com.guochenxu.gid.protobuf;

public final class GIDServiceApi {
  private GIDServiceApi() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_PingReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_PingReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_PingResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_PingResp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_CreateTagReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_CreateTagReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_CreateTagResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_CreateTagResp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_GetIdReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_GetIdReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_GetIdResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_GetIdResp_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_GetSnowId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_GetSnowId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_guochenxu_gid_protobuf_GetSnowIdResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_guochenxu_gid_protobuf_GetSnowIdResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\tgid.proto\022\032com.guochenxu.gid.protobuf\"" +
      "\t\n\007PingReq\"\033\n\010PingResp\022\017\n\007message\030\001 \001(\t\"" +
      "K\n\014CreateTagReq\022\013\n\003tag\030\001 \001(\t\022\017\n\007startId\030" +
      "\002 \001(\003\022\014\n\004step\030\003 \001(\003\022\017\n\007comment\030\004 \001(\t\" \n\r" +
      "CreateTagResp\022\017\n\007success\030\001 \001(\010\"\027\n\010GetIdR" +
      "eq\022\013\n\003tag\030\001 \001(\t\"\027\n\tGetIdResp\022\n\n\002id\030\001 \001(\003" +
      "\"\013\n\tGetSnowId\"\033\n\rGetSnowIdResp\022\n\n\002id\030\001 \001" +
      "(\0032\372\002\n\016RPCDateService\022Q\n\004ping\022#.com.guoc" +
      "henxu.gid.protobuf.PingReq\032$.com.guochen" +
      "xu.gid.protobuf.PingResp\022`\n\tcreateTag\022(." +
      "com.guochenxu.gid.protobuf.CreateTagReq\032" +
      ").com.guochenxu.gid.protobuf.CreateTagRe" +
      "sp\022T\n\005getId\022$.com.guochenxu.gid.protobuf" +
      ".GetIdReq\032%.com.guochenxu.gid.protobuf.G" +
      "etIdResp\022]\n\tgetSnowId\022%.com.guochenxu.gi" +
      "d.protobuf.GetSnowId\032).com.guochenxu.gid" +
      ".protobuf.GetSnowIdRespB-\n\032com.guochenxu" +
      ".gid.protobufB\rGIDServiceApiP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_guochenxu_gid_protobuf_PingReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_guochenxu_gid_protobuf_PingReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_PingReq_descriptor,
        new String[] { });
    internal_static_com_guochenxu_gid_protobuf_PingResp_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_guochenxu_gid_protobuf_PingResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_PingResp_descriptor,
        new String[] { "Message", });
    internal_static_com_guochenxu_gid_protobuf_CreateTagReq_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_guochenxu_gid_protobuf_CreateTagReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_CreateTagReq_descriptor,
        new String[] { "Tag", "StartId", "Step", "Comment", });
    internal_static_com_guochenxu_gid_protobuf_CreateTagResp_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_guochenxu_gid_protobuf_CreateTagResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_CreateTagResp_descriptor,
        new String[] { "Success", });
    internal_static_com_guochenxu_gid_protobuf_GetIdReq_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_guochenxu_gid_protobuf_GetIdReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_GetIdReq_descriptor,
        new String[] { "Tag", });
    internal_static_com_guochenxu_gid_protobuf_GetIdResp_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_guochenxu_gid_protobuf_GetIdResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_GetIdResp_descriptor,
        new String[] { "Id", });
    internal_static_com_guochenxu_gid_protobuf_GetSnowId_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_guochenxu_gid_protobuf_GetSnowId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_GetSnowId_descriptor,
        new String[] { });
    internal_static_com_guochenxu_gid_protobuf_GetSnowIdResp_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_guochenxu_gid_protobuf_GetSnowIdResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_guochenxu_gid_protobuf_GetSnowIdResp_descriptor,
        new String[] { "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}