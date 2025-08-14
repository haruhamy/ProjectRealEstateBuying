package com.javaweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//Đánh dấu đây là nơi chứa các Bean và các thiết lập cấu hình ứng dụng, khai báo class này chứa được nhiều bean thay vì chỉ 1 bean
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper(); // Tạo và trả về instance ModelMapper
	}
}
