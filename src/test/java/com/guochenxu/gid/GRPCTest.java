package com.guochenxu.gid;

import com.guochenxu.gid.protobuf.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * gRPC测试
 *
 * @author: 郭晨旭
 * @create: 2024-01-11 12:42
 * @version: 1.0
 */
@SpringBootTest
@Slf4j
public class GRPCTest {

    @GrpcClient("grpc-server")
    private RPCDateServiceGrpc.RPCDateServiceBlockingStub gIdService;


    @Test
    public void testPing() {
        PingResp pingResp = gIdService.ping(PingReq.newBuilder().build());
        log.info("gRPC返回结果: {}", pingResp.getMessage());
    }

    @Test
    public void testCreateTag() {
        CreateTagReq request = CreateTagReq.newBuilder()
                .setTag("rpc-test")
                .setStartId(1)
                .setStep(2000)
                .setComment("comment")
                .build();
        CreateTagResp resp = gIdService.createTag(request);
        log.info("gRPC返回结果: {}", resp);
    }

    @Test
    public void testGetId() {
        GetIdReq req = GetIdReq.newBuilder().setTag("rpc-test").build();
        GetIdResp resp = gIdService.getId(req);
        log.info("gRPC返回结果: {}", resp.getId());
    }

    @Test
    public void testGetSnowId() {
        GetSnowIdResp resp = gIdService.getSnowId(GetSnowId.newBuilder().build());
        log.info("gRPC返回结果: {}", resp.getId());
    }
}
