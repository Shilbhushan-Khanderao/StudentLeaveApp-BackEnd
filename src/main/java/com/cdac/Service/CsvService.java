package com.cdac.Service;

import org.springframework.web.multipart.MultipartFile;

public interface CsvService {
	public void save(MultipartFile file);
}
