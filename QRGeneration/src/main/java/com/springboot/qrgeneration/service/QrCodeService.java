package com.springboot.qrgeneration.service;

import java.io.IOException;

import com.google.zxing.WriterException;

public interface QrCodeService {

    byte[] generateQRCodeImage(String text, int width, int height) throws IOException, WriterException;
}
