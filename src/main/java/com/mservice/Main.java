package com.mservice;

import com.mservice.verticle.MainVerticle;
import io.vertx.core.Vertx;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        log.info("----------------START-GRPC----------------");
        log.info("|          () ()     /)/)    (|(|        |");
        log.info("|          (^.^)    ( @.@)   (o.o)       |");
        log.info("|                                        |");
        log.info("------------------------------------------");
        vertx.deployVerticle(new MainVerticle());
    }
}
