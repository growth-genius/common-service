package com.sgyj.commonservice.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class JasyptConfig {

    @Bean( "jasyptStringEncryptor" )
    public StringEncryptor stringEncryptor ( Environment environment ) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword( environment.getProperty( "jasypt.encryptor.password", "travelencryptor" ) );
        config.setAlgorithm( "PBEWithSHA1AndDESede" );
        config.setKeyObtentionIterations( "1000" );
        config.setPoolSize( "1" );
        config.setSaltGeneratorClassName( "org.jasypt.salt.RandomSaltGenerator" );
        config.setStringOutputType( "base64" );
        encryptor.setConfig( config );
        return encryptor;
    }
}
