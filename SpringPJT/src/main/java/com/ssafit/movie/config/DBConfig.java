package com.ssafit.movie.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafit.movie.dao")
public class DBConfig {
}