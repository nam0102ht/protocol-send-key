package com.mservice.services;

import com.mservice.gen.AliceToBob.Ping;
import com.mservice.gen.AliceToBob.Pong;
import com.mservice.gen.AliceToBob.sendMessageToBobGrpc;
import io.grpc.stub.StreamObserver;
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
public class PingPongService extends sendMessageToBobGrpc.sendMessageToBobImplBase{
    private static PingPongService INSTANCE;

    private final static String SECRET_KEY_ALICE = "12345678";
    private final static String SECRET_KEY_BOB = "87654321";

    public PingPongService() {}

    public static PingPongService getInstance() {
        if(INSTANCE == null) INSTANCE = new PingPongService();
        return INSTANCE;
    }

    @Override
    public void sendToAlice(Ping request, StreamObserver<Pong> responseObserver) {
        if(request.getMessage() != null){
            String plainText = decrypt(request.getMessage().getBytes(), SECRET_KEY_ALICE);
            log.info(plainText);
            if(plainText != null) {
                sendToBob(Ping.newBuilder().setMessage(encrypt(plainText, SECRET_KEY_BOB)).build(), new StreamObserver<Pong>() {
                    @Override
                    public void onNext(Pong value) {
                        log.info(value.getMessage());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
                log.info("SendToBob: "+plainText);
            }
        }
    }

    @Override
    public void sendToBob(Ping request, StreamObserver<Pong> responseObserver) {
        String plainText = decrypt(request.getMessage().getBytes(), SECRET_KEY_ALICE);
        log.info(plainText);
        Pong ping = Pong.newBuilder().setMessage(encrypt(plainText, SECRET_KEY_BOB)).build();
        responseObserver.onNext(ping);
    }

    public String encrypt(String plainText, String KEY) {
        Cipher cipher = null;
        String encrypted = "";
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), "DES");
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
    public String decrypt(byte[] encrypted, String KEY) {
        Cipher cipher = null;
        String decrypted = "";
        SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes(), "DES");
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
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
