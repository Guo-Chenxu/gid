package com.guochenxu.gid.gRPC;

import com.guochenxu.gid.entity.IdSegment;
import com.guochenxu.gid.protobuf.*;
import com.guochenxu.gid.service.GIdService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

/**
 * gid的gRpc服务接口
 *
 * @author: 郭晨旭
 * @create: 2024-01-11 13:12
 * @version: 1.0
 */
@GrpcService
@Slf4j
public class GidRpcService extends RPCDateServiceGrpc.RPCDateServiceImplBase {

    @Resource
    private GIdService gIdService;

    @Override
    public void ping(PingReq request, StreamObserver<PingResp> responseObserver) {
        String pong = gIdService.ping();
        PingResp resp = PingResp.newBuilder().setMessage(pong).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void createTag(CreateTagReq request, StreamObserver<CreateTagResp> responseObserver) {
        IdSegment idSegment = IdSegment.builder().tag(request.getTag())
                .startId(request.getStartId()).step(request.getStep())
                .comment(request.getComment()).build();
        CreateTagResp resp = CreateTagResp.newBuilder().setSuccess(gIdService.createTag(idSegment)).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void getId(GetIdReq request, StreamObserver<GetIdResp> responseObserver) {
        String tag = request.getTag();
        long id = gIdService.getId(tag);
        GetIdResp resp = GetIdResp.newBuilder().setId(id).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }

    @Override
    public void getSnowId(GetSnowId request, StreamObserver<GetSnowIdResp> responseObserver) {
        long id = gIdService.getSnowId();
        GetSnowIdResp resp = GetSnowIdResp.newBuilder().setId(id).build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
