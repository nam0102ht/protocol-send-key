package com.mservice;

import com.mservice.gen.AliceToBob.Ping;
import com.mservice.gen.AliceToBob.Pong;
import com.mservice.gen.AliceToBob.sendMessageToBobGrpc;
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
public class Bob {
    private final static String SECRET_KEY_BOB = "87654321";
    public static void main(String[] args) {
        log.info("----------------START-Bob----------------");
        log.info("|          () ()     /)/)    (|(|        |");
        log.info("|          (^.^)    ( @.@)   (o.o)       |");
        log.info("|                                        |");
        log.info("------------------------------------------");
        ManagedChannel channel = VertxChannelBuilder
                .forAddress(Vertx.vertx(), "0.0.0.0", 50055)
                .usePlaintext(true)
                .build();
        ManagedChannel channel2 = VertxChannelBuilder
                .forAddress(Vertx.vertx(), "0.0.0.0", 50054)
                .usePlaintext(true)
                .build();
        // Get a stub to use for interacting with the remote service
        sendMessageToBobGrpc.sendMessageToBobStub stub = sendMessageToBobGrpc.newStub(channel);
        com.mservice.gen.BobToAlice.sendMessageToBobGrpc.sendMessageToBobStub stub2 =
                com.mservice.gen.BobToAlice.sendMessageToBobGrpc.newStub(channel2);

        stub.sendToBob(Ping.newBuilder().setMessage("Hello").build(), new StreamObserver<Pong>() {
            @Override
            public void onNext(Pong value) {
                String plainText = decrypt(value.getMessage().getBytes(), SECRET_KEY_BOB);
                log.info("plain text: "+plainText);
                com.mservice.gen.BobToAlice.Ping ping =
                        com.mservice.gen.BobToAlice.Ping.newBuilder().setMessage("Hi Alice, I'm Bob, your key K ={"+plainText+"}").build();
                stub2.sendToAlice(ping, new StreamObserver<com.mservice.gen.BobToAlice.Pong>() {
                    @Override
                    public void onNext(com.mservice.gen.BobToAlice.Pong value) {
                        log.info(value.getMessage());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });

    }
    public static String decrypt(byte[] encrypted, String KEY) {
        String decrypted = "";
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), "DES");
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] byteDecrypted64 = Base64.getDecoder().decode(encrypted);
            byte[] byteDecrypted = cipher.doFinal(byteDecrypted64);
            decrypted = new String(byteDecrypted);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException  e) {
            log.error(e.getMessage());
        }
        return decrypted;
    }
}
