package com.mservice;

import com.mservice.gen.AliceToBob.Ping;
import com.mservice.gen.AliceToBob.Pong;
import com.mservice.gen.AliceToBob.sendMessageToBobGrpc;
import com.mservice.services.BobToAlice;
import com.mservice.verticle.AliceVerticle;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import io.vertx.core.Vertx;
import io.vertx.grpc.VertxChannelBuilder;
import lombok.extern.log4j.Log4j2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Log4j2
public class Alice {

    private final static String SERECT_KEY = "12345678";

    public static void main(String[] args) {
        log.info("----------------START-Alice---------------");
        log.info("|          () ()     /)/)    (|(|        |");
        log.info("|          (^.^)    ( @.@)   (o.o)       |");
        log.info("|                                        |");
        log.info("------------------------------------------");
        ManagedChannel channel = VertxChannelBuilder
                .forAddress(Vertx.vertx(), "0.0.0.0", 50055)
                .usePlaintext(true)
                .build();

        // Get a stub to use for interacting with the remote service
        sendMessageToBobGrpc.sendMessageToBobStub stub = sendMessageToBobGrpc.newStub(channel);

        Ping ping = Ping.newBuilder().setMessage(encrypt("stackjava.com")).build();
        Vertx.vertx().setPeriodic(100, handler -> {
            stub.sendToAlice(ping, new StreamObserver<Pong>() {
                @Override
                public void onNext(Pong value) {

                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    System.out.println("Success");
                }
            });
        });

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new AliceVerticle());
    }

    public static String encrypt(String plainText) {
        Cipher cipher = null;
        String encrypted = "";
        SecretKeySpec skeySpec = new SecretKeySpec(SERECT_KEY.getBytes(), "DES");
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] byteEncrypted = cipher.doFinal(plainText.getBytes());
            encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException |
                IllegalBlockSizeException | InvalidKeyException  e) {
            log.error(e.getMessage());
        }
        return encrypted;
    }
    public static String decrypt(byte[] encrypted) {
        Cipher cipher = null;
        String decrypted = "";
        SecretKeySpec skeySpec = new SecretKeySpec(SERECT_KEY.getBytes(), "DES");
        try {
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] byteDecrypted = cipher.doFinal(encrypted);
            decrypted = new String(byteDecrypted);
        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException  e) {
            log.error(e.getMessage());
        }
        return decrypted;
    }
}
