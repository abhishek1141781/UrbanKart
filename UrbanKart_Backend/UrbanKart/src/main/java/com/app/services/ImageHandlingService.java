package com.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;



public interface ImageHandlingService {
	String uploadImage(Long empId, MultipartFile imageFile) throws IOException;
	byte[] serveImage(Long empId) throws IOException;
}
